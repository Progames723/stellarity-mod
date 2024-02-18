# No particles in first frame for the sake of visibility
execute if score @s stellarity.misc matches 1.. run particle minecraft:dust 1.0 0.9 0.4 1.33 ~ ~ ~ 0.12 0.12 0.12 0 8 force

scoreboard players add @s stellarity.misc 1

execute if score @s stellarity.misc matches 1 run playsound minecraft:entity.firework_rocket.launch player @a[distance=0..] ~ ~ ~ 0.88 0.8

execute if data entity @s inBlockState run kill @s
execute if score @s stellarity.misc matches 21.. run kill @s

execute unless entity @s[tag=stellarity.items.sharanga.buffed_velocity] run function stellarity:items/sharanga/velocity
