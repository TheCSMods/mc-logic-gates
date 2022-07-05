package thecsdev.logicgates.block.latches;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLatchBlock;

public class LatchSetResetBlock extends AbstractLatchBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "sr_latch"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState state, World world, BlockPos pos)
	{
		//get stuff
		boolean isPowered = state.get(POWERED);
		boolean frontPowered = getFrontInputLevel(state, world, pos) > 0;
		boolean sidePowered = getSideInputLevel(state, world, pos) > 0;
		
		//return based on inputs
		if(frontPowered || sidePowered)
		{
			if(frontPowered) return true;
			else if(sidePowered) return false;
		}
		
		//default outcome
		return isPowered;
	}
	// ==================================================
}
