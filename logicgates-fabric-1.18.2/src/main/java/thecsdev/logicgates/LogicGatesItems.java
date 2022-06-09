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

/**
 * Holds all of the blocks from logic gates.
 */
public class LogicGatesItems
{
	// ==================================================
	public static final LogicGateWireItem LOGIC_GATE_WIRE = new LogicGateWireItem();
	public static final LogicGateWireTurnItem LOGIC_GATE_WIRE_TURN = new LogicGateWireTurnItem();
	
	public static final LogicGateAndItem LOGIC_GATE_AND = new LogicGateAndItem();
	public static final LogicGateOrItem LOGIC_GATE_OR = new LogicGateOrItem();
	public static final LogicGateExclusiveOrItem LOGIC_GATE_XOR = new LogicGateExclusiveOrItem();
	public static final LogicGateNotItem LOGIC_GATE_NOT = new LogicGateNotItem();
	public static final LogicGateNotAndItem LOGIC_GATE_NAND = new LogicGateNotAndItem();
	public static final LogicGateNotOrItem LOGIC_GATE_NOR = new LogicGateNotOrItem();
	public static final LogicGateExclusiveNotOrItem LOGIC_GATE_XNOR = new LogicGateExclusiveNotOrItem();
	
	public static final LatchSetResetItem LATCH_SETRESET = new LatchSetResetItem();
	public static final LatchDataItem LATCH_DATA = new LatchDataItem();
	// ==================================================
	static void registerAll()
	{
		Registry.register(Registry.ITEM, LOGIC_GATE_WIRE.getIdentifier(), LOGIC_GATE_WIRE);
		Registry.register(Registry.ITEM, LOGIC_GATE_WIRE_TURN.getIdentifier(), LOGIC_GATE_WIRE_TURN);
		
		Registry.register(Registry.ITEM, LOGIC_GATE_AND.getIdentifier(), LOGIC_GATE_AND);
		Registry.register(Registry.ITEM, LOGIC_GATE_OR.getIdentifier(), LOGIC_GATE_OR);
		Registry.register(Registry.ITEM, LOGIC_GATE_XOR.getIdentifier(), LOGIC_GATE_XOR);
		Registry.register(Registry.ITEM, LOGIC_GATE_NOT.getIdentifier(), LOGIC_GATE_NOT);
		Registry.register(Registry.ITEM, LOGIC_GATE_NAND.getIdentifier(), LOGIC_GATE_NAND);
		Registry.register(Registry.ITEM, LOGIC_GATE_NOR.getIdentifier(), LOGIC_GATE_NOR);
		Registry.register(Registry.ITEM, LOGIC_GATE_XNOR.getIdentifier(), LOGIC_GATE_XNOR);
		
		Registry.register(Registry.ITEM, LATCH_SETRESET.getIdentifier(), LATCH_SETRESET);
		Registry.register(Registry.ITEM, LATCH_DATA.getIdentifier(), LATCH_DATA);
	}
	// ==================================================
}
