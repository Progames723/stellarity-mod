package dev.progames723.stellarity;

import com.google.common.base.Suppliers;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.architectury.registry.registries.options.RegistrarOption;
import dev.architectury.registry.registries.options.StandardRegistrarOption;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.windows.Kernel32;
import org.slf4j.Logger;

import java.util.function.Supplier;

import static dev.progames723.stellarity.Stellarity.MOD_ID;

public class Registers {
	private static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
	private static final Registrar<MobEffect> effects = MANAGER.get().get(Registries.MOB_EFFECT);
	private static final Registrar<Item> items = MANAGER.get().get(Registries.ITEM);
	private static final Registrar<Block> blocks = MANAGER.get().get(Registries.BLOCK);
	//please ONLY USE THEM IN INIT METHODS
	public static MobEffect registerEffect(String modid, String name, MobEffect obj, @Nullable Logger logger) {
		if (logger != null) {
			logger.info("Registered effect: " + name);
		}
		return Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(modid, name), obj);
	}
	public static <T extends MobEffect> RegistrySupplier<T> registerEffect2(String modid, String name, T obj, @Nullable Logger logger) {
		RegistrySupplier<T> exampleEffect = effects.register(new ResourceLocation(modid, name), () -> obj);
		if (logger != null && exampleEffect.getRegistrar().containsValue(obj)) {
			logger.info("Registered effect: " + name);
		} else if (logger != null) {
			logger.info("Failed to register effect: " + name);
		}
		return exampleEffect;
	}

	public static Item registerItem(String modid, String name, Item obj, @Nullable Logger logger) {
		if (logger != null) {
			logger.info("Registered item: " + name);
		}
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(modid, name), obj);
	}
	public static <T extends Item> RegistrySupplier<T> registerItem2(String modid, String name, T obj, @Nullable Logger logger) {
		RegistrySupplier<T> exampleItem = items.register(new ResourceLocation(modid, name), () -> obj);
		if (logger != null && exampleItem.getRegistrar().containsValue(obj)) {
			logger.info("Registered item: " + name);
		} else if (logger != null) {
			logger.info("Failed to register item: " + name);
		}
		return exampleItem;
	}

	public static Block registerBlock(String modid, String name, Block obj, @Nullable Logger logger){
		if (logger != null) {
			logger.info("Registered block: " + name);
		}
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(modid, name), obj);
	}
	public static <T extends Block> RegistrySupplier<T> registerBlock2(String modid, String name, T obj, @Nullable Logger logger){
		RegistrySupplier<T> exampleBlock = blocks.register(new ResourceLocation(modid, name), () -> obj);
		if (logger != null && exampleBlock.getRegistrar().containsValue(obj)) {
			logger.info("Registered block: " + name);
		} else if (logger != null) {
			logger.info("Failed to register block: " + name);
		}
		return exampleBlock;
	}

	public static ResourceKey<DamageType> registerDamageType(String modid, String name, @Nullable Logger logger) {
		if (logger != null){
			logger.info("Registered damage type: " + name);
		}
		return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(modid, name));
	}
}
