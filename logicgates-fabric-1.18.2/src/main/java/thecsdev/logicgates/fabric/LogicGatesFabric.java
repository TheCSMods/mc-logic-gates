package thecsdev.logicgates.fabric;

import net.fabricmc.api.ModInitializer;
import thecsdev.logicgates.LogicGates;

/**
 * The Fabric mod-loader entry point for this mod. 
 */
public final class LogicGatesFabric implements ModInitializer
{
	// ==================================================
	@Override
	public void onInitialize() { LogicGates.onInitialize(); }
	// ==================================================
}
