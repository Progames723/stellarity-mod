package dev.progames723.stellarity.mixin.client;

import dev.progames723.stellarity.utils.ColorUtil;
import dev.progames723.stellarity.items.SpecialAbilityItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Environment(EnvType.CLIENT)
@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin {
	@Shadow public abstract void fillGradient(RenderType renderType, int i, int j, int k, int l, int m, int n, int o);
	
	@Shadow public abstract void fill(RenderType renderType, int i, int j, int k, int l, int m, int n);
	
	@Shadow public abstract void fill(RenderType renderType, int i, int j, int k, int l, int m);
	
	@Inject(
			method = "renderItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/world/item/ItemStack;isBarVisible()Z"
			)
	)
	private void secondDurablilityBarRender(Font font, ItemStack itemStack, int i, int j, @Nullable String string, CallbackInfo ci) {
		if (!(itemStack.getItem() instanceof SpecialAbilityItem item)) return;
		if (item.showCustomBar() && !item.shouldOverrideHiddenBar()) return;
		
		int k = item.getCustomBarWidth();
		int h = i + 2;//shift from left to right
		int o = j + 11;//shift from up to bottom
		fill(RenderType.guiOverlay(), h, o, h + 13, o + 2, -16777216);//shadow?
		if (item.getGradientColors1() == null)
			fill(RenderType.guiOverlay(), h, o, h + k, o + 1, 1, (int) ColorUtil.RGBToDecimalColor(item.getGradientColors2()));
		else if (item.getGradientColors2() == null)
			fill(RenderType.guiOverlay(), h, o, h + k, o + 1, 1, (int) ColorUtil.RGBToDecimalColor(item.getGradientColors1()));
		else if (item.getGradientColors1() == null && item.getGradientColors2() == null)
			fill(RenderType.guiOverlay(), h, o, h + k, o + 1, 1, (int) ColorUtil.RGBToDecimalColor(58, 194, 115));
		else
			fillGradient(RenderType.guiOverlay(), h, o, h + k, o + 1, 1, (int) ColorUtil.RGBToDecimalColor(item.getGradientColors1()), (int) ColorUtil.RGBToDecimalColor(item.getGradientColors2()));
		
	}
}
