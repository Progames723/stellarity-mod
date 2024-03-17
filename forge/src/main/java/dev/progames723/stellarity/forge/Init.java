package dev.progames723.stellarity.forge;

import dev.progames723.stellarity.effects.FrostburnEffect;
import dev.progames723.stellarity.effects.PrismaticInfernoEffect;
import dev.progames723.stellarity.items.FrigidHarvesterItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static dev.progames723.stellarity.Stellarity.MOD_ID;

public class Init {
	public static void initializeEverything(IEventBus bus) {
		Blocks.init(bus);
		Items.init(bus);
		Effects.init(bus);
	}
	public static class Blocks {
		private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
		private static final RegistryObject<Block> TEST = BLOCKS.register("test", () -> new Block(BlockBehaviour.Properties.of().instabreak()));
		private static boolean initialized = false;
		public static void init(IEventBus bus) {
			if (initialized){
				throw new IllegalStateException("Already registered!");
			}
			if (!BLOCKS.getEntries().contains(TEST)){
				throw new IllegalStateException("Not registered!");
			}
			BLOCKS.register(bus);
			initialized = true;
		}
	}
	public static class Items {
		private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
		private static final RegistryObject<Item> CAMERA_TEST = ITEMS.register("camera_test", () -> new Item(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1)));
		private static final RegistryObject<Item> FRIGID_HARVESTER = ITEMS.register("frigid_harvester", () -> new FrigidHarvesterItem(Tiers.DIAMOND, 1, -3.15f,new FrigidHarvesterItem.Properties().rarity(Rarity.COMMON).defaultDurability(1561).fireResistant()));
		private static boolean initialized = false;
		public static void init(IEventBus bus) {
			if (initialized){
				throw new IllegalStateException("Already registered!");
			}
			if (!ITEMS.getEntries().contains(CAMERA_TEST) || !ITEMS.getEntries().contains(FRIGID_HARVESTER)){
				throw new IllegalStateException("Not registered!");
			}
			ITEMS.register(bus);
			initialized = true;
		}
	}
	public static class Effects {
		private static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, MOD_ID);
		private static final RegistryObject<MobEffect> PRISMATIC_INFERNO = EFFECTS.register("prismatic_inferno", () -> new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201));
		private static final RegistryObject<MobEffect> FROSTBURN = EFFECTS.register("frostburn", () -> new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080));
		private static boolean initialized = false;
		public static void init(IEventBus bus) {
			if (initialized){
				throw new IllegalStateException("Already registered!");
			}
			if (!EFFECTS.getEntries().contains(PRISMATIC_INFERNO) || !EFFECTS.getEntries().contains(FROSTBURN)){
				throw new IllegalStateException("Not registered!");
			}
			EFFECTS.register(bus);
			initialized = true;
		}
	}
}
