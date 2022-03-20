package thecsdev.logicgates.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import thecsdev.logicgates.block.AbstractLogicGateBlock;
import thecsdev.logicgates.item.groups.LogicGatesItemGroup;

/**
 * An abstract class for all logic gate block items.
 */
public abstract class AbstractLogicGateItem extends BlockItem
{
	// ==================================================
	public static final Settings SETTINGS = new FabricItemSettings().group(LogicGatesItemGroup.GROUP.Group);
	// --------------------------------------------------
	protected final AbstractLogicGateBlock LogicGateBlock;
	// ==================================================
	protected AbstractLogicGateItem(AbstractLogicGateBlock block)
	{
		super(block, SETTINGS);
		LogicGateBlock = block;
	}
	// --------------------------------------------------
	/**
	 * More info at {@link AbstractLogicGateBlock#getIdentifier()}.
	 */
	public final Identifier getIdentifier() { return LogicGateBlock.getIdentifier(); }
	// ==================================================
}
