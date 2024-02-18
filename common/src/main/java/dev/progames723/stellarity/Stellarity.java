package dev.progames723.stellarity;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stellarity {
	public static final String MOD_ID = "stellarity";
	public static final Logger LOGGER = LoggerFactory.getLogger("Stellarity");
	public static StellarityDamageSources stellaritySources = new StellarityDamageSources();
	public static final Item test = new Item(new Item.Properties().rarity(Rarity.EPIC).defaultDurability(30));

	public static void init() {
		StellarityDamageSources.init();
		LOGGER.info("Working!");
		Registers.registerItem(MOD_ID, "test", test, LOGGER);
	}
}
