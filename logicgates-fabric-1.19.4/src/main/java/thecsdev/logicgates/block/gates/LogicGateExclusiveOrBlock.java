package thecsdev.logicgates.block.gates;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLogicSideGateBlock;

/**
 * The XOR logic gate.
 */
public final class LogicGateExclusiveOrBlock extends AbstractLogicSideGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "xor_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, World world, BlockPos pos)
	{
		boolean left = getSideInputLevel(thisBlockState, world, pos) > 0;
		boolean front = getFrontInputLevel(thisBlockState, world, pos) > 0;
		return left ^ front;
	}
	// ==================================================
}
