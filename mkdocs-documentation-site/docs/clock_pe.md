# Pulse extender (v1.2)
A component that extends a redsone signal.

## Obtaining
This block can be broken with any tool, as well as the fist.<br/>
It can be crafted using the following crafting recipe:<br/>
<br/>
![Crafting recipe](data:image/png;base64,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)
<br/>
<table>
	<tr><td>-</td><td>Redstone comparator</td><td>-</td></tr>
	<tr><td>Redstone torch</td><td>Clock</td><td>Redstone torch</td></tr>
	<tr><td>-</td><td>Redstone dust</td><td>-</td></tr>
</table>

## Behavior
This blocks extends a redstone signal. It starts outputting a redstone signal
as it's input gets powered. Once it's input loses power, it stops outputting
a redstone signal after a given delay.<br/>
The `logicgates_clock_delay` state defines the how long the pulse will get extended for.
Larger delay will make the block extend a pulse for longer. Right click the block to
cycle the delay value.<br/>
<br/>
The total amount of ticks this block will extend for is equal to `delay * 5`.<br/>
<br/>
<table>
	<tr><td colspan=4>Delay values to ticks extended</td></tr>
	<tr><td>Delay value</td><td>Ticks extended</td><td>Delay value</td><td>Ticks extended</td></tr>
	<tr><td>1</td><td>5</td><td>6</td><td>30</td></tr>
	<tr><td>2</td><td>10</td><td>7</td><td>35</td></tr>
	<tr><td>3</td><td>15</td><td>8</td><td>40</td></tr>
	<tr><td>4</td><td>20</td><td>9</td><td>45</td></tr>
	<tr><td>5</td><td>25</td><td>10</td><td>50</td></tr>
</table>

## Data values
### Block ID
`logicgates:pulse_extender`

### Block states
| Blockstate  | Values                           | Description                          |
| :---------- | :------------------------------- | :----------------------------------- |
| `facing`    | `east`, `west`, `north`, `south` | The direction the block is facing.  |
| `powered`   | `true`, `false` | Whether the block is emitting redstone power. |
| `logicgates_clock_delay`   | `1` to `10`; Default `4`; | The delay of the clock block. Right clicking the block cycles the delay. |
| `logicgates_extended_pulse`   | `0` to `10`; Default `0`; | The duration left during which the pulse will remain extended. |