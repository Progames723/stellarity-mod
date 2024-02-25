package dev.progames723.stellarity.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.progames723.stellarity.StellarityItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Iterator;
import java.util.Objects;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"))
	private float test(float value) {
		assert Minecraft.getInstance().player != null;
		NonNullList<ItemStack> damn = Minecraft.getInstance().player.getInventory().items;
		ItemStack test = StellarityItems.frigidHarvester.getDefaultInstance();
		int max = damn.size()-1;
		int i = 0;
		while (i < max){
			if (damn.get(i).is(StellarityItems.frigidHarvester)){
				test = damn.get(i);
				break;
			}
			i++;
		}
		CompoundTag h = test.getTagElement("frigid_harvester");
		if (test.is(StellarityItems.frigidHarvester)){
			if (!Objects.isNull(h.getDouble("damage_boost"))) {
				return value + (float) h.getDouble("damage_boost");
			}
		}
		return value;
	}
}
