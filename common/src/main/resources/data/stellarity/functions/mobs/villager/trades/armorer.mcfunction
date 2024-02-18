## Diamond Armor
execute store result score #trade stellarity.misc run random value 1..2
# Diamond Helmet + Diamond Leggings
execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:3,rewardExp:1b,priceMultiplier:0.2,demand:3,specialPrice:0,buy:{id:"emerald",Count:34,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"stone",Count:1,tag:{}}}
item replace entity @s villager.0 with diamond_helmet
item modify entity @s villager.0 stellarity:villager_enchant_item_randomly
data modify storage stellarity:temp villager.trades[-1].sell set from entity @s Inventory[0]

execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:3,rewardExp:1b,priceMultiplier:0.2,demand:3,specialPrice:0,buy:{id:"emerald",Count:37,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"stone",Count:1,tag:{}}}
item replace entity @s villager.0 with diamond_leggings
item modify entity @s villager.0 stellarity:villager_enchant_item_randomly
data modify storage stellarity:temp villager.trades[-1].sell set from entity @s Inventory[0]

# Diamond Chestplate + Diamond Boots
execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:3,rewardExp:1b,priceMultiplier:0.2,demand:3,specialPrice:0,buy:{id:"emerald",Count:35,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"stone",Count:1,tag:{}}}
item replace entity @s villager.0 with diamond_chestplate
item modify entity @s villager.0 stellarity:villager_enchant_item_randomly
data modify storage stellarity:temp villager.trades[-1].sell set from entity @s Inventory[0]

execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:3,rewardExp:1b,priceMultiplier:0.2,demand:3,specialPrice:0,buy:{id:"emerald",Count:32,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"stone",Count:1,tag:{}}}
item replace entity @s villager.0 with diamond_boots
item modify entity @s villager.0 stellarity:villager_enchant_item_randomly
data modify storage stellarity:temp villager.trades[-1].sell set from entity @s Inventory[0]

##
data modify storage stellarity:temp villager.trades append value {maxUses:6,rewardExp:1b,priceMultiplier:0.2,demand:6,specialPrice:0,buy:{id:"emerald",Count:32,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"bell",Count:1,tag:{}}}
# Iron Ingot -> Emerald
# Coal -> Emerald
execute store result score #trade stellarity.misc run random value 1..3
execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"iron_ingot",Count:6,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:2,tag:{}}}
execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:16,rewardExp:1b,priceMultiplier:0.05,demand:16,specialPrice:0,buy:{id:"coal",Count:22,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:2,tag:{}}}
# Coal -> Emerald
# Diamond -> Emerald
execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:16,rewardExp:1b,priceMultiplier:0.05,demand:16,specialPrice:0,buy:{id:"coal",Count:22,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:2,tag:{}}}
execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:16,rewardExp:1b,priceMultiplier:0.05,demand:16,specialPrice:0,buy:{id:"diamond",Count:1,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:2,tag:{}}}
# Iron Ingot -> Emerald
# Diamond -> Emerald
execute if score #trade stellarity.misc matches 3 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"iron_ingot",Count:6,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:2,tag:{}}}
execute if score #trade stellarity.misc matches 3 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:16,rewardExp:1b,priceMultiplier:0.05,demand:16,specialPrice:0,buy:{id:"diamond",Count:1,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:2,tag:{}}}

data modify storage stellarity:temp villager.trades append value {maxUses:4,rewardExp:1b,priceMultiplier:0.15,demand:4,specialPrice:0,buy:{id:"emerald",Count:7,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"lava_bucket",Count:1,tag:{}}}

data modify storage stellarity:temp villager.trades append value {maxUses:3,rewardExp:1b,priceMultiplier:0.05,demand:3,specialPrice:0,buy:{id:"emerald",Count:9,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"shield",Count:1,tag:{}}}

execute if predicate kohara:chance/25percent run \
	data modify storage stellarity:temp villager.trades append value {maxUses:4,rewardExp:1b,priceMultiplier:0.3,demand:4,specialPrice:0,buy:{id:"netherite_scrap",Count:4,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"emerald",Count:17,tag:{}}}

execute store result score #trade stellarity.misc run random value 1..2

execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:6,rewardExp:1b,priceMultiplier:0.5,demand:6,specialPrice:0,buy:{id:"emerald",Count:12,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"iron_ingot",Count:4,tag:{}}}
execute if score #trade stellarity.misc matches 1 run loot spawn ~ ~-5 ~ loot stellarity:items/materials/hallowed_ingot
execute if score #trade stellarity.misc matches 1 positioned ~ ~-5 ~ run data modify storage stellarity:temp villager.trades[-1].sell set from entity @e[type=item,limit=1,sort=nearest] Item.tag
execute if score #trade stellarity.misc matches 1 positioned ~ ~-5 ~ run kill @e[type=item,limit=1,sort=nearest]

execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:6,rewardExp:1b,priceMultiplier:0.5,demand:6,specialPrice:0,buy:{id:"emerald",Count:12,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"iron_ingot",Count:4,tag:{}}}
execute if score #trade stellarity.misc matches 2 run loot spawn ~ ~-5 ~ loot stellarity:items/materials/chorus_plating
execute if score #trade stellarity.misc matches 2 positioned ~ ~-5 ~ run data modify storage stellarity:temp villager.trades[-1].sell set from entity @e[type=item,limit=1,sort=nearest] Item.tag
execute if score #trade stellarity.misc matches 2 positioned ~ ~-5 ~ run kill @e[type=item,limit=1,sort=nearest]


execute store result score #trade stellarity.misc run random value 1..2

execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"emerald",Count:28,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"sentry_armor_trim_smithing_template",Count:1,tag:{}}}
execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"emerald",Count:28,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"vex_armor_trim_smithing_template",Count:1,tag:{}}}

execute store result score #trade stellarity.misc run random value 1..5

execute if score #trade stellarity.misc matches 1..4 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"emerald",Count:28,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"ward_armor_trim_smithing_template",Count:1,tag:{}}}
execute if score #trade stellarity.misc matches 5 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.3,demand:12,specialPrice:0,buy:{id:"emerald",Count:48,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"silence_armor_trim_smithing_template",Count:1,tag:{}}}

execute store result score #trade stellarity.misc run random value 1..2

execute if score #trade stellarity.misc matches 1 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"emerald",Count:28,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"wild_armor_trim_smithing_template",Count:1,tag:{}}}
execute if score #trade stellarity.misc matches 2 run \
	data modify storage stellarity:temp villager.trades append value {maxUses:12,rewardExp:1b,priceMultiplier:0.05,demand:12,specialPrice:0,buy:{id:"emerald",Count:28,tag:{}},buyB:{id:"air",Count:1,tag:{}},sell:{id:"coast_armor_trim_smithing_template",Count:1,tag:{}}}
