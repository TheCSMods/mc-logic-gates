# Set-Reset latch
A latch whose output can be turned on and off using it's inputs.

## Obtaining
This block can be broken with any tool, as well as the fist.<br/>
It can be crafted using the following crafting recipe:<br/>
<br/>
![Crafting recipe](data:image/png;base64,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)
<br/>
<table>
	<tr><td>OR gate</td><td>AND gate</td><td>-</td></tr>
	<tr><td>-</td><td>NOT gate</td><td>-</td></tr>
	<tr><td>-</td><td>-</td><td>-</td></tr>
</table>

## Behavior
The SR latch has two inputs and one output.<br/>
The front input acts as SET. It makes the output turn on when powered.<br/>
The side input acts as RESET. It makes the output turn off when powered.

## Data values
### Block ID
`logicgates:sr_latch`

### Block states
| Blockstate  | Values                           | Description                          |
| :---------- | :------------------------------- | :----------------------------------- |
| `facing`    | `east`, `west`, `north`, `south` | The direction the block is facing.  |
| `powered`   | `true`, `false` | Whether the block is emitting redstone power. |
| `swapped_direction`   | `true`, `false` | Whether the block's side input direction is swapped. |