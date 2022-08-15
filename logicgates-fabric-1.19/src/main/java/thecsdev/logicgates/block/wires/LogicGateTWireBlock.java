package thecsdev.logicgates.block.wires;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import thecsdev.logicgates.block.AbstractMultiIOGateBlock;

public class LogicGateTWireBlock extends AbstractMultiIOGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "wire_t"; }
	
	@Override
	public boolean dustConnectsToThis(BlockState state, Direction dir) { return state.get(FACING) != dir; }
	// --------------------------------------------------
	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(POWERED_E);
		stateManager.add(POWERED_W);
    }
	// ==================================================
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
	{
		Direction facing = state.get(FACING);
		boolean inputPowered = getInputLevel(world, pos.offset(facing), facing) > 0;
		BlockState newState = state.with(POWERED_E, inputPowered).with(POWERED_W, inputPowered);
		
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
		
		//handle T wire
		if(direction != facing && direction != facing.getOpposite())
			return getInputLevel(worldView, pos.offset(facing), facing) > 0 ? 15 : 0;
		
		//default: 0
	    return 0;
	}*/
	// ==================================================
}