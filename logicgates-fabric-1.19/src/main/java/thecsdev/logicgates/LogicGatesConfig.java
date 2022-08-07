package thecsdev.logicgates;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

/**
 * All the properties in the config are READ-ONLY.
 * Modifying them while the game is running will have no effect.
 */
public final class LogicGatesConfig
{
	/**
	 * Holds the properties that will be saved/loaded.
	 */
	private static Properties PROPERTIES;
	
	public static boolean ENABLE_LOGIC_GATE_WIRE = true;
	public static boolean ENABLE_LOGIC_GATE_WIRE_TURN = true;
	public static boolean ENABLE_LOGIC_GATE_WIRE_T = true;
	
	public static boolean ENABLE_LOGIC_GATE_AND = true;
	public static boolean ENABLE_LOGIC_GATE_OR = true;
	public static boolean ENABLE_LOGIC_GATE_XOR = true;
	public static boolean ENABLE_LOGIC_GATE_NOT = true;
	public static boolean ENABLE_LOGIC_GATE_NAND = true;
	public static boolean ENABLE_LOGIC_GATE_NOR = true;
	public static boolean ENABLE_LOGIC_GATE_XNOR = true;
	
	public static boolean ENABLE_LATCH_SETRESET = true;
	public static boolean ENABLE_LATCH_DATA = true;
	
	public static boolean ENABLE_CLOCK = true;
	public static boolean ENABLE_PULSE_EXTENDER = true;
	
	/**
	 * Returns the {@link File} where the
	 * {@link #PROPERTIES} should be stored.
	 */
	public static File getPropertiesFile()
	{
		return new File(System.getProperty("user.dir") + "/config/" + LogicGates.ModID + ".properties");
	}
	
	/**
	 * Loads the {@link #PROPERTIES}.
	 */
	public static void loadProperties() throws IOException
	{
		//get file
		File pf = getPropertiesFile();
		LogicGates.LOGGER.info("Loading config from: " + pf.getAbsolutePath());
		if(!pf.exists())
		{
			LogicGates.LOGGER.info("Could not load " + LogicGates.ModID + " config. File not found.");
			return;
		}
		
		//load PROPERTIES
		FileInputStream pfIn = new FileInputStream(pf);
		PROPERTIES = new Properties();
		PROPERTIES.load(pfIn);
		pfIn.close();
		
		//paste data onto the variables
		ENABLE_LOGIC_GATE_WIRE = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_WIRE"));
		ENABLE_LOGIC_GATE_WIRE_TURN = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_WIRE_TURN"));
		ENABLE_LOGIC_GATE_WIRE_T = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_WIRE_T"));
		
		ENABLE_LOGIC_GATE_AND = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_AND"));
		ENABLE_LOGIC_GATE_OR = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_OR"));
		ENABLE_LOGIC_GATE_XOR = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_XOR"));
		ENABLE_LOGIC_GATE_NOT = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_NOT"));
		ENABLE_LOGIC_GATE_NAND = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_NAND"));
		ENABLE_LOGIC_GATE_NAND = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_NAND"));
		ENABLE_LOGIC_GATE_NOR = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_NOR"));
		ENABLE_LOGIC_GATE_XNOR = smartBool(PROPERTIES.getProperty("ENABLE_LOGIC_GATE_XNOR"));
		
		ENABLE_LATCH_SETRESET = smartBool(PROPERTIES.getProperty("ENABLE_LATCH_SETRESET"));
		ENABLE_LATCH_DATA = smartBool(PROPERTIES.getProperty("ENABLE_LATCH_DATA"));
		
		ENABLE_CLOCK = smartBool(PROPERTIES.getProperty("ENABLE_CLOCK"));
		ENABLE_PULSE_EXTENDER = smartBool(PROPERTIES.getProperty("ENABLE_PULSE_EXTENDER"));
	}
	
	/**
	 * idk why i did this. sounds cool ig.
	 */
	private static boolean smartBool(String arg0) { return smartBool(arg0, true); }
	private static boolean smartBool(String arg0, boolean def)
	{
		if(StringUtils.isBlank(arg0)) return def;
		String a = arg0.split(" ")[0].toLowerCase();
		return (a.startsWith("true") || a.startsWith("ye") ||
				a.startsWith("ok") || a.startsWith("sur")) && a.length() <= 5;
	}
}
