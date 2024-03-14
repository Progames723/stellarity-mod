package dev.progames723.stellarity.effects;

import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class StellarityEffects {
	public static final MobEffect PRISMATIC_INFERNO = new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201);
	public static final MobEffect FROSTBURN = new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080);
	public static void init() {
		Registers.registerEffect2(Stellarity.MOD_ID, "prismatic_inferno", PRISMATIC_INFERNO, Stellarity.LOGGER);
		Registers.registerEffect2(Stellarity.MOD_ID, "frostburn", FROSTBURN, Stellarity.LOGGER);
	}
}
