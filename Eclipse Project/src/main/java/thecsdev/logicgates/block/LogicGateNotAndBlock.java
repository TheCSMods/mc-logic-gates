package thecsdev.logicgates.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.WorldView;
/**
 * The NAND logic gate.
 */
public final class LogicGateNotAndBlock extends AbstractLogicSideGateBlock
{
	// ==================================================
	public final static LogicGateNotAndBlock BLOCK = new LogicGateNotAndBlock();
	// ==================================================
	@Override
	public String getBlockIdPath() { return "nand_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, WorldView world, BlockPos pos)
	{
		boolean left = getSideInputLevel(thisBlockState, world, pos) > 0;
		boolean front = getFrontInputLevel(thisBlockState, world, pos) > 0;
		return !(left && front);
	}
	// ==================================================
}
