package thecsdev.logicgates.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.Direction;
import thecsdev.logicgates.block.AbstractLogicGateBlock;
import thecsdev.logicgates.block.gates.LogicGateWireTurnBlock;

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
			
			//get gate state dir
			Direction face_front = state.get(AbstractLogicGateBlock.FACING);
			Direction face_side = algb.getGateSideDir(state);
			
			//check front and back, and check side direction
			boolean a = (dir == face_front.getOpposite()) && !(state.getBlock() instanceof LogicGateWireTurnBlock);
			boolean b = (dir == face_front || a);
			boolean c = (algb.supportsSideDirection() && dir == face_side.getOpposite());
			
			if(b || c)
			{
				e.setReturnValue(true);
				e.cancel();
			}
			else
			{
				//all other sides do not connect
				e.setReturnValue(false);
				e.cancel();
			}
		}
	}
	// ==================================================
}
