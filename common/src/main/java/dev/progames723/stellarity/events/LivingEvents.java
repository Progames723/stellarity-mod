package dev.progames723.stellarity.events;

import dev.architectury.event.Event;
import dev.architectury.event.EventFactory;
import dev.architectury.event.EventResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

public class LivingEvents {
	private static class Yes {
		public static double dValue = 0;
		public static float fValue = 0;
		public static boolean bValue = false;
	}
	/**
	 * Gets invoked after damage reduction is applied
	 * Try to not cancel because damaged armor will not be restored!
	 */
	public static Event<LivingDamaged> DAMAGED = EventFactory.createEventResult();
	
	public static Event<LivingHurt> HURT = CustomEventMaker.createEvent(Yes.fValue);
	
	@FunctionalInterface
	public interface LivingDamaged {
		EventResult damaged(LivingEntity entity, DamageSource source, float amount);
	}
	
	@FunctionalInterface
	public interface LivingHurt {
		float hurt(LivingEntity entity, DamageSource source, float amount);
	}
}