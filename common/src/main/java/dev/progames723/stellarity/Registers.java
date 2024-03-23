package dev.progames723.stellarity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public class Registers {
	public static ResourceKey<DamageType> registerDamageType(String modid, String name, @Nullable Logger logger) {
		if (logger != null){
			logger.info("Registered damage type: " + name);
		}
		return ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation(modid, name));
	}
}
