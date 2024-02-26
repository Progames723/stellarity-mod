package dev.progames723.stellarity.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.progames723.stellarity.StellarityItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Unique
	private List<ItemStack> getFrigidHarvesters(NonNullList<ItemStack> inventory) {
		List<ItemStack> frigidHarvesters = new ArrayList<>();
		int max = inventory.size();
		for (ItemStack itemStack : inventory) {
			if (itemStack.is(StellarityItems.frigidHarvester)) {
				frigidHarvesters.add(itemStack);
			}
		}
		return frigidHarvesters;
	}
	@Unique
	private List<CompoundTag> getFrigidHarvesterNbt(List<ItemStack> frigidHarvesters) {
		int max = frigidHarvesters.size();
		List<CompoundTag> frigidHarvestersNbt = new ArrayList<>();
		for (ItemStack frigidHarvester : frigidHarvesters) {
			if (!frigidHarvester.is(StellarityItems.frigidHarvester)) {
				throw new IllegalArgumentException("Wrong ItemStack!");
			} else {
				frigidHarvestersNbt.add(frigidHarvester.getOrCreateTagElement("frigid_harvester"));
			}
		}
		return frigidHarvestersNbt;
	}
	@Unique
	private List<Integer> itemStackReturned = new ArrayList<>();
	@Unique
	private boolean tempVariable = true;
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"))
	private float test(float value) {
		assert Minecraft.getInstance().player != null;
		NonNullList<ItemStack> damn = Minecraft.getInstance().player.getInventory().items;
		List<ItemStack> frigidHarvesters = getFrigidHarvesters(damn);
		List<CompoundTag> h1 = getFrigidHarvesterNbt(frigidHarvesters);
		int h1TrueSize = h1.size()-1;
//		ItemStack test = StellarityItems.frigidHarvester.getDefaultInstance();
//		CompoundTag h = test.getTagElement("frigid_harvester");
//		if (test.is(StellarityItems.frigidHarvester)){
//			if (!Objects.isNull(h.getDouble("damage_boost"))) {
//				return value + (float) h.getDouble("damage_boost");
//			}
//		}
		if (h1TrueSize >= 0){
			if (itemStackReturned.isEmpty() || itemStackReturned.size() < h1.size()) {
				for (int i = 0; i < h1.size(); i++) {
					itemStackReturned.add(i,i-1);
				}
				tempVariable = true;
			}
			if (tempVariable) {
				tempVariable = false;
			} else {
				itemStackReturned.remove(0);
			}
			return value + (float) h1.get((itemStackReturned.indexOf(0))).getDouble("damage_boost");
		}
		return value;
	}
}
