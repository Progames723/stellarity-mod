package dev.progames723.stellarity.fabric.server;

import dev.progames723.stellarity.server.StellarityServer;
import net.fabricmc.api.DedicatedServerModInitializer;

public class StellarityFabricServer implements DedicatedServerModInitializer {
	@Override
	public void onInitializeServer() {
		StellarityServer.init();
	}
}
