package thecsdev.logicgates;

import net.minecraft.util.registry.Registry;
import thecsdev.logicgates.item.LatchDataItem;
import thecsdev.logicgates.item.LatchSetResetItem;
import thecsdev.logicgates.item.LogicGateAndItem;
import thecsdev.logicgates.item.LogicGateExclusiveNotOrItem;
import thecsdev.logicgates.item.LogicGateExclusiveOrItem;
import thecsdev.logicgates.item.LogicGateNotAndItem;
import thecsdev.logicgates.item.LogicGateNotItem;
import thecsdev.logicgates.item.LogicGateNotOrItem;
import thecsdev.logicgates.item.LogicGateOrItem;
import thecsdev.logicgates.item.LogicGateWireItem;
import thecsdev.logicgates.item.LogicGateWireTurnItem;

import static thecsdev.logicgates.LogicGatesConfig.*;

/**
 * Holds all of the blocks from logic gates.
 */
public class LogicGatesItems
{
	// ==================================================
	public static LogicGateWireItem LOGIC_GATE_WIRE;
	public static LogicGateWireTurnItem LOGIC_GATE_WIRE_TURN;
	
	public static LogicGateAndItem LOGIC_GATE_AND;
	public static LogicGateOrItem LOGIC_GATE_OR;
	public static LogicGateExclusiveOrItem LOGIC_GATE_XOR;
	public static LogicGateNotItem LOGIC_GATE_NOT;
	public static LogicGateNotAndItem LOGIC_GATE_NAND;
	public static LogicGateNotOrItem LOGIC_GATE_NOR;
	public static LogicGateExclusiveNotOrItem LOGIC_GATE_XNOR;
	
	public static LatchSetResetItem LATCH_SETRESET;
	public static LatchDataItem LATCH_DATA;
	// ==================================================
	static void registerAll()
	{
		if(ENABLE_LOGIC_GATE_WIRE)
		{
			LOGIC_GATE_WIRE = new LogicGateWireItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_WIRE.getIdentifier(), LOGIC_GATE_WIRE);
		}
		if(ENABLE_LOGIC_GATE_WIRE_TURN)
		{
			LOGIC_GATE_WIRE_TURN = new LogicGateWireTurnItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_WIRE_TURN.getIdentifier(), LOGIC_GATE_WIRE_TURN);
		}
		
		if(ENABLE_LOGIC_GATE_AND)
		{
			LOGIC_GATE_AND = new LogicGateAndItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_AND.getIdentifier(), LOGIC_GATE_AND);
		}
		if(ENABLE_LOGIC_GATE_OR)
		{
			LOGIC_GATE_OR = new LogicGateOrItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_OR.getIdentifier(), LOGIC_GATE_OR);
		}
		if(ENABLE_LOGIC_GATE_XOR)
		{
			LOGIC_GATE_XOR = new LogicGateExclusiveOrItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_XOR.getIdentifier(), LOGIC_GATE_XOR);
		}
		if(ENABLE_LOGIC_GATE_NOT)
		{
			LOGIC_GATE_NOT = new LogicGateNotItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_NOT.getIdentifier(), LOGIC_GATE_NOT);
		}
		if(ENABLE_LOGIC_GATE_NAND)
		{
			LOGIC_GATE_NAND = new LogicGateNotAndItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_NAND.getIdentifier(), LOGIC_GATE_NAND);
		}
		if(ENABLE_LOGIC_GATE_NOR)
		{
			LOGIC_GATE_NOR = new LogicGateNotOrItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_NOR.getIdentifier(), LOGIC_GATE_NOR);
		}
		if(ENABLE_LOGIC_GATE_XNOR)
		{
			LOGIC_GATE_XNOR = new LogicGateExclusiveNotOrItem();
			Registry.register(Registry.ITEM, LOGIC_GATE_XNOR.getIdentifier(), LOGIC_GATE_XNOR);
		}
		
		if(ENABLE_LATCH_SETRESET)
		{
			LATCH_SETRESET = new LatchSetResetItem();
			Registry.register(Registry.ITEM, LATCH_SETRESET.getIdentifier(), LATCH_SETRESET);
		}
		if(ENABLE_LATCH_DATA)
		{
			LATCH_DATA = new LatchDataItem();
			Registry.register(Registry.ITEM, LATCH_DATA.getIdentifier(), LATCH_DATA);
		}
	}
	// ==================================================
}
