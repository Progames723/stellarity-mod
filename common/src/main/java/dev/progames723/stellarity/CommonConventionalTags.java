package dev.progames723.stellarity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.Block;

/**
 * i just crammed them in one class, okay?
 * and PLEASE FOR THE LOVE OF GOD DONT USE FORGE ON FABRIC AND VICE VERSA
 */
@SuppressWarnings("unused")
public class CommonConventionalTags {
	public static class Forge {
		public static class ForgeItemTags {
			public static final TagKey<Item> BARRELS = registerForge("barrels");
			public static final TagKey<Item> BARRELS_WOODEN = registerForge("barrels/wooden");
			public static final TagKey<Item> BONES = registerForge("bones");
			public static final TagKey<Item> BOOKSHELVES = registerForge("bookshelves");
			public static final TagKey<Item> CHESTS = registerForge("chests");
			public static final TagKey<Item> CHESTS_ENDER = registerForge("chests/ender");
			public static final TagKey<Item> CHESTS_TRAPPED = registerForge("chests/trapped");
			public static final TagKey<Item> CHESTS_WOODEN = registerForge("chests/wooden");
			public static final TagKey<Item> COBBLESTONE = registerForge("cobblestone");
			public static final TagKey<Item> COBBLESTONE_NORMAL = registerForge("cobblestone/normal");
			public static final TagKey<Item> COBBLESTONE_INFESTED = registerForge("cobblestone/infested");
			public static final TagKey<Item> COBBLESTONE_MOSSY = registerForge("cobblestone/mossy");
			public static final TagKey<Item> COBBLESTONE_DEEPSLATE = registerForge("cobblestone/deepslate");
			public static final TagKey<Item> CROPS = registerForge("crops");
			public static final TagKey<Item> CROPS_BEETROOT = registerForge("crops/beetroot");
			public static final TagKey<Item> CROPS_CARROT = registerForge("crops/carrot");
			public static final TagKey<Item> CROPS_NETHER_WART = registerForge("crops/nether_wart");
			public static final TagKey<Item> CROPS_POTATO = registerForge("crops/potato");
			public static final TagKey<Item> CROPS_WHEAT = registerForge("crops/wheat");
			public static final TagKey<Item> DUSTS = registerForge("dusts");
			public static final TagKey<Item> DUSTS_PRISMARINE = registerForge("dusts/prismarine");
			public static final TagKey<Item> DUSTS_REDSTONE = registerForge("dusts/redstone");
			public static final TagKey<Item> DUSTS_GLOWSTONE = registerForge("dusts/glowstone");
			public static final TagKey<Item> DYES = registerForge("dyes");
			public static final TagKey<Item> EGGS = registerForge("eggs");
			public static final TagKey<Item> ENCHANTING_FUELS = registerForge("enchanting_fuels");
			public static final TagKey<Item> END_STONES = registerForge("end_stones");
			public static final TagKey<Item> ENDER_PEARLS = registerForge("ender_pearls");
			public static final TagKey<Item> FEATHERS = registerForge("feathers");
			public static final TagKey<Item> FENCE_GATES = registerForge("fence_gates");
			public static final TagKey<Item> FENCE_GATES_WOODEN = registerForge("fence_gates/wooden");
			public static final TagKey<Item> FENCES = registerForge("fences");
			public static final TagKey<Item> FENCES_NETHER_BRICK = registerForge("fences/nether_brick");
			public static final TagKey<Item> FENCES_WOODEN = registerForge("fences/wooden");
			public static final TagKey<Item> GEMS = registerForge("gems");
			public static final TagKey<Item> GEMS_DIAMOND = registerForge("gems/diamond");
			public static final TagKey<Item> GEMS_EMERALD = registerForge("gems/emerald");
			public static final TagKey<Item> GEMS_AMETHYST = registerForge("gems/amethyst");
			public static final TagKey<Item> GEMS_LAPIS = registerForge("gems/lapis");
			public static final TagKey<Item> GEMS_PRISMARINE = registerForge("gems/prismarine");
			public static final TagKey<Item> GEMS_QUARTZ = registerForge("gems/quartz");
			public static final TagKey<Item> GLASS = registerForge("glass");
			public static final TagKey<Item> GLASS_BLACK = registerForge("glass/black");
			public static final TagKey<Item> GLASS_BLUE = registerForge("glass/blue");
			public static final TagKey<Item> GLASS_BROWN = registerForge("glass/brown");
			public static final TagKey<Item> GLASS_COLORLESS = registerForge("glass/colorless");
			public static final TagKey<Item> GLASS_CYAN = registerForge("glass/cyan");
			public static final TagKey<Item> GLASS_GRAY = registerForge("glass/gray");
			public static final TagKey<Item> GLASS_GREEN = registerForge("glass/green");
			public static final TagKey<Item> GLASS_LIGHT_BLUE = registerForge("glass/light_blue");
			public static final TagKey<Item> GLASS_LIGHT_GRAY = registerForge("glass/light_gray");
			public static final TagKey<Item> GLASS_LIME = registerForge("glass/lime");
			public static final TagKey<Item> GLASS_MAGENTA = registerForge("glass/magenta");
			public static final TagKey<Item> GLASS_ORANGE = registerForge("glass/orange");
			public static final TagKey<Item> GLASS_PINK = registerForge("glass/pink");
			public static final TagKey<Item> GLASS_PURPLE = registerForge("glass/purple");
			public static final TagKey<Item> GLASS_RED = registerForge("glass/red");
			public static final TagKey<Item> GLASS_SILICA = registerForge("glass/silica");
			public static final TagKey<Item> GLASS_TINTED = registerForge("glass/tinted");
			public static final TagKey<Item> GLASS_WHITE = registerForge("glass/white");
			public static final TagKey<Item> GLASS_YELLOW = registerForge("glass/yellow");
			public static final TagKey<Item> GLASS_PANES = registerForge("glass_panes");
			public static final TagKey<Item> GLASS_PANES_BLACK = registerForge("glass_panes/black");
			public static final TagKey<Item> GLASS_PANES_BLUE = registerForge("glass_panes/blue");
			public static final TagKey<Item> GLASS_PANES_BROWN = registerForge("glass_panes/brown");
			public static final TagKey<Item> GLASS_PANES_COLORLESS = registerForge("glass_panes/colorless");
			public static final TagKey<Item> GLASS_PANES_CYAN = registerForge("glass_panes/cyan");
			public static final TagKey<Item> GLASS_PANES_GRAY = registerForge("glass_panes/gray");
			public static final TagKey<Item> GLASS_PANES_GREEN = registerForge("glass_panes/green");
			public static final TagKey<Item> GLASS_PANES_LIGHT_BLUE = registerForge("glass_panes/light_blue");
			public static final TagKey<Item> GLASS_PANES_LIGHT_GRAY = registerForge("glass_panes/light_gray");
			public static final TagKey<Item> GLASS_PANES_LIME = registerForge("glass_panes/lime");
			public static final TagKey<Item> GLASS_PANES_MAGENTA = registerForge("glass_panes/magenta");
			public static final TagKey<Item> GLASS_PANES_ORANGE = registerForge("glass_panes/orange");
			public static final TagKey<Item> GLASS_PANES_PINK = registerForge("glass_panes/pink");
			public static final TagKey<Item> GLASS_PANES_PURPLE = registerForge("glass_panes/purple");
			public static final TagKey<Item> GLASS_PANES_RED = registerForge("glass_panes/red");
			public static final TagKey<Item> GLASS_PANES_WHITE = registerForge("glass_panes/white");
			public static final TagKey<Item> GLASS_PANES_YELLOW = registerForge("glass_panes/yellow");
			public static final TagKey<Item> GRAVEL = registerForge("gravel");
			public static final TagKey<Item> GUNPOWDER = registerForge("gunpowder");
			public static final TagKey<Item> HEADS = registerForge("heads");
			public static final TagKey<Item> INGOTS = registerForge("ingots");
			public static final TagKey<Item> INGOTS_BRICK = registerForge("ingots/brick");
			public static final TagKey<Item> INGOTS_COPPER = registerForge("ingots/copper");
			public static final TagKey<Item> INGOTS_GOLD = registerForge("ingots/gold");
			public static final TagKey<Item> INGOTS_IRON = registerForge("ingots/iron");
			public static final TagKey<Item> INGOTS_NETHERITE = registerForge("ingots/netherite");
			public static final TagKey<Item> INGOTS_NETHER_BRICK = registerForge("ingots/nether_brick");
			public static final TagKey<Item> LEATHER = registerForge("leather");
			public static final TagKey<Item> MUSHROOMS = registerForge("mushrooms");
			public static final TagKey<Item> NETHER_STARS = registerForge("nether_stars");
			public static final TagKey<Item> NETHERRACK = registerForge("netherrack");
			public static final TagKey<Item> NUGGETS = registerForge("nuggets");
			public static final TagKey<Item> NUGGETS_GOLD = registerForge("nuggets/gold");
			public static final TagKey<Item> NUGGETS_IRON = registerForge("nuggets/iron");
			public static final TagKey<Item> OBSIDIAN = registerForge("obsidian");
			public static final TagKey<Item> ORE_BEARING_GROUND_DEEPSLATE = registerForge("ore_bearing_ground/deepslate");
			public static final TagKey<Item> ORE_BEARING_GROUND_NETHERRACK = registerForge("ore_bearing_ground/netherrack");
			public static final TagKey<Item> ORE_BEARING_GROUND_STONE = registerForge("ore_bearing_ground/stone");
			public static final TagKey<Item> ORE_RATES_DENSE = registerForge("ore_rates/dense");
			public static final TagKey<Item> ORE_RATES_SINGULAR = registerForge("ore_rates/singular");
			public static final TagKey<Item> ORE_RATES_SPARSE = registerForge("ore_rates/sparse");
			public static final TagKey<Item> ORES = registerForge("ores");
			public static final TagKey<Item> ORES_COAL = registerForge("ores/coal");
			public static final TagKey<Item> ORES_COPPER = registerForge("ores/copper");
			public static final TagKey<Item> ORES_DIAMOND = registerForge("ores/diamond");
			public static final TagKey<Item> ORES_EMERALD = registerForge("ores/emerald");
			public static final TagKey<Item> ORES_GOLD = registerForge("ores/gold");
			public static final TagKey<Item> ORES_IRON = registerForge("ores/iron");
			public static final TagKey<Item> ORES_LAPIS = registerForge("ores/lapis");
			public static final TagKey<Item> ORES_NETHERITE_SCRAP = registerForge("ores/netherite_scrap");
			public static final TagKey<Item> ORES_QUARTZ = registerForge("ores/quartz");
			public static final TagKey<Item> ORES_REDSTONE = registerForge("ores/redstone");
			public static final TagKey<Item> ORES_IN_GROUND_DEEPSLATE = registerForge("ores_in_ground/deepslate");
			public static final TagKey<Item> ORES_IN_GROUND_NETHERRACK = registerForge("ores_in_ground/netherrack");
			public static final TagKey<Item> ORES_IN_GROUND_STONE = registerForge("ores_in_ground/stone");
			public static final TagKey<Item> RAW_MATERIALS = registerForge("raw_materials");
			public static final TagKey<Item> RAW_MATERIALS_COPPER = registerForge("raw_materials/copper");
			public static final TagKey<Item> RAW_MATERIALS_GOLD = registerForge("raw_materials/gold");
			public static final TagKey<Item> RAW_MATERIALS_IRON = registerForge("raw_materials/iron");
			public static final TagKey<Item> RODS = registerForge("rods");
			public static final TagKey<Item> RODS_BLAZE = registerForge("rods/blaze");
			public static final TagKey<Item> RODS_WOODEN = registerForge("rods/wooden");
			public static final TagKey<Item> SAND = registerForge("sand");
			public static final TagKey<Item> SAND_COLORLESS = registerForge("sand/colorless");
			public static final TagKey<Item> SAND_RED = registerForge("sand/red");
			public static final TagKey<Item> SANDSTONE = registerForge("sandstone");
			public static final TagKey<Item> SEEDS = registerForge("seeds");
			public static final TagKey<Item> SEEDS_BEETROOT = registerForge("seeds/beetroot");
			public static final TagKey<Item> SEEDS_MELON = registerForge("seeds/melon");
			public static final TagKey<Item> SEEDS_PUMPKIN = registerForge("seeds/pumpkin");
			public static final TagKey<Item> SEEDS_WHEAT = registerForge("seeds/wheat");
			public static final TagKey<Item> SHEARS = registerForge("shears");
			public static final TagKey<Item> SLIMEBALLS = registerForge("slimeballs");
			public static final TagKey<Item> STAINED_GLASS = registerForge("stained_glass");
			public static final TagKey<Item> STAINED_GLASS_PANES = registerForge("stained_glass_panes");
			public static final TagKey<Item> STONE = registerForge("stone");
			public static final TagKey<Item> STORAGE_BLOCKS = registerForge("storage_blocks");
			public static final TagKey<Item> STORAGE_BLOCKS_AMETHYST = registerForge("storage_blocks/amethyst");
			public static final TagKey<Item> STORAGE_BLOCKS_COAL = registerForge("storage_blocks/coal");
			public static final TagKey<Item> STORAGE_BLOCKS_COPPER = registerForge("storage_blocks/copper");
			public static final TagKey<Item> STORAGE_BLOCKS_DIAMOND = registerForge("storage_blocks/diamond");
			public static final TagKey<Item> STORAGE_BLOCKS_EMERALD = registerForge("storage_blocks/emerald");
			public static final TagKey<Item> STORAGE_BLOCKS_GOLD = registerForge("storage_blocks/gold");
			public static final TagKey<Item> STORAGE_BLOCKS_IRON = registerForge("storage_blocks/iron");
			public static final TagKey<Item> STORAGE_BLOCKS_LAPIS = registerForge("storage_blocks/lapis");
			public static final TagKey<Item> STORAGE_BLOCKS_NETHERITE = registerForge("storage_blocks/netherite");
			public static final TagKey<Item> STORAGE_BLOCKS_QUARTZ = registerForge("storage_blocks/quartz");
			public static final TagKey<Item> STORAGE_BLOCKS_RAW_COPPER = registerForge("storage_blocks/raw_copper");
			public static final TagKey<Item> STORAGE_BLOCKS_RAW_GOLD = registerForge("storage_blocks/raw_gold");
			public static final TagKey<Item> STORAGE_BLOCKS_RAW_IRON = registerForge("storage_blocks/raw_iron");
			public static final TagKey<Item> STORAGE_BLOCKS_REDSTONE = registerForge("storage_blocks/redstone");
			public static final TagKey<Item> STRING = registerForge("string");
			public static final TagKey<Item> TOOLS = registerForge("tools");
			public static final TagKey<Item> TOOLS_SHIELDS = registerForge("tools/shields");
			public static final TagKey<Item> TOOLS_BOWS = registerForge("tools/bows");
			public static final TagKey<Item> TOOLS_CROSSBOWS = registerForge("tools/crossbows");
			public static final TagKey<Item> TOOLS_FISHING_RODS = registerForge("tools/fishing_rods");
			public static final TagKey<Item> TOOLS_TRIDENTS = registerForge("tools/tridents");
			public static final TagKey<Item> ARMORS = registerForge("armors");
			public static final TagKey<Item> ARMORS_HELMETS = registerForge("armors/helmets");
			public static final TagKey<Item> ARMORS_CHESTPLATES = registerForge("armors/chestplates");
			public static final TagKey<Item> ARMORS_LEGGINGS = registerForge("armors/leggings");
			public static final TagKey<Item> ARMORS_BOOTS = registerForge("armors/boots");
			private static TagKey<Item> registerForge(String tagId) {
				return TagKey.create(Registries.ITEM, new ResourceLocation("forge", tagId));
			}
		}
		public static class ForgeBlockTags {
			public static final TagKey<Block> BARRELS = registerForge("barrels");
			public static final TagKey<Block> BARRELS_WOODEN = registerForge("barrels/wooden");
			public static final TagKey<Block> BOOKSHELVES = registerForge("bookshelves");
			public static final TagKey<Block> CHESTS = registerForge("chests");
			public static final TagKey<Block> CHESTS_ENDER = registerForge("chests/ender");
			public static final TagKey<Block> CHESTS_TRAPPED = registerForge("chests/trapped");
			public static final TagKey<Block> CHESTS_WOODEN = registerForge("chests/wooden");
			public static final TagKey<Block> COBBLESTONE = registerForge("cobblestone");
			public static final TagKey<Block> COBBLESTONE_NORMAL = registerForge("cobblestone/normal");
			public static final TagKey<Block> COBBLESTONE_INFESTED = registerForge("cobblestone/infested");
			public static final TagKey<Block> COBBLESTONE_MOSSY = registerForge("cobblestone/mossy");
			public static final TagKey<Block> COBBLESTONE_DEEPSLATE = registerForge("cobblestone/deepslate");
			public static final TagKey<Block> END_STONES = registerForge("end_stones");
			public static final TagKey<Block> ENDERMAN_PLACE_ON_BLACKLIST = registerForge("enderman_place_on_blacklist");
			public static final TagKey<Block> FENCE_GATES = registerForge("fence_gates");
			public static final TagKey<Block> FENCE_GATES_WOODEN = registerForge("fence_gates/wooden");
			public static final TagKey<Block> FENCES = registerForge("fences");
			public static final TagKey<Block> FENCES_NETHER_BRICK = registerForge("fences/nether_brick");
			public static final TagKey<Block> FENCES_WOODEN = registerForge("fences/wooden");
			public static final TagKey<Block> GLASS = registerForge("glass");
			public static final TagKey<Block> GLASS_BLACK = registerForge("glass/black");
			public static final TagKey<Block> GLASS_BLUE = registerForge("glass/blue");
			public static final TagKey<Block> GLASS_BROWN = registerForge("glass/brown");
			public static final TagKey<Block> GLASS_COLORLESS = registerForge("glass/colorless");
			public static final TagKey<Block> GLASS_CYAN = registerForge("glass/cyan");
			public static final TagKey<Block> GLASS_GRAY = registerForge("glass/gray");
			public static final TagKey<Block> GLASS_GREEN = registerForge("glass/green");
			public static final TagKey<Block> GLASS_LIGHT_BLUE = registerForge("glass/light_blue");
			public static final TagKey<Block> GLASS_LIGHT_GRAY = registerForge("glass/light_gray");
			public static final TagKey<Block> GLASS_LIME = registerForge("glass/lime");
			public static final TagKey<Block> GLASS_MAGENTA = registerForge("glass/magenta");
			public static final TagKey<Block> GLASS_ORANGE = registerForge("glass/orange");
			public static final TagKey<Block> GLASS_PINK = registerForge("glass/pink");
			public static final TagKey<Block> GLASS_PURPLE = registerForge("glass/purple");
			public static final TagKey<Block> GLASS_RED = registerForge("glass/red");
			public static final TagKey<Block> GLASS_SILICA = registerForge("glass/silica");
			public static final TagKey<Block> GLASS_TINTED = registerForge("glass/tinted");
			public static final TagKey<Block> GLASS_WHITE = registerForge("glass/white");
			public static final TagKey<Block> GLASS_YELLOW = registerForge("glass/yellow");
			public static final TagKey<Block> GLASS_PANES = registerForge("glass_panes");
			public static final TagKey<Block> GLASS_PANES_BLACK = registerForge("glass_panes/black");
			public static final TagKey<Block> GLASS_PANES_BLUE = registerForge("glass_panes/blue");
			public static final TagKey<Block> GLASS_PANES_BROWN = registerForge("glass_panes/brown");
			public static final TagKey<Block> GLASS_PANES_COLORLESS = registerForge("glass_panes/colorless");
			public static final TagKey<Block> GLASS_PANES_CYAN = registerForge("glass_panes/cyan");
			public static final TagKey<Block> GLASS_PANES_GRAY = registerForge("glass_panes/gray");
			public static final TagKey<Block> GLASS_PANES_GREEN = registerForge("glass_panes/green");
			public static final TagKey<Block> GLASS_PANES_LIGHT_BLUE = registerForge("glass_panes/light_blue");
			public static final TagKey<Block> GLASS_PANES_LIGHT_GRAY = registerForge("glass_panes/light_gray");
			public static final TagKey<Block> GLASS_PANES_LIME = registerForge("glass_panes/lime");
			public static final TagKey<Block> GLASS_PANES_MAGENTA = registerForge("glass_panes/magenta");
			public static final TagKey<Block> GLASS_PANES_ORANGE = registerForge("glass_panes/orange");
			public static final TagKey<Block> GLASS_PANES_PINK = registerForge("glass_panes/pink");
			public static final TagKey<Block> GLASS_PANES_PURPLE = registerForge("glass_panes/purple");
			public static final TagKey<Block> GLASS_PANES_RED = registerForge("glass_panes/red");
			public static final TagKey<Block> GLASS_PANES_WHITE = registerForge("glass_panes/white");
			public static final TagKey<Block> GLASS_PANES_YELLOW = registerForge("glass_panes/yellow");
			public static final TagKey<Block> GRAVEL = registerForge("gravel");
			public static final TagKey<Block> NETHERRACK = registerForge("netherrack");
			public static final TagKey<Block> OBSIDIAN = registerForge("obsidian");
			public static final TagKey<Block> ORE_BEARING_GROUND_DEEPSLATE = registerForge("ore_bearing_ground/deepslate");
			public static final TagKey<Block> ORE_BEARING_GROUND_NETHERRACK = registerForge("ore_bearing_ground/netherrack");
			public static final TagKey<Block> ORE_BEARING_GROUND_STONE = registerForge("ore_bearing_ground/stone");
			public static final TagKey<Block> ORE_RATES_DENSE = registerForge("ore_rates/dense");
			public static final TagKey<Block> ORE_RATES_SINGULAR = registerForge("ore_rates/singular");
			public static final TagKey<Block> ORE_RATES_SPARSE = registerForge("ore_rates/sparse");
			public static final TagKey<Block> ORES = registerForge("ores");
			public static final TagKey<Block> ORES_COAL = registerForge("ores/coal");
			public static final TagKey<Block> ORES_COPPER = registerForge("ores/copper");
			public static final TagKey<Block> ORES_DIAMOND = registerForge("ores/diamond");
			public static final TagKey<Block> ORES_EMERALD = registerForge("ores/emerald");
			public static final TagKey<Block> ORES_GOLD = registerForge("ores/gold");
			public static final TagKey<Block> ORES_IRON = registerForge("ores/iron");
			public static final TagKey<Block> ORES_LAPIS = registerForge("ores/lapis");
			public static final TagKey<Block> ORES_NETHERITE_SCRAP = registerForge("ores/netherite_scrap");
			public static final TagKey<Block> ORES_QUARTZ = registerForge("ores/quartz");
			public static final TagKey<Block> ORES_REDSTONE = registerForge("ores/redstone");
			public static final TagKey<Block> ORES_IN_GROUND_DEEPSLATE = registerForge("ores_in_ground/deepslate");
			public static final TagKey<Block> ORES_IN_GROUND_NETHERRACK = registerForge("ores_in_ground/netherrack");
			public static final TagKey<Block> ORES_IN_GROUND_STONE = registerForge("ores_in_ground/stone");
			public static final TagKey<Block> SAND = registerForge("sand");
			public static final TagKey<Block> SAND_COLORLESS = registerForge("sand/colorless");
			public static final TagKey<Block> SAND_RED = registerForge("sand/red");
			public static final TagKey<Block> SANDSTONE = registerForge("sandstone");
			public static final TagKey<Block> STAINED_GLASS = registerForge("stained_glass");
			public static final TagKey<Block> STAINED_GLASS_PANES = registerForge("stained_glass_panes");
			public static final TagKey<Block> STONE = registerForge("stone");
			public static final TagKey<Block> STORAGE_BLOCKS = registerForge("storage_blocks");
			public static final TagKey<Block> STORAGE_BLOCKS_AMETHYST = registerForge("storage_blocks/amethyst");
			public static final TagKey<Block> STORAGE_BLOCKS_COAL = registerForge("storage_blocks/coal");
			public static final TagKey<Block> STORAGE_BLOCKS_COPPER = registerForge("storage_blocks/copper");
			public static final TagKey<Block> STORAGE_BLOCKS_DIAMOND = registerForge("storage_blocks/diamond");
			public static final TagKey<Block> STORAGE_BLOCKS_EMERALD = registerForge("storage_blocks/emerald");
			public static final TagKey<Block> STORAGE_BLOCKS_GOLD = registerForge("storage_blocks/gold");
			public static final TagKey<Block> STORAGE_BLOCKS_IRON = registerForge("storage_blocks/iron");
			public static final TagKey<Block> STORAGE_BLOCKS_LAPIS = registerForge("storage_blocks/lapis");
			public static final TagKey<Block> STORAGE_BLOCKS_NETHERITE = registerForge("storage_blocks/netherite");
			public static final TagKey<Block> STORAGE_BLOCKS_QUARTZ = registerForge("storage_blocks/quartz");
			public static final TagKey<Block> STORAGE_BLOCKS_RAW_COPPER = registerForge("storage_blocks/raw_copper");
			public static final TagKey<Block> STORAGE_BLOCKS_RAW_GOLD = registerForge("storage_blocks/raw_gold");
			public static final TagKey<Block> STORAGE_BLOCKS_RAW_IRON = registerForge("storage_blocks/raw_iron");
			public static final TagKey<Block> STORAGE_BLOCKS_REDSTONE = registerForge("storage_blocks/redstone");
			public static final TagKey<Block> NEEDS_WOOD_TOOL = registerForge("needs_wood_tool");
			public static final TagKey<Block> NEEDS_GOLD_TOOL = registerForge("needs_gold_tool");
			public static final TagKey<Block> NEEDS_NETHERITE_TOOL = registerForge("needs_netherite_tool");
			private static TagKey<Block> registerForge(String tagId) {
				return TagKey.create(Registries.BLOCK, new ResourceLocation("forge", tagId));
			}
		}
		public static class ForgeEntityTypeTags {
			public static final TagKey<EntityType<?>> BOSSES = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge", "bosses"));;
		}
	}
	public static class Fabric {
		public static class FabricItemTags {
			public static final TagKey<Item> SHEARS = registerFabric("shears");
			public static final TagKey<Item> SPEARS = registerFabric("spears");
			public static final TagKey<Item> BOWS = registerFabric("bows");
			public static final TagKey<Item> SHIELDS = registerFabric("shields");
			public static final TagKey<Item> DUSTS = registerFabric("dusts");
			public static final TagKey<Item> GEMS = registerFabric("gems");
			public static final TagKey<Item> INGOTS = registerFabric("ingots");
			public static final TagKey<Item> NUGGETS = registerFabric("nuggets");
			public static final TagKey<Item> ORES = registerFabric("ores");
			public static final TagKey<Item> RAW_ORES = registerFabric("raw_ores");
			public static final TagKey<Item> IRON_INGOTS = registerFabric("iron_ingots");
			public static final TagKey<Item> RAW_IRON_ORES = registerFabric("raw_iron_ores");
			public static final TagKey<Item> RAW_IRON_BLOCKS = registerFabric("raw_iron_blocks");
			public static final TagKey<Item> RAW_GOLD_ORES = registerFabric("raw_gold_ores");
			public static final TagKey<Item> RAW_GOLD_BLOCKS = registerFabric("raw_gold_blocks");
			public static final TagKey<Item> GOLD_INGOTS = registerFabric("gold_ingots");
			public static final TagKey<Item> REDSTONE_DUSTS = registerFabric("redstone_dusts");
			public static final TagKey<Item> COPPER_INGOTS = registerFabric("copper_ingots");
			public static final TagKey<Item> RAW_COPPER_ORES = registerFabric("raw_copper_ores");
			public static final TagKey<Item> RAW_COPPER_BLOCKS = registerFabric("raw_copper_blocks");
			public static final TagKey<Item> NETHERITE_INGOTS = registerFabric("netherite_ingots");
			public static final TagKey<Item> QUARTZ_ORES = registerFabric("quartz_ores");
			public static final TagKey<Item> QUARTZ = registerFabric("quartz");
			public static final TagKey<Item> LAPIS = registerFabric("lapis");
			public static final TagKey<Item> DIAMONDS = registerFabric("diamonds");
			public static final TagKey<Item> EMERALDS = registerFabric("emeralds");
			public static final TagKey<Item> COAL = registerFabric("coal");
			public static final TagKey<Item> FOODS = registerFabric("foods");
			public static final TagKey<Item> POTIONS = registerFabric("potions");
			public static final TagKey<Item> WATER_BUCKETS = registerFabric("water_buckets");
			public static final TagKey<Item> ENTITY_WATER_BUCKETS = registerFabric("entity_water_buckets");
			public static final TagKey<Item> LAVA_BUCKETS = registerFabric("lava_buckets");
			public static final TagKey<Item> MILK_BUCKETS = registerFabric("milk_buckets");
			public static final TagKey<Item> EMPTY_BUCKETS = registerFabric("empty_buckets");
			public static final TagKey<Item> BOOKSHELVES = registerFabric("bookshelves");
			public static final TagKey<Item> CHESTS = registerFabric("chests");
			public static final TagKey<Item> GLASS_BLOCKS = registerFabric("glass_blocks");
			public static final TagKey<Item> GLASS_PANES = registerFabric("glass_panes");
			public static final TagKey<Item> SHULKER_BOXES = registerFabric("shulker_boxes");
			public static final TagKey<Item> WOODEN_BARRELS = registerFabric("wooden_barrels");
			public static final TagKey<Item> BUDDING_BLOCKS = registerFabric("budding_blocks");
			public static final TagKey<Item> BUDS = registerFabric("buds");
			public static final TagKey<Item> CLUSTERS = registerFabric("clusters");
			public static final TagKey<Item> VILLAGER_JOB_SITES = registerFabric("villager_job_sites");
			public static final TagKey<Item> SANDSTONE_BLOCKS = registerFabric("sandstone_blocks");
			public static final TagKey<Item> SANDSTONE_SLABS = registerFabric("sandstone_slabs");
			public static final TagKey<Item> SANDSTONE_STAIRS = registerFabric("sandstone_stairs");
			public static final TagKey<Item> RED_SANDSTONE_BLOCKS = registerFabric("red_sandstone_blocks");
			public static final TagKey<Item> RED_SANDSTONE_SLABS = registerFabric("red_sandstone_slabs");
			public static final TagKey<Item> RED_SANDSTONE_STAIRS = registerFabric("red_sandstone_stairs");
			public static final TagKey<Item> UNCOLORED_SANDSTONE_BLOCKS = registerFabric("uncolored_sandstone_blocks");
			public static final TagKey<Item> UNCOLORED_SANDSTONE_SLABS = registerFabric("uncolored_sandstone_slabs");
			public static final TagKey<Item> UNCOLORED_SANDSTONE_STAIRS = registerFabric("uncolored_sandstone_stairs");
			public static final TagKey<Item> DYES = registerFabric("dyes");
			private static TagKey<Item> registerFabric(String tagId) {
				return TagKey.create(Registries.ITEM, new ResourceLocation("c", tagId));
			}
		}
		public static class FabricBlockTags {
			public static final TagKey<Block> ORES = registerFabric("ores");
			public static final TagKey<Block> QUARTZ_ORES = registerFabric("quartz_ores");
			public static final TagKey<Block> BOOKSHELVES = registerFabric("bookshelves");
			public static final TagKey<Block> CHESTS = registerFabric("chests");
			public static final TagKey<Block> GLASS_BLOCKS = registerFabric("glass_blocks");
			public static final TagKey<Block> GLASS_PANES = registerFabric("glass_panes");
			public static final TagKey<Block> SHULKER_BOXES = registerFabric("shulker_boxes");
			public static final TagKey<Block> WOODEN_BARRELS = registerFabric("wooden_barrels");
			public static final TagKey<Block> BUDDING_BLOCKS = registerFabric("budding_blocks");
			public static final TagKey<Block> BUDS = registerFabric("buds");
			public static final TagKey<Block> CLUSTERS = registerFabric("clusters");
			public static final TagKey<Block> VILLAGER_JOB_SITES = registerFabric("villager_job_sites");
			public static final TagKey<Block> SANDSTONE_BLOCKS = registerFabric("sandstone_blocks");
			public static final TagKey<Block> SANDSTONE_SLABS = registerFabric("sandstone_slabs");
			public static final TagKey<Block> SANDSTONE_STAIRS = registerFabric("sandstone_stairs");
			public static final TagKey<Block> RED_SANDSTONE_BLOCKS = registerFabric("red_sandstone_blocks");
			public static final TagKey<Block> RED_SANDSTONE_SLABS = registerFabric("red_sandstone_slabs");
			public static final TagKey<Block> RED_SANDSTONE_STAIRS = registerFabric("red_sandstone_stairs");
			public static final TagKey<Block> UNCOLORED_SANDSTONE_BLOCKS = registerFabric("uncolored_sandstone_blocks");
			public static final TagKey<Block> UNCOLORED_SANDSTONE_SLABS = registerFabric("uncolored_sandstone_slabs");
			public static final TagKey<Block> UNCOLORED_SANDSTONE_STAIRS = registerFabric("uncolored_sandstone_stairs");
			public static final TagKey<Block> MOVEMENT_RESTRICTED = registerFabric("movement_restricted");
			private static TagKey<Block> registerFabric(String tagId) {
				return TagKey.create(Registries.BLOCK, new ResourceLocation("c", tagId));
			}
		}
		public static class FabricEntityTypeTags {
			public static final TagKey<EntityType<?>> BOSSES = registerFabric("bosses");
			public static final TagKey<EntityType<?>> MINECARTS = registerFabric("minecarts");
			public static final TagKey<EntityType<?>> BOATS = registerFabric("boats");
			private static TagKey<EntityType<?>> registerFabric(String tagId) {
				return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("c", tagId));
			}
		}
		public static class FabricEnchantmentTags {
			public static final TagKey<Enchantment> INCREASES_BLOCK_DROPS = registerFabric("fortune");
			public static final TagKey<Enchantment> INCREASES_ENTITY_DROPS = registerFabric("looting");
			public static final TagKey<Enchantment> WEAPON_DAMAGE_ENHANCEMENT = registerFabric("weapon_damage_enhancement");
			public static final TagKey<Enchantment> ENTITY_MOVEMENT_ENHANCEMENT = registerFabric("entity_movement_enhancement");
			public static final TagKey<Enchantment> ENTITY_DEFENSE_ENHANCEMENT = registerFabric("entity_defense_enhancement");

			private static TagKey<Enchantment> registerFabric(String tagId) {
				return TagKey.create(Registries.ENCHANTMENT, new ResourceLocation("c", tagId));
			}
		}
	}
}
