package thecsdev.logicgates.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

/**
 * The NOT logic gate.
 */
public final class LogicGateNotBlock extends AbstractLogicGateBlock
{
	// ==================================================
	public final static LogicGateNotBlock BLOCK = new LogicGateNotBlock();
	// ==================================================
	@Override
	public String getBlockIdPath() { return "not_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, WorldView world, BlockPos pos)
	{
		return !(getFrontInputLevel(thisBlockState, world, pos) > 0);
	}
	// ==================================================
}
