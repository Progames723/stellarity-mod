package dev.progames723.stellarity;

import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.progames723.stellarity.effects.StellarityEffects;
import dev.progames723.stellarity.events.LivingEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Stellarity {
	public static final String MOD_ID = "stellarity";
	public static final Logger LOGGER = LoggerFactory.getLogger("Stellarity");
	public static Block test;
	public static void init() {
		LOGGER.info("Working!");
		StellarityItems.init();
		StellarityEffects.init();
		test = Registers.registerBlock(MOD_ID, "test", new Block(BlockBehaviour.Properties.of().instabreak()), LOGGER);
		LivingEvents.DAMAGED.register((entity, source, amount) -> {
			if (!source.isIndirect() && source.getDirectEntity() instanceof Player attacker) {
				ItemStack the = attacker.getMainHandItem();
				if (the.is(StellarityItems.frigidHarvester)){
					if (entity.getHealth() <= amount){
						StellarityItems.writeDataFrigidHarvester(the, attacker);
						
					}
				}
			}
			return EventResult.pass();
		});
	}
}