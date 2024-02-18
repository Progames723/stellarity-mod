# Cursed Enchiridion
tag @s[nbt={Item:{id:"minecraft:enchanted_book",Count:1b}}] add stellarity.aota.enchanted_book

# Pandora's Barrel
tag @s remove stellarity.aota.barrel
tag @s remove stellarity.aota.1_iron_block
tag @s remove stellarity.aota.1_gold_block
execute if entity @s[nbt={Item:{id:"minecraft:barrel",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.barrel
tag @s[nbt={Item:{id:"minecraft:iron_block",Count:1b}}] add stellarity.aota.1_iron_block
tag @s[nbt={Item:{id:"minecraft:gold_block",Count:1b}}] add stellarity.aota.1_gold_block

## Armor sets
# Netherite Armor
tag @s[nbt={Item:{id:"minecraft:netherite_helmet",Count:1b}}] add stellarity.aota.netherite_helmet
tag @s[nbt={Item:{id:"minecraft:netherite_leggings",Count:1b}}] add stellarity.aota.netherite_leggings
tag @s[nbt={Item:{id:"minecraft:netherite_chestplate",Count:1b}}] add stellarity.aota.netherite_chestplate
tag @s[nbt={Item:{id:"minecraft:netherite_boots",Count:1b}}] add stellarity.aota.netherite_boots
# Netherite Tools (for Shulker Tools)
execute if entity @s[nbt={Item:{id:"minecraft:netherite_pickaxe",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.netherite_pickaxe
execute if entity @s[nbt={Item:{id:"minecraft:netherite_hoe",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.netherite_hoe
execute if entity @s[nbt={Item:{id:"minecraft:netherite_shovel",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.netherite_shovel
execute if entity @s[nbt={Item:{id:"minecraft:netherite_axe",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.netherite_axe
execute if entity @s[nbt={Item:{id:"minecraft:netherite_sword",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.netherite_sword
# Materials
tag @s remove stellarity.aota.hallowed_ingots
tag @s remove stellarity.aota.chorus_plating
tag @s remove stellarity.aota.shulker_shells
tag @s remove stellarity.aota.cherry_leaves
tag @s[nbt={Item:{id:"minecraft:iron_ingot",Count:4b,tag:{stellarity.special_item:"hallowed_ingot"}}}] add stellarity.aota.hallowed_ingots
tag @s[nbt={Item:{id:"minecraft:iron_ingot",Count:4b,tag:{stellarity.special_item:"chorus_plating"}}}] add stellarity.aota.chorus_plating
tag @s[nbt={Item:{id:"minecraft:shulker_shell",Count:4b}}] add stellarity.aota.shulker_shells
tag @s[nbt={Item:{id:"minecraft:cherry_leaves",Count:8b}}] add stellarity.aota.cherry_leaves
# Enderite Upgrade Smithing Template
tag @s remove stellarity.aota.enderite_smithing_template
tag @s[nbt={Item:{id:"minecraft:jigsaw",Count:1b,tag:{stellarity.special_item:"enderite_smithing_template"}}}] add stellarity.aota.enderite_smithing_template

# Chorus Plating
tag @s remove stellarity.aota.iron_ingot
tag @s remove stellarity.aota.popped_chorus_fruit
execute if entity @s[nbt={Item:{id:"minecraft:iron_ingot",Count:1b}}] unless data entity @s Item.tag."stellarity.special_item" run tag @s add stellarity.aota.iron_ingot
tag @s[nbt={Item:{id:"minecraft:popped_chorus_fruit",Count:2b}}] add stellarity.aota.popped_chorus_fruit

# Copying Enderite Upgrade Smithing Templates
tag @s remove stellarity.aota.3_diamonds
tag @s[nbt={Item:{id:"minecraft:diamond",Count:3b}}] add stellarity.aota.3_diamonds
tag @s remove stellarity.aota.9_purpur_blocks
tag @s[nbt={Item:{id:"minecraft:purpur_block",Count:9b}}] add stellarity.aota.9_purpur_blocks

# Discenchanting (while it is last, it takes priority over everything)
tag @s remove stellarity.aota.book
execute if entity @s[nbt={Item:{id:"minecraft:book",Count:1b}}] run tag @s add stellarity.aota.book
execute if data entity @s Item.tag.Enchantments if data entity @s Item.tag.Enchantments[0].id run tag @s add stellarity.aota.enchanted

data modify entity @s PickupDelay set value 21s
data modify entity @s Glowing set value 1b
team join stellarity.purple_glow @s

execute unless entity @s[tag=stellarity.aota.particles] at @s run particle minecraft:witch ~ ~.5 ~ 0 0 0 10 6 normal
execute unless entity @s[tag=stellarity.aota.particles] at @s run particle minecraft:smoke ~ ~.5 ~ 0 0 0 0.02 6 normal
tag @s add stellarity.aota.particles