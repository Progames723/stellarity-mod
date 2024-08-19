package dev.progames723.stellarity.neoforge;

import dev.architectury.platform.Platform;
import dev.progames723.stellarity.Stellarity;
import dev.progames723.stellarity.neoforge.client.StellarityNeoForgeClient;
import dev.progames723.stellarity.neoforge.server.StellarityNeoForgeServer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

import static dev.progames723.stellarity.Stellarity.*;

@Mod(MOD_ID)
public class StellarityNeoForge {
	public static IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();//use later
	
    public StellarityNeoForge() {
	    Stellarity.init();
	    if (Platform.getEnv().isClient()) new StellarityNeoForgeClient(); else new StellarityNeoForgeServer();
    }
}