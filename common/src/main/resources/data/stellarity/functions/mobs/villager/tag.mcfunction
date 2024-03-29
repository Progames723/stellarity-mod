tag @s add stellarity.villager.has_job

data remove storage stellarity:temp villager.trades

execute if data storage stellarity:temp {villager:{type:"minecraft:armorer"}} run \
	function stellarity:mobs/villager/trades/armorer
execute if data storage stellarity:temp {villager:{type:"minecraft:butcher"}} run \
	function stellarity:mobs/villager/trades/butcher
execute if data storage stellarity:temp {villager:{type:"minecraft:cartographer"}} run \
	function stellarity:mobs/villager/trades/cartographer
execute if data storage stellarity:temp {villager:{type:"minecraft:cleric"}} run \
	function stellarity:mobs/villager/trades/cleric
execute if data storage stellarity:temp {villager:{type:"minecraft:farmer"}} run \
	function stellarity:mobs/villager/trades/farmer
execute if data storage stellarity:temp {villager:{type:"minecraft:fisherman"}} run \
	function stellarity:mobs/villager/trades/fisherman
execute if data storage stellarity:temp {villager:{type:"minecraft:fletcher"}} run \
	function stellarity:mobs/villager/trades/fletcher
execute if data storage stellarity:temp {villager:{type:"minecraft:leatherworker"}} run \
	function stellarity:mobs/villager/trades/leatherworker
execute if data storage stellarity:temp {villager:{type:"minecraft:librarian"}} run \
	function stellarity:mobs/villager/trades/librarian
execute if data storage stellarity:temp {villager:{type:"minecraft:mason"}} run \
	function stellarity:mobs/villager/trades/mason
execute if data storage stellarity:temp {villager:{type:"minecraft:shepherd"}} run \
	function stellarity:mobs/villager/trades/shepherd
execute if data storage stellarity:temp {villager:{type:"minecraft:toolsmith"}} run \
	function stellarity:mobs/villager/trades/toolsmith
execute if data storage stellarity:temp {villager:{type:"minecraft:weaponsmith"}} run \
	function stellarity:mobs/villager/trades/weaponsmith

data modify entity @s VillagerData.level set value 5
data modify entity @s Offers.Recipes set from storage stellarity:temp villager.trades

particle minecraft:happy_villager ~ ~.5 ~ 0.5 .75 0.5 0 8
particle minecraft:dragon_breath ~ ~.5 ~ 0.5 .75 0.5 0 8
