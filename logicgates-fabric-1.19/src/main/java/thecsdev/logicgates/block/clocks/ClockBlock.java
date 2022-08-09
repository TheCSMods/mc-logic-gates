package thecsdev.logicgates.block.clocks;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractClockBlock;

public final class ClockBlock extends AbstractClockBlock
{
	@Override public String getBlockIdPath() { return "clock"; }
	
	@Override
	public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
	{
		if(state.get(POWERED))
		{
			world.setBlockState(pos, state.with(POWERED, false), NOTIFY_LISTENERS);
			scheduleTick(world, pos, getTickDelayFromDelay(state));
		}
		else if(!state.get(POWERED) && hasPower(world, pos, state))
		{
			world.setBlockState(pos, state.with(POWERED, true), NOTIFY_LISTENERS);
			scheduleTick(world, pos, 2);
		}
		updateNeighbors((World)world, pos, state);
	}
}
