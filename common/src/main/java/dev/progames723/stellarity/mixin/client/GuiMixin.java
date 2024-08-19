package dev.progames723.stellarity.mixin.client;

import dev.progames723.stellarity.effects.StellarityEffects;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Gui;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Environment(EnvType.CLIENT)
@Mixin(Gui.class)
@Debug(export = true)
public abstract class GuiMixin {
	@Shadow protected abstract Player getCameraPlayer();
	
	@Unique private static final ResourceLocation ARMOR_EMPTY_JINX = new ResourceLocation("stellarity", "gui/hud/armor_empty_jinx.png");

	@Unique private static final ResourceLocation ARMOR_HALF_JINX = new ResourceLocation("stellarity", "gui/hud/armor_half_jinx.png");

	@Unique private static final ResourceLocation ARMOR_FULL_JINX = new ResourceLocation("stellarity", "gui/hud/armor_full_jinx.png");

//	@Unique private static final ResourceLocation HEART_FULL_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/full_voided.png");

//	@Unique private static final ResourceLocation HEART_HALF_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/half_voided.png");

//	@Unique private static final ResourceLocation HEART_FULL_BLINKING_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/full_blinking_voided.png");

//	@Unique private static final ResourceLocation HEART_HALF_BLINKING_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/half_blinking_voided.png");

//	@Unique private static final ResourceLocation HARDCORE_HEART_FULL_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/hardcore_full_voided.png");

//	@Unique private static final ResourceLocation HARDCORE_HEART_HALF_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/hardcore_half_voided.png");

//	@Unique private static final ResourceLocation HARDCORE_HEART_FULL_BLINKING_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/hardcore_full_blinking_voided.png");

//	@Unique private static final ResourceLocation HARDCORE_HEART_HALF_BLINKING_VOIDED = new ResourceLocation("stellarity", "gui/hud/heart/hardcore_half_blinking_voided.png");
	
	@ModifyArg(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V", ordinal = 0), index = 0)
	private ResourceLocation modifyArmorRender1(ResourceLocation resourceLocation) {
		if (getCameraPlayer().hasEffect(StellarityEffects.JINX)) return ARMOR_FULL_JINX;
		return resourceLocation;
	}
	
	@ModifyArg(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V", ordinal = 1), index = 0)
	private ResourceLocation modifyArmorRender2(ResourceLocation resourceLocation) {
		if (getCameraPlayer().hasEffect(StellarityEffects.JINX)) return ARMOR_HALF_JINX;
		return resourceLocation;
	}
	
	@ModifyArg(method = "renderPlayerHealth", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V", ordinal = 2), index = 0)
	private ResourceLocation modifyArmorRender3(ResourceLocation resourceLocation) {
		if (getCameraPlayer().hasEffect(StellarityEffects.JINX)) return ARMOR_EMPTY_JINX;
		return resourceLocation;
	}
}
