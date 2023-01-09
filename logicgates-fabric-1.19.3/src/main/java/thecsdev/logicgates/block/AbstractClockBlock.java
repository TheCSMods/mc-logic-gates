package thecsdev.logicgates.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

public abstract class AbstractClockBlock extends AbstractLogicGateBlock
{
	// ==================================================
	public static final IntProperty CLOCK_DELAY = IntProperty.of("logicgates_clock_delay", 1, 10);
	// ==================================================
	@Override
	public abstract void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random);
	
	protected void scheduleTick(WorldAccess world, BlockPos pos, int delay)
	{
	    if (!world.isClient() && !world.getBlockTickScheduler().isQueued(pos, this))
	    	world.scheduleBlockTick(pos, this, delay);
	}
	// ==================================================
	@SuppressWarnings("deprecation")
	public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos)
	{
		//DEPRECATED - COPIED FROM ObserverBlock.class
		if (state.get(FACING) == direction && !state.get(POWERED))
			scheduleTick(world, pos, 2);
	    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
	}
	
	protected void updateNeighbors(World world, BlockPos pos, BlockState state)
	{
		Direction direction = (Direction)state.get(FACING);
		BlockPos blockPos = pos.offset(direction.getOpposite());
		world.updateNeighbor(blockPos, this, pos);
		world.updateNeighborsExcept(blockPos, this, direction);
	}
	// ==================================================
	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(CLOCK_DELAY);
    }
	
	public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved)
	{
		if (state.isOf(newState.getBlock()))
			return; 
		if (!world.isClient && state.get(POWERED) && world.getBlockTickScheduler().isQueued(pos, this))
			updateNeighbors(world, pos, state.with(POWERED, false));
	}
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx)
	{
		BlockState state = super.getPlacementState(ctx);
		state = state.with(CLOCK_DELAY, 1);
		return state;
	}
	
	public final int getTickDelayFromDelay(BlockState state) { return getTickDelayFromDelay(state.get(CLOCK_DELAY)); }
	public int getTickDelayFromDelay(int cd)
	{
		if(cd < 2) return 2;
		else return 5 * (cd - 1);
	}
	// ==================================================
	@Override
	public boolean gateConditionsMet(BlockState state, World world, BlockPos pos)
	{
		return getFrontInputLevel(state, world, pos) > 0;
	}
	
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
	{
		//check adventure mode and stuff
		if (!player.getAbilities().allowModifyWorld)
			return ActionResult.PASS;
		
		//cycle delay
		state = state.cycle(CLOCK_DELAY);
		float pitch = ((float)state.get(CLOCK_DELAY) / 10) + 0.25f;
		world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 0.3f, pitch);
		world.setBlockState(pos, state, 2);
		//updatePowered(world, pos, state);
		
		//return
		return ActionResult.success(world.isClient);
	}
	// ==================================================
}
