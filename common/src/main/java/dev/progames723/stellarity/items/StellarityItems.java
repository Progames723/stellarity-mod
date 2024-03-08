package dev.progames723.stellarity.items;

import dev.architectury.hooks.item.ItemStackHooks;
import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;

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
			return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(Stellarity.MOD_ID, string));
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
			return entity.saveWithoutId(new CompoundTag()).contains("stellarity.boss") ||
					entity.saveWithoutId(new CompoundTag()).contains("fe.boss");
		}
	}
	public static final FrigidHarvesterItem frigidHarvester = new FrigidHarvesterItem(Tiers.DIAMOND, 1, -3.15f,new FrigidHarvesterItem.Properties().rarity(Rarity.COMMON).defaultDurability(1561).fireResistant().arch$tab(CreativeModeTabs.COMBAT));
	public static void init() {
		Registers.registerItem(Stellarity.MOD_ID, "frigid_harvester", frigidHarvester, Stellarity.LOGGER);
	}
	public static void checkFrigidHarvester(ItemStack frigidHarvester) {
		SwordItem item = ((SwordItem) frigidHarvester.getItem());
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
			case NONE -> Stellarity.LOGGER.debug("this did nothing!");
			default -> throw new IllegalArgumentException("Invalid Enum!");
		}
	}
}
