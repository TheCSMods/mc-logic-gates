package thecsdev.logicgates.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import thecsdev.logicgates.block.AbstractLogicGateBlock;
import thecsdev.logicgates.block.AbstractMultiIOGateBlock;
import thecsdev.logicgates.item.groups.LogicGatesItemGroup;

/**
 * An abstract class for all logic gate block items.
 */
public abstract class AbstractLogicGateItem<T extends Block> extends BlockItem
{
	// ==================================================
	public static final Settings SETTINGS = new FabricItemSettings().group(LogicGatesItemGroup.GROUP.Group);
	// --------------------------------------------------
	protected final T LogicGateBlock;
	// ==================================================
	protected AbstractLogicGateItem(T block)
	{
		super(block, SETTINGS);
		LogicGateBlock = block;
	}
	// --------------------------------------------------
	/**
	 * More info at {@link AbstractLogicGateBlock#getIdentifier()} and
	 * {@link AbstractMultiIOGateBlock#getIdentifier()}.
	 */
	public final Identifier getIdentifier()
	{
		//handle AbstractLogicGateBlock-s
		if(LogicGateBlock instanceof AbstractLogicGateBlock)
			return ((AbstractLogicGateBlock)LogicGateBlock).getIdentifier();
		
		//handle AbstractMultiIOGateBlock-s
		else if(LogicGateBlock instanceof AbstractMultiIOGateBlock)
			return ((AbstractMultiIOGateBlock)LogicGateBlock).getIdentifier();
		
		//handle other scenarios
		else
			return Registry.BLOCK.getId(LogicGateBlock); 
	}
	// ==================================================
}
