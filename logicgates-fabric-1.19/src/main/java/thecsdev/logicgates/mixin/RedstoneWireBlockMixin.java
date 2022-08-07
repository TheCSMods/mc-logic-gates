package thecsdev.logicgates.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.Direction;
import thecsdev.logicgates.block.AbstractLogicGateBlock;
import thecsdev.logicgates.block.AbstractMultiIOGateBlock;

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
		//check for block type
		if(!(state.getBlock() instanceof AbstractLogicGateBlock) &&
				!(state.getBlock() instanceof AbstractMultiIOGateBlock))
			return;
		
		//check for null direction
		if(dir == null)
		{
			e.setReturnValue(false);
			e.cancel();
			return;
		}
		
		if(state.getBlock() instanceof AbstractLogicGateBlock)
		{
			
			AbstractLogicGateBlock algb = (AbstractLogicGateBlock)state.getBlock();
			e.setReturnValue(algb.dustConnectsToThis(state, dir));
			e.cancel();
			return;
		}
		else if(state.getBlock() instanceof AbstractMultiIOGateBlock)
		{
			AbstractMultiIOGateBlock amiogb = (AbstractMultiIOGateBlock)state.getBlock();
			e.setReturnValue(amiogb.dustConnectsToThis(state, dir));
			e.cancel();
			return;
		}
	}
	// ==================================================
}
