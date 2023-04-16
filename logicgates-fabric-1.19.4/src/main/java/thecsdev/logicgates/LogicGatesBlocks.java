package thecsdev.logicgates;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import thecsdev.logicgates.block.clocks.ClockBlock;
import thecsdev.logicgates.block.clocks.PulseExtenderBlock;
import thecsdev.logicgates.block.gates.LogicGateAndBlock;
import thecsdev.logicgates.block.gates.LogicGateExclusiveNotOrBlock;
import thecsdev.logicgates.block.gates.LogicGateExclusiveOrBlock;
import thecsdev.logicgates.block.gates.LogicGateNotAndBlock;
import thecsdev.logicgates.block.gates.LogicGateNotBlock;
import thecsdev.logicgates.block.gates.LogicGateNotOrBlock;
import thecsdev.logicgates.block.gates.LogicGateOrBlock;
import thecsdev.logicgates.block.latches.LatchDataBlock;
import thecsdev.logicgates.block.latches.LatchSetResetBlock;
import thecsdev.logicgates.block.wires.LogicGateCrossWireBlock;
import thecsdev.logicgates.block.wires.LogicGateTWireBlock;
import thecsdev.logicgates.block.wires.LogicGateWireBlock;
import thecsdev.logicgates.block.wires.LogicGateWireTurnBlock;

/**
 * Holds all of the blocks from logic gates.
 */
public class LogicGatesBlocks
{
	// ==================================================
	public static final LogicGateWireBlock LOGIC_GATE_WIRE = new LogicGateWireBlock();
	public static final LogicGateWireTurnBlock LOGIC_GATE_WIRE_TURN = new LogicGateWireTurnBlock();
	public static final LogicGateTWireBlock LOGIC_GATE_WIRE_T = new LogicGateTWireBlock();
	public static final LogicGateCrossWireBlock LOGIC_GATE_WIRE_CROSS = new LogicGateCrossWireBlock();
	
	public static final LogicGateAndBlock LOGIC_GATE_AND = new LogicGateAndBlock();
	public static final LogicGateOrBlock LOGIC_GATE_OR = new LogicGateOrBlock();
	public static final LogicGateExclusiveOrBlock LOGIC_GATE_XOR = new LogicGateExclusiveOrBlock();
	public static final LogicGateNotBlock LOGIC_GATE_NOT = new LogicGateNotBlock();
	public static final LogicGateNotAndBlock LOGIC_GATE_NAND = new LogicGateNotAndBlock();
	public static final LogicGateNotOrBlock LOGIC_GATE_NOR = new LogicGateNotOrBlock();
	public static final LogicGateExclusiveNotOrBlock LOGIC_GATE_XNOR = new LogicGateExclusiveNotOrBlock();
	
	public static final LatchSetResetBlock LATCH_SETRESET = new LatchSetResetBlock();
	public static final LatchDataBlock LATCH_DATA = new LatchDataBlock();
	
	public static final ClockBlock CLOCK = new ClockBlock();
	public static final PulseExtenderBlock PULSE_EXTENDER = new PulseExtenderBlock();
	// ==================================================
	static void registerAll()
	{
		Registry.register(Registries.BLOCK, LOGIC_GATE_WIRE.getIdentifier(), LOGIC_GATE_WIRE);
		Registry.register(Registries.BLOCK, LOGIC_GATE_WIRE_TURN.getIdentifier(), LOGIC_GATE_WIRE_TURN);
		Registry.register(Registries.BLOCK, LOGIC_GATE_WIRE_T.getIdentifier(), LOGIC_GATE_WIRE_T);
		Registry.register(Registries.BLOCK, LOGIC_GATE_WIRE_CROSS.getIdentifier(), LOGIC_GATE_WIRE_CROSS);
		
		Registry.register(Registries.BLOCK, LOGIC_GATE_AND.getIdentifier(), LOGIC_GATE_AND);
		Registry.register(Registries.BLOCK, LOGIC_GATE_OR.getIdentifier(), LOGIC_GATE_OR);
		Registry.register(Registries.BLOCK, LOGIC_GATE_XOR.getIdentifier(), LOGIC_GATE_XOR);
		Registry.register(Registries.BLOCK, LOGIC_GATE_NOT.getIdentifier(), LOGIC_GATE_NOT);
		Registry.register(Registries.BLOCK, LOGIC_GATE_NAND.getIdentifier(), LOGIC_GATE_NAND);
		Registry.register(Registries.BLOCK, LOGIC_GATE_NOR.getIdentifier(), LOGIC_GATE_NOR);
		Registry.register(Registries.BLOCK, LOGIC_GATE_XNOR.getIdentifier(), LOGIC_GATE_XNOR);
		
		Registry.register(Registries.BLOCK, LATCH_SETRESET.getIdentifier(), LATCH_SETRESET);
		Registry.register(Registries.BLOCK, LATCH_DATA.getIdentifier(), LATCH_DATA);
		
		Registry.register(Registries.BLOCK, CLOCK.getIdentifier(), CLOCK);
		Registry.register(Registries.BLOCK, PULSE_EXTENDER.getIdentifier(), PULSE_EXTENDER);
	}
	// ==================================================
}
