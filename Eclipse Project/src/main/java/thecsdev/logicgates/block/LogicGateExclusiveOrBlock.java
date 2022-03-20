package thecsdev.logicgates.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

/**
 * The XOR logic gate.
 */
public final class LogicGateExclusiveOrBlock extends AbstractLogicSideGateBlock
{
	// ==================================================
	public final static LogicGateExclusiveOrBlock BLOCK = new LogicGateExclusiveOrBlock();
	// ==================================================
	@Override
	public String getBlockIdPath() { return "xor_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, WorldView world, BlockPos pos)
	{
		boolean left = getSideInputLevel(thisBlockState, world, pos) > 0;
		boolean front = getFrontInputLevel(thisBlockState, world, pos) > 0;
		return left ^ front;
	}
	// ==================================================
}
