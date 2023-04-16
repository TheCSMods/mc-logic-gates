package thecsdev.logicgates.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.state.StateManager;
import net.minecraft.state.property.Property;

@Mixin(value = StateManager.Builder.class, remap = true)
public interface StateManagerBuilderMixin
{
	@Accessor("namedProperties")
	public Map<String, Property<?>> getNamedProperties();
}