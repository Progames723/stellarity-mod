## Debuff immunity
# Levitation
effect clear @s levitation 
# Wither
effect clear @s wither

# 20%/40% Damage Reduction
execute store result score #temp stellarity.misc if entity @e[type=!#kohara:invalid_targets,distance=0.01..6]
execute if score #temp stellarity.misc matches ..3 run effect give @s minecraft:resistance 1 0 true
execute if score #temp stellarity.misc matches 4.. run effect give @s minecraft:resistance 1 1 true
