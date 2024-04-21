package dev.progames723.stellarity.effects;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class StellarityEffects {
	public static final MobEffect PRISMATIC_INFERNO = new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201);
	public static final MobEffect FROSTBURN = new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080);
	public static final MobEffect JINX = new BaseEffect(MobEffectCategory.HARMFUL, 12789215)
			.addAttributeModifier(Attributes.ARMOR, "jinx_armor_reduction", -0.25D, AttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "jinx_armor_toughness_reduction", -0.25D, AttributeModifier.Operation.MULTIPLY_TOTAL)
			.addAttributeModifier(Attributes.LUCK, "jinx_luck_reduction", -1D, AttributeModifier.Operation.ADDITION);
	public static final MobEffect VOIDED = new BaseEffect(MobEffectCategory.HARMFUL, 12488921)
			.addAttributeModifier(Attributes.MAX_HEALTH, "voided_health_reduction", -0.2D, AttributeModifier.Operation.MULTIPLY_TOTAL);
}
