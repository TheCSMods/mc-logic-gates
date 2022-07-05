package thecsdev.logicgates.block.gates;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLogicGateBlock;

public class LogicGateWireBlock extends AbstractLogicGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "wire"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState state, World world, BlockPos pos)
	{
		return getFrontInputLevel(state, world, pos) > 0;
	}
	// ==================================================
}
