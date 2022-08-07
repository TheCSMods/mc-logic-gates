package thecsdev.logicgates.block;

import static thecsdev.logicgates.block.AbstractLogicGateBlock.SETTINGS;
import static thecsdev.logicgates.block.AbstractLogicGateBlock.SHAPE;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import thecsdev.logicgates.LogicGates;

public abstract class AbstractMultiIOGateBlock extends Block
{
	// ==================================================
	public final static DirectionProperty FACING = HorizontalFacingBlock.FACING;
	// ==================================================
	public AbstractMultiIOGateBlock()
	{
		//super
		super(SETTINGS);
		
		//rendering
		//i don't feel like dealing with sides in here either, so i'm just gonna catch
		try { net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout()); }
		catch(Throwable e) {}
	}
	// --------------------------------------------------
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) { return SHAPE; }
	
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) { return hasTopRim((BlockView)world, pos.down()); }
	// --------------------------------------------------
	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(FACING);
    }
	
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx)
	{
		BlockState state = getDefaultState();
		state = state.with(FACING, ctx.getPlayerFacing().getOpposite());
		return state;
	}
	// --------------------------------------------------
	public boolean emitsRedstonePower(BlockState state) { return true; }
	//
	public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		return state.getWeakRedstonePower(world, pos, direction);
	}
	
	public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) { return 0; }
	//
	protected int getInputLevel(WorldView world, BlockPos pos, Direction dir)
	{
		//get block state
		BlockState blockState = world.getBlockState(pos);
		
		//check if redstone block or wire
		if (blockState.isOf(Blocks.REDSTONE_BLOCK))
			return 15;
		else if (blockState.isOf(Blocks.REDSTONE_WIRE))
			return blockState.get(RedstoneWireBlock.POWER);
		/*else if(blockState.isOf(Blocks.LEVER) && blockState.get(WallMountedBlock.FACE) == WallMountLocation.FLOOR)
			return 15; -- acts weird, doesn't work. will patch later; also check for POWERED*/
		
		//check if emits power and get strong power
		if (blockState.emitsRedstonePower())
			return world.getStrongRedstonePower(pos, dir);
		
		//return 0
		return 0;
	}
	// ==================================================
	/**
	 * Returns this block's Identifier. See also {@link #getBlockIdPath()}.
	 */
	public Identifier getIdentifier() { return new Identifier(LogicGates.ModID, getBlockIdPath()); }
	
	/**
	 * Returns the block identifier path.<br/>
	 * Example:
	 * <pre>
	 * {@code
	 * minecraft:grass_block
	 *                ^ this part here after the colon
	 * }
	 * </pre>
	 */
	public abstract String getBlockIdPath();
	
	/**
	 * Whether a {@link RedstoneWireBlock} connects to this block.
	 */
	public abstract boolean dustConnectsToThis(BlockState state, Direction dir);
	// ==================================================
}