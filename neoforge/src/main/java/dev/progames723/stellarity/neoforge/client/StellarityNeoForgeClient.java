package dev.progames723.stellarity.neoforge.client;

import dev.progames723.stellarity.client.StellarityClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellarityNeoForgeClient {
	public StellarityNeoForgeClient() {
		StellarityClient.init();
	}
}
