package dev.progames723.stellarity.mixin;

import dev.architectury.event.EventResult;
import dev.progames723.stellarity.items.StellarityItems;
import dev.progames723.stellarity.events.LivingEvents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	public LivingEntityMixin(EntityType<?> entityType, Level level) {
		super(entityType, level);
	}
	@Inject(
			method = "actuallyHurt(Lnet/minecraft/world/damagesource/DamageSource;F)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/LivingEntity;setAbsorptionAmount(F)V"
			),
			cancellable = true
	)
	private void livingDamaged(DamageSource damageSource, float f, CallbackInfo ci) {
		LivingEntity entity = (LivingEntity) (Object) this;
		if (LivingEvents.DAMAGED.invoker().damaged(entity, damageSource, f) == EventResult.interrupt(null)){
			ci.cancel();
		} else if (LivingEvents.DAMAGED.invoker().damaged(entity, damageSource, f) == EventResult.interrupt(false)){
			ci.cancel();
		}
	}
	@ModifyVariable(
			method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z",
			at = @At(value = "HEAD"),
			argsOnly = true
	)
	private float damageBoost(float amount, DamageSource source) {
		if (source.getEntity() != null && !source.isIndirect()){
			LivingEntity entity = (LivingEntity) (Object) this;
			Entity attacker = source.getEntity();
			if (attacker instanceof Player player) {
				ItemStack test = player.getMainHandItem();
				if (test.is(StellarityItems.FRIGID_HARVESTER)){
					CompoundTag h = test.getTagElement("frigid_harvester");
					if (!Objects.isNull(h.getDouble("damage_boost"))) {
						return amount + (float) h.getDouble("damage_boost");
					}
				}
			}
		}
		return amount;
	}
}