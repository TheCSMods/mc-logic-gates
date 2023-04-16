package thecsdev.logicgates;

import static thecsdev.logicgates.LogicGatesConfig.ENABLE_CLOCK;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LATCH_DATA;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LATCH_SETRESET;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_AND;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_NAND;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_NOR;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_NOT;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_OR;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_WIRE;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_WIRE_CROSS;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_WIRE_T;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_WIRE_TURN;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_XNOR;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_LOGIC_GATE_XOR;
import static thecsdev.logicgates.LogicGatesConfig.ENABLE_PULSE_EXTENDER;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import thecsdev.logicgates.item.clocks.ClockItem;
import thecsdev.logicgates.item.clocks.PulseExtenderItem;
import thecsdev.logicgates.item.gates.LogicGateAndItem;
import thecsdev.logicgates.item.gates.LogicGateExclusiveNotOrItem;
import thecsdev.logicgates.item.gates.LogicGateExclusiveOrItem;
import thecsdev.logicgates.item.gates.LogicGateNotAndItem;
import thecsdev.logicgates.item.gates.LogicGateNotItem;
import thecsdev.logicgates.item.gates.LogicGateNotOrItem;
import thecsdev.logicgates.item.gates.LogicGateOrItem;
import thecsdev.logicgates.item.latches.LatchDataItem;
import thecsdev.logicgates.item.latches.LatchSetResetItem;
import thecsdev.logicgates.item.wires.LogicGateCrossWireItem;
import thecsdev.logicgates.item.wires.LogicGateTWireItem;
import thecsdev.logicgates.item.wires.LogicGateWireItem;
import thecsdev.logicgates.item.wires.LogicGateWireTurnItem;

/**
 * Holds all of the blocks from logic gates.
 */
public class LogicGatesItems
{
	// ==================================================
	public static LogicGateWireItem LOGIC_GATE_WIRE;
	public static LogicGateWireTurnItem LOGIC_GATE_WIRE_TURN;
	public static LogicGateTWireItem LOGIC_GATE_WIRE_T;
	public static LogicGateCrossWireItem LOGIC_GATE_WIRE_CROSS;
	
	public static LogicGateAndItem LOGIC_GATE_AND;
	public static LogicGateOrItem LOGIC_GATE_OR;
	public static LogicGateExclusiveOrItem LOGIC_GATE_XOR;
	public static LogicGateNotItem LOGIC_GATE_NOT;
	public static LogicGateNotAndItem LOGIC_GATE_NAND;
	public static LogicGateNotOrItem LOGIC_GATE_NOR;
	public static LogicGateExclusiveNotOrItem LOGIC_GATE_XNOR;
	
	public static LatchSetResetItem LATCH_SETRESET;
	public static LatchDataItem LATCH_DATA;
	
	public static ClockItem CLOCK;
	public static PulseExtenderItem PULSE_EXTENDER;
	// ==================================================
	static void registerAll()
	{
		//WIRES
		if(ENABLE_LOGIC_GATE_WIRE)
		{
			LOGIC_GATE_WIRE = new LogicGateWireItem();
			register(LOGIC_GATE_WIRE.getIdentifier(), LOGIC_GATE_WIRE);
		}
		if(ENABLE_LOGIC_GATE_WIRE_TURN)
		{
			LOGIC_GATE_WIRE_TURN = new LogicGateWireTurnItem();
			register(LOGIC_GATE_WIRE_TURN.getIdentifier(), LOGIC_GATE_WIRE_TURN);
		}
		if(ENABLE_LOGIC_GATE_WIRE_T)
		{
			LOGIC_GATE_WIRE_T = new LogicGateTWireItem();
			register(LOGIC_GATE_WIRE_T.getIdentifier(), LOGIC_GATE_WIRE_T);
		}
		if(ENABLE_LOGIC_GATE_WIRE_CROSS)
		{
			LOGIC_GATE_WIRE_CROSS = new LogicGateCrossWireItem();
			register(LOGIC_GATE_WIRE_CROSS.getIdentifier(), LOGIC_GATE_WIRE_CROSS);
		}
		
		//LOGIC GATES
		if(ENABLE_LOGIC_GATE_AND)
		{
			LOGIC_GATE_AND = new LogicGateAndItem();
			register(LOGIC_GATE_AND.getIdentifier(), LOGIC_GATE_AND);
		}
		if(ENABLE_LOGIC_GATE_OR)
		{
			LOGIC_GATE_OR = new LogicGateOrItem();
			register(LOGIC_GATE_OR.getIdentifier(), LOGIC_GATE_OR);
		}
		if(ENABLE_LOGIC_GATE_XOR)
		{
			LOGIC_GATE_XOR = new LogicGateExclusiveOrItem();
			register(LOGIC_GATE_XOR.getIdentifier(), LOGIC_GATE_XOR);
		}
		if(ENABLE_LOGIC_GATE_NOT)
		{
			LOGIC_GATE_NOT = new LogicGateNotItem();
			register(LOGIC_GATE_NOT.getIdentifier(), LOGIC_GATE_NOT);
		}
		if(ENABLE_LOGIC_GATE_NAND)
		{
			LOGIC_GATE_NAND = new LogicGateNotAndItem();
			register(LOGIC_GATE_NAND.getIdentifier(), LOGIC_GATE_NAND);
		}
		if(ENABLE_LOGIC_GATE_NOR)
		{
			LOGIC_GATE_NOR = new LogicGateNotOrItem();
			register(LOGIC_GATE_NOR.getIdentifier(), LOGIC_GATE_NOR);
		}
		if(ENABLE_LOGIC_GATE_XNOR)
		{
			LOGIC_GATE_XNOR = new LogicGateExclusiveNotOrItem();
			register(LOGIC_GATE_XNOR.getIdentifier(), LOGIC_GATE_XNOR);
		}
		
		//LATCHES
		if(ENABLE_LATCH_SETRESET)
		{
			LATCH_SETRESET = new LatchSetResetItem();
			register(LATCH_SETRESET.getIdentifier(), LATCH_SETRESET);
		}
		if(ENABLE_LATCH_DATA)
		{
			LATCH_DATA = new LatchDataItem();
			register(LATCH_DATA.getIdentifier(), LATCH_DATA);
		}
		
		//CLOCKS
		if(ENABLE_CLOCK)
		{
			CLOCK = new ClockItem();
			register(CLOCK.getIdentifier(), CLOCK);
		}
		if(ENABLE_PULSE_EXTENDER)
		{
			PULSE_EXTENDER = new PulseExtenderItem();
			register(PULSE_EXTENDER.getIdentifier(), PULSE_EXTENDER);
		}
	}
	// ==================================================
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static Item register(Identifier id, Item item)
	{
		if (item instanceof BlockItem)
		    ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item); 
		return (Item)Registry.register((Registry)Registries.ITEM, id, item);
	}
	// ==================================================
}
