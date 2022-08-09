package thecsdev.logicgates.block.wires;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLogicGateBlock;
import thecsdev.logicgates.block.AbstractMultiIOGateBlock;

public class LogicGateCrossWireBlock extends AbstractMultiIOGateBlock
{
	// ==================================================
	public static final BooleanProperty SWAPPED_DIR = AbstractLogicGateBlock.SWAPPED_DIR;
	// ==================================================
	public LogicGateCrossWireBlock() { setDefaultState(getDefaultState().with(SWAPPED_DIR, false)); }
	
	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(SWAPPED_DIR);
		stateManager.add(POWERED_E);
		stateManager.add(POWERED_W);
		stateManager.add(POWERED_N);
    }
	
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
	{
		//check adventure mode and stuff, and
		//check if supports switching
		if (!player.getAbilities().allowModifyWorld)
			return ActionResult.PASS;
		
		//toggle swapped direction
		state = state.cycle(SWAPPED_DIR);
		world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 0.3f, 1);
		world.setBlockState(pos, state, 0);
		scheduleTick(world, pos, 2);
		//world.updateNeighborsAlways(pos, this);
		
		//return
		return ActionResult.success(world.isClient);
	}
	// --------------------------------------------------
	@Override
	public String getBlockIdPath() { return "wire_cross"; }
	
	@Override
	public boolean dustConnectsToThis(BlockState state, Direction dir) { return true; }
	// ==================================================
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
	{
		Direction facing = state.get(FACING);
		Direction fCW = facing.rotateYClockwise();
		Direction fCCW = facing.rotateYCounterclockwise();
		
		BlockState newState = state.with(POWERED_N, getInputLevel(world, pos.offset(facing), facing) > 0);
		if(!state.get(SWAPPED_DIR))
			newState = newState.with(POWERED_W, false).with(POWERED_E, getInputLevel(world, pos.offset(fCW), fCW) > 0);
		else
			newState = newState.with(POWERED_E, false).with(POWERED_W, getInputLevel(world, pos.offset(fCCW), fCCW) > 0);
		
		world.setBlockState(pos, newState, NOTIFY_ALL);
	}
	// --------------------------------------------------
	/*@Override
	public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		return state.getWeakRedstonePower(world, pos, direction);
	}
	
	@Override
	public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		//get required stuff
		if(!(world instanceof WorldView)) return 0; //shouldn't happen, like... ever.
		Direction facing = state.get(FACING);
		WorldView worldView = (WorldView)world;
		
		Direction fCW = facing.rotateYClockwise();
		Direction fCCW = facing.rotateYCounterclockwise();
		
		//handle cross wire
		if(direction == facing)
			return getInputLevel(worldView, pos.offset(direction), direction) > 0 ? 15 : 0;
		else if(direction == fCW || direction == fCCW)
		{
			//not swapped (->)
			if(!state.get(SWAPPED_DIR) && direction == fCW)
				return getInputLevel(worldView, pos.offset(fCW), fCW) > 0 ? 15 : 0;
				
			//swapped (<-)
			else if(state.get(SWAPPED_DIR) && direction == fCCW)
				return getInputLevel(worldView, pos.offset(fCCW), fCCW) > 0 ? 15 : 0;
		}
		
		//default: 0
	    return 0;
	}*/
	// ==================================================
}