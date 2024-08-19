package dev.progames723.stellarity.mixin.client;

import dev.progames723.stellarity.effects.StellarityEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Mixin(Gui.HeartType.class)
@Environment(EnvType.CLIENT)
@Debug(export = true)
public abstract class HeartTypeMixin {
	@Shadow
	@Final
	@Mutable
	private static Gui.HeartType[] $VALUES;
	
	private static final Gui.HeartType VOIDED = stellarity$addVariant("VOIDED", new ResourceLocation("stellarity", "gui/hud/heart/full_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/full_blinking_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/half_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/half_blinking_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/hardcore_full_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/hardcore_full_blinking_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/hardcore_half_voided.png"), new ResourceLocation("stellarity", "gui/hud/heart/hardcore_half_blinking_voided.png"));
	
	@Invoker("<init>")
	private static Gui.HeartType stellarity$invokeInit(String internalName, int internalId, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, ResourceLocation resourceLocation5, ResourceLocation resourceLocation6, ResourceLocation resourceLocation7, ResourceLocation resourceLocation8) {
		throw new AssertionError();
	}
	
	@Unique
	private static Gui.HeartType stellarity$addVariant(String internalName, ResourceLocation resourceLocation, ResourceLocation resourceLocation2, ResourceLocation resourceLocation3, ResourceLocation resourceLocation4, ResourceLocation resourceLocation5, ResourceLocation resourceLocation6, ResourceLocation resourceLocation7, ResourceLocation resourceLocation8) {
        assert $VALUES != null;
		ArrayList<Gui.HeartType> list = new ArrayList<>(List.of($VALUES));
        Gui.HeartType heartType = stellarity$invokeInit(internalName, $VALUES.length, resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4, resourceLocation5, resourceLocation6, resourceLocation7, resourceLocation8);
		list.add(heartType);
		$VALUES = list.toArray(new Gui.HeartType[]{});
		return heartType;
	}
	
	@Inject(method = "forPlayer", at = @At("HEAD"), cancellable = true)
	private static void injectForPlayer(Player player, CallbackInfoReturnable<Gui.HeartType> cir) {
		if (player.hasEffect(StellarityEffects.VOIDED)) {
			cir.setReturnValue(VOIDED);
		}
	}
}
