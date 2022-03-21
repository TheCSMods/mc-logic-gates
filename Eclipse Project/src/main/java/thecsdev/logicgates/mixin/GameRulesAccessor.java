package thecsdev.logicgates.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Category;
import net.minecraft.world.GameRules.Key;
import net.minecraft.world.GameRules.Rule;
import net.minecraft.world.GameRules.Type;

/**
 * I wanted to avoid using APIs such as the Fabric API
 * to handle things, so I handled it myself.
 */
@Mixin(GameRules.class)
public interface GameRulesAccessor
{
	// ==================================================
	@Invoker("register")
	public static <T extends Rule<T>> Key<T> registerGameRule(String name, Category category, Type<T> type)
	{
		throw new AssertionError("This shouldn't happen!");
	}
	// ==================================================
}
