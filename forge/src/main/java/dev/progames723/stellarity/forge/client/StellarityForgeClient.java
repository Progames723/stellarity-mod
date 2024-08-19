package dev.progames723.stellarity.forge.client;

import dev.progames723.stellarity.client.StellarityClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StellarityForgeClient {
	public StellarityForgeClient() {
		StellarityClient.init();
	}
}
