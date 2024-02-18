execute if predicate stellarity:locations/dragons_den/in_biome run title @p[predicate=stellarity:void_fishing/holding_fishing_rod/any] actionbar {"translate":"stellarity.void_fishing.warning.dragons_den","fallback": "No fish dares to enter this area...","color":"dark_purple"}


execute unless predicate stellarity:locations/dragons_den/in_biome if predicate stellarity:locations/below_y_0 run title @p[predicate=stellarity:void_fishing/holding_fishing_rod/any] actionbar {"translate":"stellarity.void_fishing.warning.too_deep","fallback": "Something tells you you should fish higher...","color":"dark_purple"}

execute unless predicate stellarity:locations/dragons_den/in_biome unless predicate stellarity:locations/below_y_0 run function stellarity:mechanics/void_fishing/as_bobber/start
