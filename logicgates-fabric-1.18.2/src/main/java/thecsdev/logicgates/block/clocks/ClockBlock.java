package thecsdev.logicgates.block.clocks;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
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
			world.setBlockState(pos, state.with(POWERED, false), 2);
			scheduleTick(world, pos, getTickDelayFromDelay(state));
		}
		else if(!state.get(POWERED) && hasPower(world, pos, state))
		{
			world.setBlockState(pos, state.with(POWERED, true), 2);
			scheduleTick(world, pos, 2);
		}
		updateNeighbors((World)world, pos, state);
	}
}
