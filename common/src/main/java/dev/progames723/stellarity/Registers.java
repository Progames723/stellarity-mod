package dev.progames723.stellarity;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.progames723.stellarity.effects.BaseEffect;
import dev.progames723.stellarity.effects.FrostburnEffect;
import dev.progames723.stellarity.effects.PrismaticInfernoEffect;
import dev.progames723.stellarity.items.FrigidHarvesterItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Supplier;

import static dev.progames723.stellarity.StellaritySharedConstants.MOD_ID;

public class Registers {//register stuff here
	public static final Supplier<RegistrarManager> MANAGER = () -> RegistrarManager.get(MOD_ID);
	public static final Registrar<Block> blocks = MANAGER.get().get(Registries.BLOCK);
	public static final Registrar<Item> items = MANAGER.get().get(Registries.ITEM);
	public static final Registrar<MobEffect> effects = MANAGER.get().get(Registries.MOB_EFFECT);
	public static final RegistrySupplier<Block> REGISTERED_TEST = blocks.register(
			new ResourceLocation(MOD_ID, "test"),
			() -> new Block(BlockBehaviour.Properties.of().instabreak())
	);
	public static final RegistrySupplier<FrigidHarvesterItem> REGISTERED_FRIGID_HARVESTER = items.register(
			new ResourceLocation(MOD_ID, "frigid_harvester"),
			() -> new FrigidHarvesterItem(Tiers.DIAMOND, 1, -3.15f,
					new FrigidHarvesterItem.Properties().rarity(Rarity.COMMON).defaultDurability(1561).fireResistant().arch$tab(CreativeModeTabs.COMBAT))
	);
	public static final RegistrySupplier<Item> REGISTERED_CAMERA_TEST = items.register(
			new ResourceLocation(MOD_ID, "camera_item"),
			() -> new Item(
					new Item.Properties().arch$tab(CreativeModeTabs.OP_BLOCKS).rarity(Rarity.EPIC).stacksTo(1))
	);
	public static final RegistrySupplier<MobEffect> REGISTERED_PRISMATIC_INFERNO = effects.register(
			new ResourceLocation(MOD_ID, "prismatic_inferno"),
			() -> new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201)
	);
	public static final RegistrySupplier<MobEffect> REGISTERED_FROSTBURN = effects.register(
			new ResourceLocation(MOD_ID, "frostburn"),
			() -> new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080)
	);
	public static final RegistrySupplier<MobEffect> REGISTERED_JINX = effects.register(
			new ResourceLocation(MOD_ID, "jinx"),
			() -> new BaseEffect(MobEffectCategory.HARMFUL, 12789215)
					.addAttributeModifier(Attributes.ARMOR, "A98D5187-D5AB-499A-8D51-87D5ABC99AB8", -0.25D, AttributeModifier.Operation.MULTIPLY_TOTAL)
					.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "7BE3768C-E490-4832-A376-8CE490D832D0", -0.25D, AttributeModifier.Operation.MULTIPLY_TOTAL)
					.addAttributeModifier(Attributes.LUCK, "8080CC20-0956-43E5-80CC-20095643E58F", -1D, AttributeModifier.Operation.ADDITION)
	);
	public static final RegistrySupplier<MobEffect> REGISTERED_VOIDED = effects.register(
			new ResourceLocation(MOD_ID, "voided"),
			() -> new BaseEffect(MobEffectCategory.HARMFUL, 12488921)
					.addAttributeModifier(Attributes.MAX_HEALTH, "C090F2D8-4744-4AED-90F2-D84744AAEDB0", -0.2D, AttributeModifier.Operation.MULTIPLY_TOTAL)
	);
	
	public static ResourceKey<DamageType> registerDamageType(String modid, String damageType) {
		return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(modid, damageType));
	}
	
	public static void init() {
		//does nothing but runs static initialization
	}
}
