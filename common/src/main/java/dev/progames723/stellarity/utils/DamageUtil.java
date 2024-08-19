package dev.progames723.stellarity.utils;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;

public class DamageUtil {
	/**
	 * it uhh calculates additional damage stuff <p>
	 * really cool
	 * @param living a {@link LivingEntity}
	 * @param damage damage dealt
	 * @param percent damage efficiency
	 * @return additional {@code damage}
	 */
	public static float calculateDamageBoostEfficiency(LivingEntity living, float damage, float percent) {
		if (living.getMainHandItem().getItem() instanceof SwordItem swordItem){
			swordItem.getDamage();
			return (float) (damage*(living.getAttributes().getBaseValue(Attributes.ATTACK_DAMAGE)*(percent/100)));//TODO custom weapons implementation
		}
		return damage;
	}
	
	/**
	 * calculates that stuff
	 * @param damage damage dealt
	 * @param armorPenetrationPercent obvious
	 * @return amount of {@code damage} that should ignore armor
	 */
	public static float calculateArmorPenetration(float damage, float armorPenetrationPercent) {
		return damage * Mth.clamp(armorPenetrationPercent/100, 0, 1);
	}
}
