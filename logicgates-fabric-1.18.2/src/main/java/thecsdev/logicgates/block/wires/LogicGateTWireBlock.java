package thecsdev.logicgates.block.wires;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import thecsdev.logicgates.block.AbstractMultiIOGateBlock;

public class LogicGateTWireBlock extends AbstractMultiIOGateBlock
{
	// ==================================================
	@Override
	public String getBlockIdPath() { return "wire_t"; }
	// --------------------------------------------------
	@Override
	public boolean dustConnectsToThis(BlockState state, Direction dir) { return state.get(FACING) != dir; }
	// ==================================================
	@Override
	public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		return state.getWeakRedstonePower(world, pos, direction);
	}
	
	@Override
	public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		//get required stuff
		if(!(world instanceof WorldView)) return 0; //shouldn't happen, like... ever.
		Direction facing = state.get(FACING);
		WorldView worldView = (WorldView)world;
		
		//handle T wire
		if(direction != facing && direction != facing.getOpposite())
			return getInputLevel(worldView, pos.offset(facing), facing) > 0 ? 15 : 0;
		
		//default: 0
	    return 0;
	}
	// ==================================================
}