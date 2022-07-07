# Clock generator (v1.1.1)
A component that generates clock signals.

## Obtaining
This block can be broken with any tool, as well as the fist.<br/>
It can be crafted using the following crafting recipe:<br/>
<br/>
![Crafting recipe](data:image/png;base64,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)
<br/>
<table>
	<tr><td>-</td><td>Redstone repeater</td><td>-</td></tr>
	<tr><td>Redstone torch</td><td>Clock</td><td>Redstone torch</td></tr>
	<tr><td>-</td><td>Redstone dust</td><td>-</td></tr>
</table>

## Behavior
This blocks acts as a clock signal generator. It emits redstone power at a given
frequency. The `logicgates_clock_delay` state defines the frequency. Larger delay
means smaller frequency. Right click the block to cycle the delay.<br/>
<br/>
A delay of `1` will set the frequency to once every `2` ticks.<br/>
Any other delay will set the frequency to once every `(delay - 1) * 5` ticks.<br/>
Keep in mind that when the clock generates a signal, it takes another `2` ticks
for that signal to turn off, and for the clock to start waiting for another
signal to be generated. The game usually runs at `20 tps`.<br/>
<br/>
<table>
	<tr><td colspan=4>Delay values to ticks</td></tr>
	<tr><td>Delay value</td><td>Ticks</td><td>Delay value</td><td>Ticks</td></tr>
	<tr><td>1</td><td>2</td><td>6</td><td>25</td></tr>
	<tr><td>2</td><td>5</td><td>7</td><td>30</td></tr>
	<tr><td>3</td><td>10</td><td>8</td><td>35</td></tr>
	<tr><td>4</td><td>15</td><td>9</td><td>40</td></tr>
	<tr><td>5</td><td>20</td><td>10</td><td>45</td></tr>
</table>

## Data values
### Block ID
`logicgates:clock`

### Block states
| Blockstate  | Values                           | Description                          |
| :---------- | :------------------------------- | :----------------------------------- |
| `facing`    | `east`, `west`, `north`, `south` | The direction the block is facing.  |
| `powered`   | `true`, `false` | Whether the block is emitting redstone power. |
| `logicgates_clock_delay`   | `1` to `10`; Default `2`; | The delay of the clock block. Right clicking the block cycles the delay. |