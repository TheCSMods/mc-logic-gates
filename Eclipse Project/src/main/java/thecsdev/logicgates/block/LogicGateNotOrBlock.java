package thecsdev.logicgates.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

/**
 * The NOR logic gate.
 */
public final class LogicGateNotOrBlock extends AbstractLogicSideGateBlock
{
	// ==================================================
	public final static LogicGateNotOrBlock BLOCK = new LogicGateNotOrBlock();
	// ==================================================
	@Override
	public String getBlockIdPath() { return "nor_gate"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState thisBlockState, WorldView world, BlockPos pos)
	{
		boolean left = getSideInputLevel(thisBlockState, world, pos) > 0;
		boolean front = getFrontInputLevel(thisBlockState, world, pos) > 0;
		return !(left || front);
	}
	// ==================================================
}
