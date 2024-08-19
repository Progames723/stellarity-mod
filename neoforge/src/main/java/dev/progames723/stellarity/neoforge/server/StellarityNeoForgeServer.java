package dev.progames723.stellarity.neoforge.server;

import dev.progames723.stellarity.server.StellarityServer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.DEDICATED_SERVER)
public class StellarityNeoForgeServer {
	public StellarityNeoForgeServer() {
		StellarityServer.init();
	}
}
