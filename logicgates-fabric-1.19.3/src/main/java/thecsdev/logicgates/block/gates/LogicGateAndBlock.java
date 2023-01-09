package thecsdev.logicgates.block.gates;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLogicSideGateBlock;
/**
 * The AND logic gate.
 */
public final class LogicGateAndBlock extends AbstractLogicSideGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "and_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, World world, BlockPos pos)
	{
		boolean left = getSideInputLevel(thisBlockState, world, pos) > 0;
		boolean front = getFrontInputLevel(thisBlockState, world, pos) > 0;
		return left && front;
	}
	// ==================================================
}
