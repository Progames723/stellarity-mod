package dev.progames723.stellarity.fabric;

import dev.progames723.stellarity.Stellarity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;

public class StellarityFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Stellarity.init();
    }
}