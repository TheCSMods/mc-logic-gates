package thecsdev.logicgates.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.BooleanRule;

@Mixin(GameRules.BooleanRule.class)
public interface GameRulesBooleanRuleAccessor
{
	// ==================================================
	@Invoker("create")
	public static GameRules.Type<BooleanRule> createRule(boolean initialValue)
	{
		throw new AssertionError("This shouldn't happen!");
	}
	// ==================================================
}
