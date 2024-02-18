data modify entity @s Invulnerable set value 1b
tag @s add stellarity.to_portal

data modify entity @s DragonPhase set value 3

execute as @a[scores={stellarity.music.ender_dragon.timer=1..}] run function stellarity:mobs/dragon/music/reset
