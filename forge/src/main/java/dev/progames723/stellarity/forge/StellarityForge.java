package dev.progames723.stellarity.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.progames723.stellarity.CommonConventionalTags;
import dev.progames723.stellarity.Stellarity;
import dev.progames723.stellarity.forge.client.StellarityForgeClient;
import dev.progames723.stellarity.forge.server.StellarityForgeServer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ForgeEntityTypeTagsProvider;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegisterEvent;
import sun.misc.Unsafe;

import static dev.progames723.stellarity.Stellarity.*;

@Mod(MOD_ID)
public class StellarityForge {
	public static IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();//use later
	
    public StellarityForge() {
	    // Submit our event bus to let architectury register our content on the right time
	    EventBuses.registerModEventBus(MOD_ID, eventBus);
	    Stellarity.init();
	    if (Platform.getEnv().isClient()) new StellarityForgeClient(); else new StellarityForgeServer();
    }
}