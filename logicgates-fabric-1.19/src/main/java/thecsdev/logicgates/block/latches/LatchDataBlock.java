package thecsdev.logicgates.block.latches;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLatchBlock;

public class LatchDataBlock extends AbstractLatchBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "data_latch"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState state, World world, BlockPos pos)
	{
		//get stuff
		boolean isPowered = state.get(POWERED);
		
		boolean frontPowered = getFrontInputLevel(state, world, pos) > 0;
		boolean isSidePowered = getSideInputLevel(state, world, pos) > 0;
		
		//return based on inputs
		if(isSidePowered) return frontPowered;
		else return isPowered;
	}
	// ==================================================
}
