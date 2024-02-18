## Items
function stellarity:items/main_player

## Advancements
# Beam Me Up
# Teleport over 100 blocks with a single Ender Pearl
execute if entity @s[scores={kohara.used_ender_pearl=1..},advancements={stellarity:adventure/beam_me_up=false}] run function stellarity:utils/advancements/beam_me_up/throw
execute if entity @s[tag=stellarity.pearl_advancement_pending] run function stellarity:utils/advancements/beam_me_up/loop

# Super Sonic
# Fly through a one block gap with an Elytra while moving over 40m/s
execute if entity @s[advancements={stellarity:end_city/super_sonic=false},scores={kohara.flight_speed=20..}] unless block ^ ^1 ^ #kohara:non_solid unless block ^ ^-1 ^ #kohara:non_solid unless block ^1 ^ ^ #kohara:non_solid unless block ^-1 ^ ^ #kohara:non_solid run advancement grant @s only stellarity:end_city/super_sonic

# Totem of Undying gives Levitation when falling out of the world
execute if entity @s[predicate=kohara:holding/a_totem,predicate=stellarity:locations/in_void] run function stellarity:mechanics/void_totem_protection/save

scoreboard players add @s stellarity.misc.loop.2t 1
execute if entity @s[scores={stellarity.misc.loop.2t=2}] run function stellarity:loops/player_loop_2t

scoreboard players add @s stellarity.misc.loop.3t 1
execute if entity @s[scores={stellarity.misc.loop.3t=3}] run function stellarity:loops/player_loop_3t

scoreboard players add @s stellarity.misc.loop.5t 1
execute if entity @s[scores={stellarity.misc.loop.5t=5}] run function stellarity:loops/player_loop_5t

scoreboard players add @s stellarity.misc.loop.1s 1
execute if entity @s[scores={stellarity.misc.loop.1s=20}] run function stellarity:loops/player_loop_1s

scoreboard players add @s stellarity.misc.loop.10s 1
execute if entity @s[scores={stellarity.misc.loop.10s=200}] run function stellarity:loops/player_loop_10s
