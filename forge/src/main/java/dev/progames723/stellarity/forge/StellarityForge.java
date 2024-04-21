package dev.progames723.stellarity.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.progames723.stellarity.CommonConventionalTags;
import dev.progames723.stellarity.Stellarity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ForgeEntityTypeTagsProvider;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import sun.misc.Unsafe;

import static dev.progames723.stellarity.Stellarity.*;

@Mod(MOD_ID)
public class StellarityForge {
    public StellarityForge() {
	    // Submit our event bus to let architectury register our content on the right time
	    EventBuses.registerModEventBus(MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
	    Stellarity.init();
    }
}