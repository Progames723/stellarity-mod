function stellarity:items/spellbooks/main

# Prismatic Punch
execute if entity @s[tag=stellarity.prismatic_blast] run function stellarity:items/prismatic_punch/blast_loop

# Sariel
execute if entity @s[tag=stellarity.sariel.heal_orb] anchored eyes run function stellarity:items/sariel/orb_loop

# Starstruck Carcanet
execute if entity @s[tag=stellarity.carcanet.star] run function stellarity:items/starstruck_carcanet/star_loop

# Prismember
execute if entity @s[tag=stellarity.prismember] run function stellarity:items/prismember/spin/animation/main

# Copper Elektra Shield
execute if entity @s[tag=stellarity.items.elektra_shield.marker] run function stellarity:items/elektra_shield/dash/as_marker
