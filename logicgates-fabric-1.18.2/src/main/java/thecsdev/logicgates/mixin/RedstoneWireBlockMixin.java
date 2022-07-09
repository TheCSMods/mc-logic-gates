package thecsdev.logicgates.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.Direction;
import thecsdev.logicgates.block.AbstractLogicGateBlock;

/**
 * This mixin is used to tell redstone wires
 * how to connect to logic gate blocks.
 */
@Mixin(RedstoneWireBlock.class)
public abstract class RedstoneWireBlockMixin
{
	// ==================================================
	@Inject(method = "connectsTo(Lnet/minecraft/block/BlockState;Lnet/minecraft/util/math/Direction;)Z",
			at = @At("HEAD"), cancellable = true, remap = true)
	private static void connectsTo_tcd_mixin(BlockState state, Direction dir, CallbackInfoReturnable<Boolean> e)
	{
		if(state.getBlock() instanceof AbstractLogicGateBlock)
		{
			AbstractLogicGateBlock algb = (AbstractLogicGateBlock)state.getBlock();
			e.setReturnValue(algb.dustConnectsToThis(state, dir));
			e.cancel();
			return;
		}
	}
	// ==================================================
}
