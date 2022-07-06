# NOR gate
A logic gate whose output is always opposite to that of [OR gate](gate_or.md)'s.

## Obtaining
This block can be broken with any tool, as well as the fist.<br/>
It can be crafted using the following crafting recipe:<br/>
<br/>
![Crafting recipe](data:image/png;base64,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)
<br/>
<table>
	<tr><td>-</td><td>NOT gate</td><td>-</td></tr>
	<tr><td>-</td><td>OR gate</td><td>-</td></tr>
	<tr><td>-</td><td>-</td><td>-</td></tr>
</table>

## Behavior
The NOR gate has two inputs and one output.
The output is always opposite to that of [OR gate](gate_or.md)'s.

## Data values
### Block ID
`logicgates:nor_gate`

### Block states
| Blockstate  | Values                           | Description                          |
| :---------- | :------------------------------- | :----------------------------------- |
| `facing`    | `east`, `west`, `north`, `south` | The direction the block is facing.  |
| `powered`   | `true`, `false` | Whether the block is recieving redstone power. |
| `swapped_direction`   | `true`, `false` | Whether the block's side input direction is swapped. |