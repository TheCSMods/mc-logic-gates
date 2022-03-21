package thecsdev.logicgates.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
