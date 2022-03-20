package thecsdev.logicgates.block;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class ZeroTickRepeaterBlock extends AbstractLogicGateBlock
{
	// ==================================================
	public static final ZeroTickRepeaterBlock BLOCK = new ZeroTickRepeaterBlock();
	// ==================================================
	@Override
	public String getBlockIdPath() { return "zero_tick_repeater"; }
	// --------------------------------------------------
	@Override
	public boolean gateConditionsMet(BlockState state, WorldView world, BlockPos pos)
	{
		return getFrontInputLevel(state, world, pos) > 0;
	}
	// ==================================================
}
