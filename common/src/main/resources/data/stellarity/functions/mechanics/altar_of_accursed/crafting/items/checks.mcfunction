# Cursed Enchiridion/Enchillada/Tome/Whatever
execute if entity @e[type=item,tag=stellarity.aota.enchanted_book,distance=..1.5] run \
	function stellarity:mechanics/altar_of_accursed/crafting/items/cursed_tome

# Chorus Plating
execute if entity @e[type=item,tag=stellarity.aota.iron_ingot,distance=..1.5] \
	if entity @e[type=item,tag=stellarity.aota.popped_chorus_fruit,distance=..1.5] run \
	function stellarity:mechanics/altar_of_accursed/crafting/items/chorus_plating

# Copying Enderite Upgrade Smithing Template
execute if entity @e[type=item,tag=stellarity.aota.enderite_smithing_template,distance=..1.5] \
	if entity @e[type=item,tag=stellarity.aota.9_purpur_blocks,distance=..1.5] \
	if entity @e[type=item,tag=stellarity.aota.3_diamonds,distance=..1.5] run \
	function stellarity:mechanics/altar_of_accursed/crafting/items/smithing_template

# Pandora's Barrel
execute if entity @e[type=item,tag=stellarity.aota.barrel,distance=..1.5] \
	if entity @e[type=item,tag=stellarity.aota.1_iron_block,distance=..1.5] \
	if entity @e[type=item,tag=stellarity.aota.1_gold_block,distance=..1.5] run \
	function stellarity:mechanics/altar_of_accursed/crafting/items/pandoras_barrel
