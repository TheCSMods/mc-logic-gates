package thecsdev.logicgates.item.groups;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import thecsdev.logicgates.LogicGates;
import thecsdev.logicgates.LogicGatesItems;

public abstract class AbstractItemGroup
{
	// ==================================================
	public final ItemGroup Group;
	// ==================================================
	public AbstractItemGroup()
	{
		Group = FabricItemGroup.builder(getIdentifier())
				.icon(() ->
				{
					if(LogicGatesItems.LOGIC_GATE_AND != null)
						return LogicGatesItems.LOGIC_GATE_AND.getDefaultStack();
					else return Items.REDSTONE_TORCH.getDefaultStack();
				})
				.build();
	}
	// --------------------------------------------------
	/**
	 * Returns the item group {@link Identifier}.
	 */
	public final Identifier getIdentifier() { return new Identifier(LogicGates.ModID, getNamespaceIdPath()); }
	// --------------------------------------------------
	/**
	 * Returns the item group identifier path.<br/>
	 * Example:
	 * <pre>
	 * {@code
	 * minecraft:redstone
	 *               ^ this part here after the colon
	 * }
	 * </pre>
	 */
	public abstract String getNamespaceIdPath();
	// ==================================================
}
