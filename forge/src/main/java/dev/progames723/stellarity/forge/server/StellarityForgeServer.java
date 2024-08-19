package dev.progames723.stellarity.forge.server;

import dev.progames723.stellarity.server.StellarityServer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.DEDICATED_SERVER)
public class StellarityForgeServer {
	public StellarityForgeServer() {
		StellarityServer.init();
	}
}
