package dev.progames723.stellarity;

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
import org.slf4j.Logger;

public class Registers {
	public static MobEffect registerEffect(String modid, String name, MobEffect obj, @Nullable Logger logger) {
		if (logger != null) {
			logger.info("Registered effect: " + name);
		}
		return Registry.register(BuiltInRegistries.MOB_EFFECT, new ResourceLocation(modid, name), obj);
	}

	public static Item registerItem(String modid, String name, Item obj, @Nullable Logger logger) {
		if (logger != null) {
			logger.info("Registered item: " + name);
		}
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(modid, name), obj);
	}

	public static Block registerBlock(String modid, String name, Block obj, @Nullable Logger logger){
		if (logger != null) {
			logger.info("Registered block: " + name);
		}
		return Registry.register(BuiltInRegistries.BLOCK, new ResourceLocation(modid, name), obj);
	}

	public static BlockItem registerBlockItem(String modid, String name, BlockItem obj, @Nullable Logger logger){
		if (logger != null) {
			logger.info("Registered block item: " + name);
		}
		return Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(modid, name), obj);
	}

	public static ResourceKey<DamageType> registerDamageType(String modid, String name, @Nullable Logger logger) {
		if (logger != null){
			logger.info("Registered damage type: " + name);
		}
		return registerDamageType(modid, name);
	}
	private static ResourceKey<DamageType> registerDamageType(String modid, String name) {
		ResourceKey<DamageType> damageType = ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(modid, name));
		if (damageType.registry() != null && damageType.location() != null && damageType != null){
			return damageType;
		} else {
			throw new IllegalStateException("Cannot register damage type: "+name);
		}
	}
}
