execute if score @s stellarity.dragon.heartbeat matches 30.. run playsound entity.warden.heartbeat hostile @a[distance=0..] ~ ~2 ~ 8 0
execute if score @s stellarity.dragon.heartbeat matches 30.. run particle minecraft:flash ~ ~2 ~ 0 0 0 1 1 force
execute if score @s stellarity.dragon.heartbeat matches 30.. run scoreboard players reset @s stellarity.dragon.heartbeat
