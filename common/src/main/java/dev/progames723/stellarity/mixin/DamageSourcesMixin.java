package dev.progames723.stellarity.mixin;

import dev.progames723.stellarity.interface_injects.ExtDamageSources;
import dev.progames723.stellarity.damage_types.StellarityDamageSources;
import net.minecraft.core.RegistryAccess;
import net.minecraft.world.damagesource.DamageSources;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(DamageSources.class)
public abstract class DamageSourcesMixin implements ExtDamageSources {
	@Unique private StellarityDamageSources stellarity$stellaritySources;
	@Inject(method = "<init>",at = @At(value = "RETURN"))
	private void init(RegistryAccess registryAccess, CallbackInfo ci) {
		this.stellarity$stellaritySources = new StellarityDamageSources(registryAccess);
	}
	@Override
	public StellarityDamageSources stellaritySources(){
		return this.stellarity$stellaritySources;
	}
}
