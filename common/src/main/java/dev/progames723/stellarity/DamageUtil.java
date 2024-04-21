package dev.progames723.stellarity;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;

import java.util.concurrent.Callable;

public class DamageUtil {
	/**
	 * it uhh calculates additional damage stuff <p>
	 * really cool
	 * @param living a {@link LivingEntity}
	 * @param damage damage dealt
	 * @param percent damage efficiency
	 * @return additional damage
	 */
	public static float calculateDamageBoostEfficiency(LivingEntity living, float damage, float percent) {
		if (living.getMainHandItem().getItem() instanceof SwordItem swordItem){
			return (float) (damage*(living.getAttributes().getBaseValue(Attributes.ATTACK_DAMAGE)*(percent/100)));//TODO custom weapons implementation
		}
		return damage;
	}
	
	public static float calculateArmorPenetration(float damage, float apPercent, float drPercent) {//ap is armor penetration, dr is damage reduction
		float clampedAPPercent;
		float clampedDRPercent = 0;
		float funnyNumber = apPercent - drPercent;
		float clampedFunnyNumber = funnyNumber/100;
		//TODO finish
		if (apPercent > 0) {
			clampedAPPercent = apPercent/100;
		} else {
			return 0;
		}
		if (drPercent > 0){
			clampedDRPercent = drPercent/100;
		}
		if ((clampedDRPercent == clampedAPPercent) || (drPercent == apPercent)) {
			return 0;
		}
		if (clampedDRPercent > 0) {
		
		}
		return 0;//returns the amount of damage that should penetrate armor
	}
}
