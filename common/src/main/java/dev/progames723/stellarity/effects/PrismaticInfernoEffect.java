package dev.progames723.stellarity.effects;

import dev.progames723.stellarity.damage_types.StellarityDamageSources;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class PrismaticInfernoEffect extends MobEffect {
	public PrismaticInfernoEffect(MobEffectCategory mobEffectCategory, int i) {
		super(mobEffectCategory, i);
	}
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int i) {
		i += 1;
		super.applyEffectTick(livingEntity, i);
		StellarityDamageSources sources = livingEntity.level().damageSources().stellaritySources();
		livingEntity.hurt(sources.prismaticInferno(), i);
	}
	@Override
	public boolean shouldApplyEffectTickThisTick(int i, int j) {
		return i % 20 == 0;
	}
}
