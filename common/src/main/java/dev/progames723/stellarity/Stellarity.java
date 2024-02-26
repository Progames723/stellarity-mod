package dev.progames723.stellarity;

import dev.architectury.event.EventResult;
import dev.progames723.stellarity.effects.StellarityEffects;
import dev.progames723.stellarity.events.LivingEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

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
						UUID uuid = UUID.fromString("63c8d435-991a-4566-88d4-35991aa56679");
						StellarityItems.writeDataFrigidHarvester(the, attacker);
						the.addAttributeModifier(
								Attributes.ATTACK_DAMAGE,
								new AttributeModifier(uuid, "damage_modifier", 5.0, AttributeModifier.Operation.ADDITION),
								EquipmentSlot.MAINHAND
						);
					}
				}
			}
			return EventResult.pass();
		});
	}
}