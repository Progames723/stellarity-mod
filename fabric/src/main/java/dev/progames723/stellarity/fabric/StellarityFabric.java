package dev.progames723.stellarity.fabric;

import dev.progames723.stellarity.Stellarity;
import net.fabricmc.api.ModInitializer;

public class StellarityFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Stellarity.init();
    }
}