package dev.progames723.stellarity.damage_types;

import dev.progames723.stellarity.Registers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

import static dev.progames723.stellarity.StellaritySharedConstants.MOD_ID;

public class StellarityDamageTypes {
	//those are important
	public static final ResourceKey<DamageType> ARMOR_PIERCING = Registers.registerDamageType("kohara", "armor_piercing");
	public static final ResourceKey<DamageType> SIMULATED_EXPLOSION = Registers.registerDamageType("kohara", "simulated_explosion");
	//DOT damage types
	public static final ResourceKey<DamageType> FROSTBURN = Registers.registerDamageType(MOD_ID, "dot/frostburn");
	public static final ResourceKey<DamageType> PRISMATIC_INFERNO = Registers.registerDamageType(MOD_ID, "dot/prismatic_inferno");
	//EOL damage types
	public static final ResourceKey<DamageType> DASH = Registers.registerDamageType(MOD_ID, "empress_of_light");
	public static final ResourceKey<DamageType> PROJECTILE = Registers.registerDamageType(MOD_ID, "empress_of_light");
	//and everything else
	public static final ResourceKey<DamageType> CARCANET = Registers.registerDamageType(MOD_ID, "carcanet");
	public static final ResourceKey<DamageType> DRAGONBLADE = Registers.registerDamageType(MOD_ID, "dragonblade");
	public static final ResourceKey<DamageType> ELECTRIC = Registers.registerDamageType(MOD_ID, "electric");
	public static final ResourceKey<DamageType> EXAMPLE = Registers.registerDamageType(MOD_ID, "example");
	public static final ResourceKey<DamageType> KALEIDOSCOPE = Registers.registerDamageType(MOD_ID, "kaleidoscope");
	public static final ResourceKey<DamageType> NATURES_WRATH = Registers.registerDamageType(MOD_ID, "natures_wrath");
	public static final ResourceKey<DamageType> PRISMEMBER = Registers.registerDamageType(MOD_ID, "prismember");
}
