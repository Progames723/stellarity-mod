package dev.progames723.stellarity.mixin;

import dev.architectury.event.EventResult;
import dev.progames723.stellarity.Stellarity;
import dev.progames723.stellarity.items.StellarityItems;
import dev.progames723.stellarity.events.LivingEvents;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
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
	
	@Unique	private final LivingEntity stellarity$living = (LivingEntity) (Object) this;
	
	@Inject(
			method = "actuallyHurt(Lnet/minecraft/world/damagesource/DamageSource;F)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/entity/LivingEntity;setAbsorptionAmount(F)V"
			)
	)
	private void livingDamaged(DamageSource damageSource, float f, CallbackInfo ci) {
		LivingEvents.DAMAGED.invoker().damaged(stellarity$living, damageSource, f);
	}
	
	@ModifyVariable(method = "hurt", at = @At(value = "HEAD"), argsOnly = true)
	private float changeDamage(float damage, DamageSource source) {
		//add stuff later
		return damage;
	}
	
	@ModifyVariable(method = "hurt", at = @At(value = "HEAD"), argsOnly = true)
	private DamageSource changeDamageSource(DamageSource source) {
		//also add stuff later
		return source;
	}
	
	@ModifyVariable(
			method = "hurt(Lnet/minecraft/world/damagesource/DamageSource;F)Z",
			at = @At(value = "HEAD"),
			argsOnly = true
	)
	private float damageBoost(float amount, DamageSource source) {
		if (source.getEntity() != null && !source.isIndirect()){
			if (source.getEntity()instanceof Player player) {
				ItemStack test = player.getMainHandItem();
				if (test.is(StellarityItems.FRIGID_HARVESTER)){
					CompoundTag h = test.getOrCreateTagElement("frigid_harvester");
					return amount + (float) h.getDouble("damage_boost");
				}
			}
		}
		return amount;
	}
}