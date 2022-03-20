package thecsdev.logicgates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.registry.Registry;
import thecsdev.logicgates.block.LogicGateAndBlock;
import thecsdev.logicgates.block.LogicGateExclusiveNotOrBlock;
import thecsdev.logicgates.block.LogicGateExclusiveOrBlock;
import thecsdev.logicgates.block.LogicGateNotAndBlock;
import thecsdev.logicgates.block.LogicGateNotBlock;
import thecsdev.logicgates.block.LogicGateNotOrBlock;
import thecsdev.logicgates.block.LogicGateOrBlock;
import thecsdev.logicgates.block.ZeroTickRepeaterBlock;
import thecsdev.logicgates.item.LogicGateAndItem;
import thecsdev.logicgates.item.LogicGateExclusiveNotOrItem;
import thecsdev.logicgates.item.LogicGateExclusiveOrItem;
import thecsdev.logicgates.item.LogicGateNotAndItem;
import thecsdev.logicgates.item.LogicGateNotItem;
import thecsdev.logicgates.item.LogicGateNotOrItem;
import thecsdev.logicgates.item.LogicGateOrItem;
import thecsdev.logicgates.item.ZeroTickRepeaterItem;

/**
 * The Fabric mod-loader entry point for this mod. 
 */
public final class LogicGates implements ModInitializer
{
	// ==================================================
	public static final Logger LOGGER = LoggerFactory.getLogger(getModID());
	// --------------------------------------------------
	public static final String ModName = "Logic Gates";
	public static final String ModID   = "logicgates";
	// ==================================================
	@Override
	public void onInitialize()
	{
		//register blocks
		Registry.register(Registry.BLOCK, ZeroTickRepeaterBlock.BLOCK.getIdentifier(), ZeroTickRepeaterBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateAndBlock.BLOCK.getIdentifier(), LogicGateAndBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateOrBlock.BLOCK.getIdentifier(), LogicGateOrBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateExclusiveOrBlock.BLOCK.getIdentifier(), LogicGateExclusiveOrBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateNotBlock.BLOCK.getIdentifier(), LogicGateNotBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateNotAndBlock.BLOCK.getIdentifier(), LogicGateNotAndBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateNotOrBlock.BLOCK.getIdentifier(), LogicGateNotOrBlock.BLOCK);
		Registry.register(Registry.BLOCK, LogicGateExclusiveNotOrBlock.BLOCK.getIdentifier(), LogicGateExclusiveNotOrBlock.BLOCK);
		
		//register items
		Registry.register(Registry.ITEM, ZeroTickRepeaterItem.ITEM.getIdentifier(), ZeroTickRepeaterItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateAndItem.ITEM.getIdentifier(), LogicGateAndItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateOrItem.ITEM.getIdentifier(), LogicGateOrItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateExclusiveOrItem.ITEM.getIdentifier(), LogicGateExclusiveOrItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateNotItem.ITEM.getIdentifier(), LogicGateNotItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateNotAndItem.ITEM.getIdentifier(), LogicGateNotAndItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateNotOrItem.ITEM.getIdentifier(), LogicGateNotOrItem.ITEM);
		Registry.register(Registry.ITEM, LogicGateExclusiveNotOrItem.ITEM.getIdentifier(), LogicGateExclusiveNotOrItem.ITEM);
	}
	// --------------------------------------------------
	public static String getModID() { return ModID; }
	// ==================================================
}
