scoreboard players add @s stellarity.items.ender_insignia.hold_duration 1 

# Removing effects
execute if entity @s[nbt={HurtTime:9s}] run function stellarity:items/ender_insignia/hurt

execute if entity @s[predicate=!kohara:player/is_sneaking,tag=stellarity.ender_insignia.active] run function stellarity:items/ender_insignia/stop_sneaking
execute if entity @s[predicate=!stellarity:items/holding/trinkets/ender_insignia,tag=stellarity.ender_insignia.active] run function stellarity:items/ender_insignia/stop_sneaking

execute if score @s stellarity.items.ender_insignia.hold_duration matches 1 run playsound minecraft:block.beacon.activate player @a[distance=0..] ~ ~ ~

# Reduce momevemt speed
execute if score @s stellarity.items.ender_insignia.hold_duration matches 1 run attribute @s generic.movement_speed modifier add 401458ce-37e6-408f-9b4d-0ec9a6e65947 "stellarity.ender_insignia" -0.3 multiply

# Tier 1
execute if score @s stellarity.items.ender_insignia.hold_duration matches 40 run function stellarity:items/ender_insignia/effects/1
# Tier 2
execute if score @s stellarity.items.ender_insignia.hold_duration matches 73 run function stellarity:items/ender_insignia/effects/2

# Tier 3
execute if score @s stellarity.items.ender_insignia.hold_duration matches 106 run function stellarity:items/ender_insignia/effects/3

# Tier 4
execute if score @s stellarity.items.ender_insignia.hold_duration matches 139 run function stellarity:items/ender_insignia/effects/4

# Tier 5
execute if score @s stellarity.items.ender_insignia.hold_duration matches 172 run function stellarity:items/ender_insignia/effects/5

# Portal Particles
execute if score @s stellarity.items.ender_insignia.hold_duration matches 40..72 run particle minecraft:portal ~ ~1.05 ~ 0 0 0 0.87 2 force
execute if score @s stellarity.items.ender_insignia.hold_duration matches 73..105 run particle minecraft:portal ~ ~1.05 ~ 0 0 0 0.87 4 force
execute if score @s stellarity.items.ender_insignia.hold_duration matches 106..138 run particle minecraft:portal ~ ~1.05 ~ 0 0 0 0.87 6 force
execute if score @s stellarity.items.ender_insignia.hold_duration matches 139..171 run particle minecraft:portal ~ ~1.05 ~ 0 0 0 0.87 8 force
execute if score @s stellarity.items.ender_insignia.hold_duration matches 172.. run particle minecraft:portal ~ ~1.05 ~ 0 0 0 0.87 10 force
