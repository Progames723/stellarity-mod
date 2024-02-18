# Damage is set in 'spin/start', hence
# the 0% bonus efficiency

tag @p[predicate=stellarity:items/holding/prismember,distance=0.001..] add kohara.attacker

function kohara:damage/calculate {armor_penetration:65,damage_boost_efficiency:0,damage_type:"stellarity:prismember",tag:"stellarity.damage.prismember"}

# Prismatic Inferno
scoreboard players set #dot.time stellarity.misc 60

scoreboard players operation #dot.time stellarity.misc += #enchant stellarity.misc

function stellarity:utils/status_effects/prismatic_inferno/apply
