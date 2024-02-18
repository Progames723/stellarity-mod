data modify storage stellarity:temp villager.type set from entity @s VillagerData.profession
execute unless data storage stellarity:temp {villager:{type:"minecraft:none"}} run function stellarity:mobs/villager/tag
