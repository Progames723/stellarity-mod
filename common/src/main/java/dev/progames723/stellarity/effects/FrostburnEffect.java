package dev.progames723.stellarity.effects;

import dev.progames723.stellarity.damage_types.StellarityDamageSources;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FrostburnEffect extends BaseEffect {
	public FrostburnEffect(MobEffectCategory mobEffectCategory, int i) {
		super(mobEffectCategory, i);
	}
	@Override
	public void applyEffectTick(LivingEntity livingEntity, int i) {
		i++;//this is done because minecraft is dumb e.g. effect level 0 is 1 and etc
		super.applyEffectTick(livingEntity, i);
		StellarityDamageSources sources = livingEntity.damageSources().stellaritySources();
		if (livingEntity.getType().is(EntityTypeTags.FREEZE_HURTS_EXTRA_TYPES)) {
			i *= 2;
		}
		livingEntity.hurt(sources.frostburn(), i);
	}
	@Override
	public boolean shouldApplyEffectTickThisTick(int i, int j) {
		return i % 20 == 0;
	}
}
