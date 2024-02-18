# Base sweep damage = 60% of dealt damage
scoreboard players set #60 stellarity.misc 60
scoreboard players operation #sweep_damage stellarity.misc = #damage stellarity.misc
scoreboard players operation #sweep_damage stellarity.misc *= #70 stellarity.misc
scoreboard players operation #sweep_damage stellarity.misc /= #100 stellarity.misc

execute store result storage stellarity:temp starless_scythe.sweep.damage float 0.001 run scoreboard players get #sweep_damage stellarity.misc

execute rotated ~ 0 positioned ^ ^-0.6 ^ run \
	function stellarity:items/starless_scythe/sweep/aoe

execute rotated ~110 0 positioned ^ ^-0.6 ^1.1 run \
	function stellarity:items/starless_scythe/sweep/aoe

execute rotated ~-110 0 positioned ^ ^-0.6 ^1.1 run \
	function stellarity:items/starless_scythe/sweep/aoe
