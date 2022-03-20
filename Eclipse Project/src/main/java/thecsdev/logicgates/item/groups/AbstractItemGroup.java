package thecsdev.logicgates.item.groups;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import thecsdev.logicgates.LogicGates;
import thecsdev.logicgates.item.LogicGateAndItem;

public abstract class AbstractItemGroup
{
	// ==================================================
	public final ItemGroup Group;
	// ==================================================
	public AbstractItemGroup()
	{
		Group = FabricItemGroupBuilder
				.create(getIdentifier())
				.icon(() -> LogicGateAndItem.ITEM.getDefaultStack())
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