package thecsdev.logicgates.block.gates;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLogicGateBlock;

/**
 * The NOT logic gate.
 */
public final class LogicGateNotBlock extends AbstractLogicGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "not_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, World world, BlockPos pos)
	{
		return !(getFrontInputLevel(thisBlockState, world, pos) > 0);
	}
	// ==================================================
}
