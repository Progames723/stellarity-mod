execute store result score #temp1 stellarity.misc run loot spawn ~ ~ ~ loot stellarity:mobs/eol/loot_50

execute if predicate kohara:chance/15percent run loot spawn ~ ~ ~ loot stellarity:items/trinkets/soaring_insignia

execute if score #temp1 stellarity.misc matches 0 run loot spawn ~ ~ ~ loot stellarity:mobs/eol/loot

execute as @e[type=item,distance=..1] run data modify entity @s Glowing set value 1b
execute as @e[type=item,distance=..1] run team join stellarity.eol.night_glow @s
execute as @e[type=item,distance=..1] run tag @s add stellarity.boss_drop

summon experience_orb ~ ~ ~ {Value:600s}
