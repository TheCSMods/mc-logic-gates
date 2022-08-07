package thecsdev.logicgates.block.clocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractClockBlock;

public final class PulseExtenderBlock extends AbstractClockBlock
{
	// ==================================================
	public static final IntProperty EXT_PULSE = IntProperty.of("logicgates_extended_pulse", 0, 10);
	// ==================================================
	public PulseExtenderBlock()
	{
		setDefaultState(getDefaultState().with(EXT_PULSE, 0));
	}
	// --------------------------------------------------
	@Override public String getBlockIdPath() { return "pulse_extender"; }
	// ==================================================
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
	{
		if(hasPower(world, pos, state))
			world.setBlockState(pos, state.with(POWERED, true).with(EXT_PULSE, state.get(CLOCK_DELAY)), 2);
		else
		{
			int extPulse = state.get(EXT_PULSE);
			if(extPulse > 0)
			{
				world.setBlockState(pos, state.with(POWERED, true).with(EXT_PULSE, Math.max(extPulse - 1, 0)), 2);
				scheduleTick(world, pos, getTickDelayFromDelay(1));
			}
			else world.setBlockState(pos, state.with(POWERED, false), 2);
		}
		updateNeighbors((World)world, pos, state);
	}
	// --------------------------------------------------
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx)
	{
		BlockState state = super.getPlacementState(ctx);
		state = state.with(CLOCK_DELAY, 1);
		state = state.with(EXT_PULSE, 0);
		return state;
	}
	// --------------------------------------------------
	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(EXT_PULSE);
    }
	// --------------------------------------------------
	@Override
	public int getTickDelayFromDelay(int cd) { return 5 * cd; }
	// ==================================================
}
