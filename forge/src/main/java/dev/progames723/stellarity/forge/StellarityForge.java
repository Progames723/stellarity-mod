package dev.progames723.stellarity.forge;

import dev.architectury.platform.forge.EventBuses;
import dev.progames723.stellarity.Stellarity;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeItemTagsProvider;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.function.Consumer;

@Mod(Stellarity.MOD_ID)
public class StellarityForge {
    public StellarityForge() {
	    // Submit our event bus to let architectury register our content on the right time
		EventBuses.registerModEventBus(Stellarity.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
		Stellarity.init();
    }
}