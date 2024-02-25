package dev.progames723.stellarity.damage_types;

import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StellarityDamageSources {
	//those are important
	public static final ResourceKey<DamageType> ARMOR_PIERCING = Registers.registerDamageType("kohara", "armor_piercing", null);
	public static final ResourceKey<DamageType> SIMULATED_EXPLOSION = Registers.registerDamageType("kohara", "simulated_explosion", null);
	//DOT damage types
	public static final ResourceKey<DamageType> FROSTBURN = Registers.registerDamageType(Stellarity.MOD_ID, "dot/frostburn", null);
	public static final ResourceKey<DamageType> PRISMATIC_INFERNO = Registers.registerDamageType(Stellarity.MOD_ID, "dot/prismatic_inferno", null);
	//EOL damage types
	public static final ResourceKey<DamageType> DASH = Registers.registerDamageType(Stellarity.MOD_ID, "empress_of_light/dash", null);
	public static final ResourceKey<DamageType> PROJECTILE = Registers.registerDamageType(Stellarity.MOD_ID, "empress_of_light/projectile", null);
	//and everything else
	public static final ResourceKey<DamageType> CARCANET = Registers.registerDamageType(Stellarity.MOD_ID, "carcanet", null);
	public static final ResourceKey<DamageType> DRAGONBLADE = Registers.registerDamageType(Stellarity.MOD_ID, "dragonblade", null);
	public static final ResourceKey<DamageType> ELECTRIC = Registers.registerDamageType(Stellarity.MOD_ID, "electric", null);
	public static final ResourceKey<DamageType> EXAMPLE = Registers.registerDamageType(Stellarity.MOD_ID, "example", null);
	public static final ResourceKey<DamageType> KALEIDOSCOPE = Registers.registerDamageType(Stellarity.MOD_ID, "kaleidoscope", null);
	public static final ResourceKey<DamageType> NATURES_WRATH = Registers.registerDamageType(Stellarity.MOD_ID, "natures_wrath", null);
	public static final ResourceKey<DamageType> PRISMEMBER = Registers.registerDamageType(Stellarity.MOD_ID, "prismember", null);
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
	public static Registry<DamageType> damageType;
	public StellarityDamageSources(RegistryAccess registryAccess) {
		damageType = registryAccess.registryOrThrow(Registries.DAMAGE_TYPE);
	}
	public DamageSource source(ResourceKey<DamageType> key, @Nullable Entity attacker, @Nullable Entity directAttacker) {
		return of(key, attacker, directAttacker);
	}
	public static DamageSource of(ResourceKey<DamageType> key, @Nullable Entity attacker, @Nullable Entity directAttacker) {
		Optional<Holder.Reference<DamageType>> holder = damageType.getHolder(key);
		if (holder.isPresent()){
			return new DamageSource(holder.get(), attacker, directAttacker);
		} else {
			throw new IllegalStateException("Cannot create a new damage source because "+ key +" is null");
		}
	}
}
