package dev.progames723.stellarity.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.progames723.stellarity.StellarityItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"))
	private float test(float value) {
		ItemStack frigidHarvester = (ItemStack) (Object) this;
		if (frigidHarvester.is(StellarityItems.frigidHarvester)){
			return value + (float) frigidHarvester.getOrCreateTagElement("frigid_harvester").getDouble("damage_boost");
		} else {
			return value;
		}
	}
}
