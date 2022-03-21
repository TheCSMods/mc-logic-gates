package thecsdev.logicgates;

import net.minecraft.util.registry.Registry;
import thecsdev.logicgates.block.LatchDataBlock;
import thecsdev.logicgates.block.LatchSetResetBlock;
import thecsdev.logicgates.block.LogicGateAndBlock;
import thecsdev.logicgates.block.LogicGateExclusiveNotOrBlock;
import thecsdev.logicgates.block.LogicGateExclusiveOrBlock;
import thecsdev.logicgates.block.LogicGateNotAndBlock;
import thecsdev.logicgates.block.LogicGateNotBlock;
import thecsdev.logicgates.block.LogicGateNotOrBlock;
import thecsdev.logicgates.block.LogicGateOrBlock;
import thecsdev.logicgates.block.LogicGateWireBlock;
import thecsdev.logicgates.block.LogicGateWireTurnBlock;

/**
 * Holds all of the blocks from logic gates.
 */
public class LogicGatesBlocks
{
	// ==================================================
	public static final LogicGateWireBlock LOGIC_GATE_WIRE = new LogicGateWireBlock();
	public static final LogicGateWireTurnBlock LOGIC_GATE_WIRE_TURN = new LogicGateWireTurnBlock();
	
	public static final LogicGateAndBlock LOGIC_GATE_AND = new LogicGateAndBlock();
	public static final LogicGateOrBlock LOGIC_GATE_OR = new LogicGateOrBlock();
	public static final LogicGateExclusiveOrBlock LOGIC_GATE_XOR = new LogicGateExclusiveOrBlock();
	public static final LogicGateNotBlock LOGIC_GATE_NOT = new LogicGateNotBlock();
	public static final LogicGateNotAndBlock LOGIC_GATE_NAND = new LogicGateNotAndBlock();
	public static final LogicGateNotOrBlock LOGIC_GATE_NOR = new LogicGateNotOrBlock();
	public static final LogicGateExclusiveNotOrBlock LOGIC_GATE_XNOR = new LogicGateExclusiveNotOrBlock();
	
	public static final LatchSetResetBlock LATCH_SETRESET = new LatchSetResetBlock();
	public static final LatchDataBlock LATCH_DATA = new LatchDataBlock();
	// ==================================================
	static void registerAll()
	{
		Registry.register(Registry.BLOCK, LOGIC_GATE_WIRE.getIdentifier(), LOGIC_GATE_WIRE);
		Registry.register(Registry.BLOCK, LOGIC_GATE_WIRE_TURN.getIdentifier(), LOGIC_GATE_WIRE_TURN);
		
		Registry.register(Registry.BLOCK, LOGIC_GATE_AND.getIdentifier(), LOGIC_GATE_AND);
		Registry.register(Registry.BLOCK, LOGIC_GATE_OR.getIdentifier(), LOGIC_GATE_OR);
		Registry.register(Registry.BLOCK, LOGIC_GATE_XOR.getIdentifier(), LOGIC_GATE_XOR);
		Registry.register(Registry.BLOCK, LOGIC_GATE_NOT.getIdentifier(), LOGIC_GATE_NOT);
		Registry.register(Registry.BLOCK, LOGIC_GATE_NAND.getIdentifier(), LOGIC_GATE_NAND);
		Registry.register(Registry.BLOCK, LOGIC_GATE_NOR.getIdentifier(), LOGIC_GATE_NOR);
		Registry.register(Registry.BLOCK, LOGIC_GATE_XNOR.getIdentifier(), LOGIC_GATE_XNOR);
		
		Registry.register(Registry.BLOCK, LATCH_SETRESET.getIdentifier(), LATCH_SETRESET);
		Registry.register(Registry.BLOCK, LATCH_DATA.getIdentifier(), LATCH_DATA);
	}
	// ==================================================
}
