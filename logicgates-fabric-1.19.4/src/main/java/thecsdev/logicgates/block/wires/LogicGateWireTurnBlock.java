package thecsdev.logicgates.block.wires;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import thecsdev.logicgates.block.AbstractLogicSideGateBlock;

public class LogicGateWireTurnBlock extends AbstractLogicSideGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "wire_turn"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState state, World world, BlockPos pos)
	{
		return getSideInputLevel(state, world, pos) > 0;
	}
	// ==================================================
}
