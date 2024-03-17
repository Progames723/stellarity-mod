package dev.progames723.stellarity.effects;

import dev.architectury.registry.registries.RegistrySupplier;
import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class StellarityEffects {
	public static final MobEffect PRISMATIC_INFERNO = new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201);
	public static final MobEffect FROSTBURN = new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080);
	public static final RegistrySupplier<MobEffect> REGISTERED_PRISMATIC_INFERNO = Registers.registerEffect2(Stellarity.MOD_ID, "frostburn", new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080), Stellarity.LOGGER);
	public static final RegistrySupplier<MobEffect> REGISTERED_FROSTBURN = Registers.registerEffect2(Stellarity.MOD_ID, "frostburn", new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080), Stellarity.LOGGER);
}
