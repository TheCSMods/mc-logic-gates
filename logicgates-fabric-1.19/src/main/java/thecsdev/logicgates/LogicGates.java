package thecsdev.logicgates;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogicGates
{
	// ==================================================
	public static final Logger LOGGER = LoggerFactory.getLogger(getModID());
	// --------------------------------------------------
	public static final String ModName = "Logic Gates";
	public static final String ModID   = "logicgates";
	// --------------------------------------------------
	private static boolean initialized = false;
	// ==================================================
	public static void onInitialize()
	{
		//check initialized
		if(initialized) return;
		initialized = true;
		
		//register blocks and items
		LogicGatesBlocks.registerAll();
		LogicGatesItems.registerAll();
	}
	// --------------------------------------------------
	public static String getModID() { return ModID; }
	// ==================================================
}
