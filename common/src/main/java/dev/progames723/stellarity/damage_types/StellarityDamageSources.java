package dev.progames723.stellarity.damage_types;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static dev.progames723.stellarity.damage_types.StellarityDamageTypes.*;

public class StellarityDamageSources {
	public static Registry<DamageType> damageType;
	//damage sources are here
	public final DamageSource armorPiercing(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(ARMOR_PIERCING, attacker, directAttacker);
	}
	public final DamageSource armorPiercing(@Nullable Entity attacker){
		return source(ARMOR_PIERCING, attacker, null);
	}
	public final DamageSource simulatedExplosion(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(SIMULATED_EXPLOSION, attacker, directAttacker);
	}
	public final DamageSource simulatedExplosion(@Nullable Entity attacker){
		return source(SIMULATED_EXPLOSION, attacker, null);
	}
	public final DamageSource frostburn(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(FROSTBURN, attacker, directAttacker);
	}
	public final DamageSource frostburn(@Nullable Entity attacker){
		return source(FROSTBURN, attacker, null);
	}
	public final DamageSource frostburn(){
		return source(FROSTBURN, null, null);
	}
	public final DamageSource prismaticInferno(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(PRISMATIC_INFERNO, attacker, directAttacker);
	}
	public final DamageSource prismaticInferno(@Nullable Entity attacker){
		return source(PRISMATIC_INFERNO, attacker, null);
	}
	public final DamageSource prismaticInferno(){
		return source(PRISMATIC_INFERNO, null, null);
	}
	public final DamageSource dash(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(DASH, attacker, directAttacker);
	}
	public final DamageSource dash(@Nullable Entity attacker){
		return source(DASH, attacker, null);
	}
	public final DamageSource projectile(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(PROJECTILE, attacker, directAttacker);
	}
	public final DamageSource projectile(@Nullable Entity attacker){
		return source(PROJECTILE, attacker, null);
	}
	public final DamageSource carcanet(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(CARCANET, attacker, directAttacker);
	}
	public final DamageSource carcanet(@Nullable Entity attacker){
		return source(CARCANET, attacker, null);
	}
	public final DamageSource dragonblade(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(DRAGONBLADE, attacker, directAttacker);
	}
	public final DamageSource dragonblade(@Nullable Entity attacker){
		return source(DRAGONBLADE, attacker, null);
	}
	public final DamageSource electric(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(ELECTRIC, attacker, directAttacker);
	}
	public final DamageSource electric(@Nullable Entity attacker){
		return source(ELECTRIC, attacker, null);
	}
	public final DamageSource example(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(EXAMPLE, attacker, directAttacker);
	}
	public final DamageSource example(@Nullable Entity attacker){
		return source(EXAMPLE, attacker, null);
	}
	public final DamageSource example(){
		return source(EXAMPLE, null, null);
	}
	public final DamageSource kaleidoscope(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(KALEIDOSCOPE, attacker, directAttacker);
	}
	public final DamageSource kaleidoscope(@Nullable Entity attacker){
		return source(KALEIDOSCOPE, attacker, null);
	}
	public final DamageSource naturesWrath(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(NATURES_WRATH, attacker, directAttacker);
	}
	public final DamageSource naturesWrath(@Nullable Entity attacker){
		return source(NATURES_WRATH, attacker, null);
	}
	public final DamageSource prismember(@Nullable Entity attacker, @Nullable Entity directAttacker){
		return source(PRISMEMBER, attacker, directAttacker);
	}
	public final DamageSource prismember(@Nullable Entity attacker){
		return source(PRISMEMBER, attacker, null);
	}
	public StellarityDamageSources(RegistryAccess registryAccess) {
		if (registryAccess == RegistryAccess.EMPTY){
			throw new IllegalArgumentException("RegistryAccess must not be EMPTY!");
		}
		damageType = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE);
	}
	public DamageSource source(ResourceKey<DamageType> key, @Nullable Entity attacker, @Nullable Entity directAttacker) {
		return of(key, attacker, directAttacker);
	}
	public static DamageSource of(@NotNull ResourceKey<DamageType> key, @Nullable Entity attacker, @Nullable Entity directAttacker) {
		Optional<Holder.Reference<DamageType>> holder = damageType.getHolder(key);
		if (holder.isPresent()){
			return new DamageSource(holder.get(), attacker, directAttacker);
		} else {
			throw new IllegalStateException("Cannot create a new damage source because " + key + " or " + holder + " is null");
		}
	}
}
