package thecsdev.logicgates.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.AbstractRedstoneGateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import thecsdev.logicgates.LogicGates;
import thecsdev.logicgates.block.wires.LogicGateWireTurnBlock;

/**
 * An abstract class for all logic gate blocks.
 */
public abstract class AbstractLogicGateBlock extends AbstractRedstoneGateBlock
{
	// ==================================================
	static final Settings SETTINGS = Settings.copy(Blocks.REPEATER);
	static final VoxelShape SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D);
	// --------------------------------------------------
	public static final BooleanProperty POWERED = Properties.POWERED;
	public static final BooleanProperty SWAPPED_DIR = BooleanProperty.of("swapped_direction");
	// ==================================================
	protected AbstractLogicGateBlock()
	{
		//super
		super(SETTINGS);
		
		//rendering
		//i don't feel like dealing with sides, so i'm just gonna catch
		try { net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout()); }
		catch(Throwable e) {}
		
		//default states
		setDefaultState(getDefaultState().with(POWERED, false));
		if(supportsSideDirection())
			setDefaultState(getDefaultState().with(SWAPPED_DIR, false));
	}
 	// --------------------------------------------------
	@Override
	protected int getUpdateDelayInternal(BlockState state) { return 0; }
	// --------------------------------------------------
 	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(FACING);
		stateManager.add(POWERED);
    }
 	// --------------------------------------------------
 	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) { return SHAPE; }
	// --------------------------------------------------
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) { return hasTopRim((BlockView)world, pos.down()); }
	// --------------------------------------------------
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx)
	{
		BlockState state = getDefaultState();
		state = state.with(FACING, ctx.getPlayerFacing().getOpposite());
		state = state.with(POWERED, hasPower(ctx.getWorld(), ctx.getBlockPos(), state));
		return state;
	}
	// ==================================================
	@Override
	protected boolean hasPower(World world, BlockPos pos, BlockState state) { return gateConditionsMet(state, world, pos); }
	// --------------------------------------------------
	@Override
	protected int getInputLevel(WorldView world, BlockPos pos, Direction dir)
	{
		BlockState blockState = world.getBlockState(pos);
		boolean a =
				blockState.getWeakRedstonePower(world, pos, dir) +
				blockState.getStrongRedstonePower(world, pos, dir) > 0;
		return Math.max(super.getInputLevel(world, pos, dir), a ? 15 : 0);
	}
	// --------------------------------------------------
	@Nullable
	public Direction getGateSideDir(BlockState state)
	{
		//get direction
		if(!supportsSideDirection()) return null;
		Direction sideDir = state.get(FACING);
		
		//rotate front direction
		if(state.get(SWAPPED_DIR)) sideDir = sideDir.rotateYClockwise();
		else sideDir = sideDir.rotateYCounterclockwise();
		
		//return
		return sideDir;
	}
	// --------------------------------------------------
	protected int getSideInputLevel(BlockState state, WorldView world, BlockPos pos)
	{
		//get side dir
		Direction sideDir = getGateSideDir(state);
		if(sideDir == null) return 0;
		
		//get input level
		BlockPos sidePos = pos.offset(sideDir);
		return getInputLevel(world, sidePos, sideDir);
	}
	
	protected int getFrontInputLevel(BlockState state, WorldView world, BlockPos pos)
	{
		Direction frontDir = state.get(FACING);
		BlockPos frontPos = pos.offset(frontDir);
		return getInputLevel(world, frontPos, frontDir);
	}
	// ==================================================
	public boolean dustConnectsToThis(BlockState state, Direction dir)
	{
		//get gate state dir
		Direction face_front = state.get(FACING);
		Direction face_side = getGateSideDir(state);
		
		//check front and back, and check side direction
		boolean a = (dir == face_front.getOpposite()) && !(state.getBlock() instanceof LogicGateWireTurnBlock);
		boolean b = (dir == face_front || a);
		boolean c = (supportsSideDirection() && dir == face_side.getOpposite());
		
		//return
		if(b || c) return true;
		else return false;
	}
	// --------------------------------------------------
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
	// --------------------------------------------------
	/**
	 * Returns true if all the conditions were met
	 * for this {@link AbstractLogicGateBlock}.
	 */
	public abstract boolean gateConditionsMet(BlockState state, World world, BlockPos pos);
	// --------------------------------------------------
	/**
	 * Returns true or false based on whether side inputs
	 * and {@link #SWAPPED_DIR} are supported by this block.
	 */
	public final boolean supportsSideDirection() { return this instanceof AbstractLogicSideGateBlock; }
	// ==================================================
}