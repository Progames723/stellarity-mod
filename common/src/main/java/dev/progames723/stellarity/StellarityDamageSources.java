package dev.progames723.stellarity;

import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;

public class StellarityDamageSources extends DamageSources {
	//those are important
	public static ResourceKey<DamageType> ARMOR_PIERCING;
	public static ResourceKey<DamageType> SIMULATED_EXPLOSION;
	//DOT damage types
	public static ResourceKey<DamageType> FROSTBURN;
	public static ResourceKey<DamageType> PRISMATIC_INFERNO;
	//EOL damage types
	public static ResourceKey<DamageType> DASH;
	public static ResourceKey<DamageType> PROJECTILE;
	//and everything else
	public static ResourceKey<DamageType> CARCANET;
	public static ResourceKey<DamageType> DRAGONBLADE;
	public static ResourceKey<DamageType> ELECTRIC;
	public static ResourceKey<DamageType> EXAMPLE;
	public static ResourceKey<DamageType> KALEIDOSCOPE;
	public static ResourceKey<DamageType> NATURES_WRATH;
	public static ResourceKey<DamageType> PRISMEMBER;
	
	//damage sources are here
	public DamageSource armorPiercing(@Nullable Entity attacker){return source(ARMOR_PIERCING, attacker);}
	public DamageSource simulatedExplosion(@Nullable Entity attacker){return source(SIMULATED_EXPLOSION, attacker);}
	public DamageSource frostburn(){return source(FROSTBURN);}
	public DamageSource prismaticInferno(){return source(PRISMATIC_INFERNO);}
	public DamageSource dash(){return source(DASH);}
	public DamageSource projectile(){return source(PROJECTILE);}
	public DamageSource carcanet(@Nullable Entity attacker){return source(CARCANET, attacker);}
	public DamageSource dragonblade(@Nullable Entity attacker){return source(DRAGONBLADE, attacker);}
	public DamageSource electric(@Nullable Entity attacker){return source(ELECTRIC, attacker);}
	public DamageSource example(){return source(EXAMPLE);}
	public DamageSource kaleidoscope(@Nullable Entity attacker){return source(KALEIDOSCOPE, attacker);}
	public DamageSource naturesWrath(@Nullable Entity attacker){return source(NATURES_WRATH, attacker);}
	public DamageSource prismember(@Nullable Entity attacker){return source(PRISMEMBER, attacker);}
	public StellarityDamageSources() {
		super(RegistryAccess.EMPTY);
	}
	public static void init() {
		ARMOR_PIERCING = Registers.registerDamageType("kohara", "armor_piercing", Stellarity.LOGGER);
		SIMULATED_EXPLOSION = Registers.registerDamageType("kohara", "simulated_explosion", Stellarity.LOGGER);
		FROSTBURN = Registers.registerDamageType(Stellarity.MOD_ID, "frostburn", Stellarity.LOGGER);
		PRISMATIC_INFERNO = Registers.registerDamageType(Stellarity.MOD_ID, "prismatic_inferno", Stellarity.LOGGER);
		DASH = Registers.registerDamageType(Stellarity.MOD_ID, "dash", Stellarity.LOGGER);
		PROJECTILE = Registers.registerDamageType(Stellarity.MOD_ID, "projectile", Stellarity.LOGGER);
		CARCANET = Registers.registerDamageType(Stellarity.MOD_ID, "carcanet", Stellarity.LOGGER);
		DRAGONBLADE = Registers.registerDamageType(Stellarity.MOD_ID, "dragonblade", Stellarity.LOGGER);
		ELECTRIC = Registers.registerDamageType(Stellarity.MOD_ID, "electric", Stellarity.LOGGER);
		EXAMPLE = Registers.registerDamageType(Stellarity.MOD_ID, "example", Stellarity.LOGGER);
		KALEIDOSCOPE = Registers.registerDamageType(Stellarity.MOD_ID, "kaleidoscope", Stellarity.LOGGER);
		NATURES_WRATH = Registers.registerDamageType(Stellarity.MOD_ID, "natures_wrath", Stellarity.LOGGER);
		PRISMEMBER = Registers.registerDamageType(Stellarity.MOD_ID, "prismember", Stellarity.LOGGER);
	}
}
