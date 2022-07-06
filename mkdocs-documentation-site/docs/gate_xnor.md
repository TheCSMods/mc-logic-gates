# XNOR gate
A logic gate whose output is on **only** when **both or none** of it's inputs are on.

## Obtaining
This block can be broken with any tool, as well as the fist.<br/>
It can be crafted using the following crafting recipe:<br/>
<br/>
![Crafting recipe](data:image/png;base64,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)
<br/>
<table>
	<tr><td>-</td><td>NOT gate</td><td>-</td></tr>
	<tr><td>-</td><td>XOR gate</td><td>-</td></tr>
	<tr><td>-</td><td>-</td><td>-</td></tr>
</table>

## Behavior
The XNOR gate has two inputs and one output.
The output is on **only** when **both or none** of it's inputs are on.

## Data values
### Block ID
`logicgates:xnor_gate`

### Block states
| Blockstate  | Values                           | Description                          |
| :---------- | :------------------------------- | :----------------------------------- |
| `facing`    | `east`, `west`, `north`, `south` | The direction the block is facing.  |
| `powered`   | `true`, `false` | Whether the block is recieving redstone power. |
| `swapped_direction`   | `true`, `false` | Whether the block's side input direction is swapped. |