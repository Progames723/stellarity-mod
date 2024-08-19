package dev.progames723.stellarity.fabric.client;

import dev.progames723.stellarity.client.StellarityClient;
import net.fabricmc.api.ClientModInitializer;

public class StellarityFabricClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		StellarityClient.init();
	}
}
