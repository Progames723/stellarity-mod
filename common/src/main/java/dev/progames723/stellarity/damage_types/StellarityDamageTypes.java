package dev.progames723.stellarity.damage_types;

import dev.progames723.stellarity.Registers;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;

public class StellarityDamageTypes {
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
}
