package thecsdev.logicgates.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * An abstract class for all logic gate blocks that {@link #supportsSideDirection()}.
 */
public abstract class AbstractLogicSideGateBlock extends AbstractLogicGateBlock
{
	// ==================================================
	@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager)
	{
		super.appendProperties(stateManager);
		stateManager.add(SWAPPED_DIR);
    }
	// --------------------------------------------------
	@Override
	public BlockState getPlacementState(ItemPlacementContext ctx)
	{
		BlockState state = super.getPlacementState(ctx);
		state = state.with(SWAPPED_DIR, false);
		return state;
	}
	// --------------------------------------------------
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
	{
		//check adventure mode and stuff, and
		//check if supports switching
		if (!player.getAbilities().allowModifyWorld || !supportsSideDirection())
			return ActionResult.PASS;
		
		//toggle swapped direction
		state = state.cycle(SWAPPED_DIR);
		world.playSound(player, pos, SoundEvents.BLOCK_COMPARATOR_CLICK, SoundCategory.BLOCKS, 0.3f, 1);
		world.setBlockState(pos, state, NOTIFY_LISTENERS);
		updatePowered(world, pos, state);
		
		//return
		return ActionResult.success(world.isClient);
	}
	// ==================================================
}
