package thecsdev.logicgates.block;

import static thecsdev.logicgates.block.AbstractLogicGateBlock.SETTINGS;
import static thecsdev.logicgates.block.AbstractLogicGateBlock.SHAPE;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.WallMountedBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import thecsdev.logicgates.LogicGates;

public abstract class AbstractMultiIOGateBlock extends HorizontalFacingBlock
{
	// ==================================================
	public final static BooleanProperty POWERED_E = BooleanProperty.of("powered_east");
	public final static BooleanProperty POWERED_W = BooleanProperty.of("powered_west");
	public final static BooleanProperty POWERED_N = BooleanProperty.of("powered_north");
	public final static BooleanProperty POWERED_S = BooleanProperty.of("powered_south");
	// ==================================================
	public AbstractMultiIOGateBlock()
	{
		//super
		super(SETTINGS);
		
		//rendering
		//i don't feel like dealing with sides in here either, so i'm just gonna catch
		try { net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap.INSTANCE.putBlock(this, RenderLayer.getCutout()); }
		catch(Throwable e) {}
		
		//defaults
		if(getDefaultState().getProperties().contains(POWERED_E))
			setDefaultState(getDefaultState().with(POWERED_E, false));
		if(getDefaultState().getProperties().contains(POWERED_W))
			setDefaultState(getDefaultState().with(POWERED_W, false));
		if(getDefaultState().getProperties().contains(POWERED_N))
			setDefaultState(getDefaultState().with(POWERED_N, false));
		if(getDefaultState().getProperties().contains(POWERED_S))
			setDefaultState(getDefaultState().with(POWERED_S, false));
	}
	
	protected void scheduleTick(WorldAccess world, BlockPos pos, int delay)
	{
	    if (!world.isClient() && !world.getBlockTickScheduler().isQueued(pos, this))
	    	world.createAndScheduleBlockTick(pos, this, Math.max(delay, 2));
	}
	// --------------------------------------------------
	@Override
	public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) { return SHAPE; }
	
	@Override
	public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) { return hasTopRim((BlockView)world, pos.down()); }
	// --------------------------------------------------
	@Override
	public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify)
	{
		if (state.canPlaceAt((WorldView)world, pos))
		{
			updatePowered(world, pos, state);
			return;
		} 

		BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
		dropStacks(state, (WorldAccess)world, pos, blockEntity);
		world.removeBlock(pos, false);
		for (Direction direction : Direction.values())
			world.updateNeighborsAlways(pos.offset(direction), this);
	}
	
	/** Schedule a tick to update the POWERED properties */
	protected final void updatePowered(World world, BlockPos pos, BlockState state) { scheduleTick(world, pos, 2); }
	
	@Override
	public final void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
	{
		//handle block update
		onScheduledTick(state, world, pos, random);
		
		//update neighbors properly as well
		Direction facing = state.get(FACING);
		if(getDefaultState().getProperties().contains(POWERED_E))
			world.updateNeighborsExcept(pos.offset(facing.rotateYCounterclockwise()), this, facing.rotateYClockwise());
		if(getDefaultState().getProperties().contains(POWERED_W))
			world.updateNeighborsExcept(pos.offset(facing.rotateYClockwise()), this, facing.rotateYCounterclockwise());
		if(getDefaultState().getProperties().contains(POWERED_N))
			world.updateNeighborsExcept(pos.offset(facing.getOpposite()), this, facing);
		if(getDefaultState().getProperties().contains(POWERED_S))
			world.updateNeighborsExcept(pos.offset(facing), this, facing.getOpposite());
	}
	
	public abstract void onScheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random);
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
	
	@Override
	public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack)
	{
		super.onPlaced(world, pos, state, placer, itemStack);
		updatePowered(world, pos, state);
	}
	// --------------------------------------------------
	public boolean emitsRedstonePower(BlockState state) { return true; }
	//
	public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		return state.getWeakRedstonePower(world, pos, direction);
	}
	
	public int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction)
	{
		Direction facing = state.get(FACING);
		
		if(direction == facing.rotateYClockwise() && state.getProperties().contains(POWERED_E))
			return state.get(POWERED_E) ? 15 : 0;
		else if(direction == facing.rotateYCounterclockwise() && state.getProperties().contains(POWERED_W))
			return state.get(POWERED_W) ? 15 : 0;
		else if(direction == facing && state.getProperties().contains(POWERED_N))
			return state.get(POWERED_N) ? 15 : 0;
		else if(direction == facing.getOpposite() && state.getProperties().contains(POWERED_S))
			return state.get(POWERED_S) ? 15 : 0;
		else
			return 0;
	}
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
		else if(blockState.getProperties().contains(WallMountedBlock.FACE) &&
				blockState.getProperties().contains(Properties.POWERED) &&
				blockState.get(WallMountedBlock.FACE) == WallMountLocation.FLOOR)
			return blockState.get(Properties.POWERED) ? 15 : 0;
		
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