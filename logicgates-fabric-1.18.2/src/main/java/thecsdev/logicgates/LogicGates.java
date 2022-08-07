package thecsdev.logicgates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;

public class LogicGates implements ModInitializer
{
	// ==================================================
	public static final Logger LOGGER = LoggerFactory.getLogger(getModID());
	// --------------------------------------------------
	public static final String ModName = "Logic Gates";
	public static final String ModID   = "logicgates";
	// --------------------------------------------------
	private static boolean initialized = false;
	// ==================================================
	/**
	 * @throws RuntimeException If loading the mod configuration fails.
	 */
	@Override
	public void onInitialize()
	{
		//check initialized
		if(initialized) return;
		initialized = true;
		
		//load config
		try { LogicGatesConfig.loadProperties(); }
		catch(Exception e)
		{
			String msg = "Failed to load " + ModID + " mod config: " + e.getMessage();
			throw new RuntimeException(msg);
		}
		
		//register blocks and items
		LogicGatesBlocks.registerAll(); //first blocks
		LogicGatesItems.registerAll();  //then items
	}
	// --------------------------------------------------
	public static String getModID() { return ModID; }
	// ==================================================
}
