package dev.progames723.stellarity.items;

import dev.progames723.stellarity.Stellarity;
import dev.progames723.stellarity.StellaritySharedConstants;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import static dev.progames723.stellarity.StellaritySharedConstants.*;

public class StellarityItems {
	public enum DamageBoost {
		NONE,
		MINOR,
		SMALL,
		BIG,
		LARGE,
		HUGE,
		BOSS;
		
		private static TagKey<EntityType<?>> create(String string) {
			return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(MOD_ID, string));
		}
		
		public static DamageBoost whatBoostPower(Entity entity){
			if (isMinor(entity)){
				return MINOR;
			} else if (isSmall(entity)){
				return SMALL;
			} else if (isBig(entity)){
				return BIG;
			} else if (isLarge(entity)){
				return LARGE;
			} else if (isHuge(entity)){
				return HUGE;
			} else if (isBoss(entity)){
				return BOSS;
			} else {
				return NONE;
			}
		}
		
		private static final TagKey<EntityType<?>> minor = create("frigid_harvester/gives_minor_boost");
		private static final TagKey<EntityType<?>> small = create("frigid_harvester/gives_small_boost");
		private static final TagKey<EntityType<?>> big = create("frigid_harvester/gives_big_boost");
		private static final TagKey<EntityType<?>> large = create("frigid_harvester/gives_large_boost");
		private static final TagKey<EntityType<?>> huge = create("frigid_harvester/gives_huge_boost");
		
		public static boolean isMinor(Entity entity) {
			return entity.getType().is(minor);
		}
		
		public static boolean isSmall(Entity entity) {
			return entity.getType().is(small);
		}
		
		public static boolean isBig(Entity entity) {
			return entity.getType().is(big);
		}
		
		public static boolean isLarge(Entity entity) {
			return entity.getType().is(large);
		}
		
		public static boolean isHuge(Entity entity) {
			return entity.getType().is(huge);
		}
		
		public static boolean isBoss(Entity entity) {
			return entity.saveWithoutId(new CompoundTag()).contains("stellarity.boss") || entity.saveWithoutId(new CompoundTag()).contains("fe.boss");
		}
	}
	public static FrigidHarvesterItem FRIGID_HARVESTER;//this too
	public static Item CAMERA_TEST;//will get replaced after registration finishes
	
	public static void checkFrigidHarvester(ItemStack itemStack) {
		FrigidHarvesterItem item = (FrigidHarvesterItem) itemStack.getItem();
	}
	
	public static void writeDataFrigidHarvester(ItemStack frigidHarvester, Entity entity){
		double grindAmplifier;
		DamageBoost damageBoost = DamageBoost.whatBoostPower(entity);
		CompoundTag itemNbt = frigidHarvester.getOrCreateTagElement("frigid_harvester");
		switch (damageBoost){
			case MINOR -> {
				itemNbt.putDouble("damage_boost", itemNbt.getDouble("damage_boost")+0.1);
				
			}
			case SMALL -> {
				itemNbt.putDouble("damage_boost", itemNbt.getDouble("damage_boost")+0.2);
				
			}
			case BIG -> {
				itemNbt.putDouble("damage_boost", itemNbt.getDouble("damage_boost")+0.4);
				
			}
			case LARGE -> {
				itemNbt.putDouble("damage_boost", itemNbt.getDouble("damage_boost")+0.8);
				
			}
			case HUGE -> {
				itemNbt.putDouble("damage_boost", itemNbt.getDouble("damage_boost")+1.6);
				
			}
			case BOSS -> {
				itemNbt.putDouble("damage_boost", itemNbt.getDouble("damage_boost")+3.2);
				
			}
			case NONE -> LOGGER.debug("this did nothing!");
			default -> throw new IllegalArgumentException("Invalid Enum!");
		}
	}
}
