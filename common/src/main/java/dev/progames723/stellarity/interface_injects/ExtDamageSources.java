package dev.progames723.stellarity.interface_injects;

import dev.progames723.stellarity.damage_types.StellarityDamageSources;

public interface ExtDamageSources {
	default StellarityDamageSources stellaritySources() {
		throw new IllegalStateException("Not transformed!");
	}
}
