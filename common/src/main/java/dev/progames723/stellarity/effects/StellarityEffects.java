package dev.progames723.stellarity.effects;

import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class StellarityEffects {
	public static MobEffect PRISMATIC_INFERNO;
	public static MobEffect FROSTBURN;
	public static void init() {
		PRISMATIC_INFERNO = Registers.registerEffect(Stellarity.MOD_ID, "prismatic_inferno", new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201), Stellarity.LOGGER);
		FROSTBURN = Registers.registerEffect(Stellarity.MOD_ID, "frostburn", new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080), Stellarity.LOGGER);
	}
}
