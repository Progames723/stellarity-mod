package dev.progames723.stellarity.mixin.client;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.progames723.stellarity.Stellarity;
import dev.progames723.stellarity.items.StellarityItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentUtils;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.armortrim.ArmorTrim;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import static net.minecraft.world.item.ItemStack.*;

@Environment(EnvType.CLIENT)
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
	@Unique
	private static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	@Unique
	private static final UUID BASE_ATTACK_SPEED_UUID = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
	@Final @Shadow public static final DecimalFormat ATTRIBUTE_MODIFIER_FORMAT = Util.make(new DecimalFormat("#.##"), decimalFormat -> decimalFormat.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ROOT)));
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"))
	private float test(float value) {
		ItemStack the = (ItemStack) (Object) this;
		if (the.is(StellarityItems.FRIGID_HARVESTER)){
			return value + (float) the.getOrCreateTagElement("frigid_harvester").getDouble("damage_boost");
		}
		return value;
	}
	@Shadow private CompoundTag tag;
	@Shadow private static boolean shouldShowInTooltip(int i, TooltipPart tooltipPart) {
		return (i & tooltipPart.getMask()) == 0;
	}
	@ModifyReturnValue(method = "getTooltipLines", at = @At(value = "RETURN"))
	private List<Component> getTooltipLines(List<Component> original) {
		ItemStack the = (ItemStack) (Object) this;
		int i = the.getOrCreateTag().getInt("HideFlags");
		List<Component> notOriginal = Lists.newArrayList();
		if (the.is(StellarityItems.FRIGID_HARVESTER)) {
			int additional = 0;
			if (Minecraft.getInstance().options.advancedItemTooltips && !the.hasCustomHoverName() && (the.is(Items.FILLED_MAP) && (MapItem.getMapId(the) != null))) {
				additional++;
			}
			if (the.hasTag()) {
				if (this.tag.contains(TAG_DISPLAY, 10)) {
					CompoundTag compoundTag = this.tag.getCompound(TAG_DISPLAY);
					if (shouldShowInTooltip(i, ItemStack.TooltipPart.DYE) && compoundTag.contains(TAG_COLOR, 99)) {
						additional++;
					}
					if (compoundTag.getTagType(TAG_LORE) == 9) {
						ListTag listTag = compoundTag.getList(TAG_LORE, 8);
						additional += listTag.size()-1;
					}
				}
			}
			if (shouldShowInTooltip(i, TooltipPart.MODIFIERS)) {
				for (EquipmentSlot equipmentSlot : EquipmentSlot.values()) {
					Multimap<Attribute, AttributeModifier> multimap = the.getAttributeModifiers(equipmentSlot);
					if (multimap.isEmpty()) continue;
					additional+= 2D;
					for (Map.Entry<Attribute, AttributeModifier> entry : multimap.entries()) {
						AttributeModifier attributeModifier = entry.getValue();
						double d = attributeModifier.getAmount();
						boolean bl = false;
						if (attributeModifier.getId() == BASE_ATTACK_DAMAGE_UUID) {
							d += EnchantmentHelper.getDamageBonus(the, MobType.UNDEFINED);
							bl = true;
						} else if (attributeModifier.getId() == BASE_ATTACK_SPEED_UUID) {
							bl = true;
						}
						double e = attributeModifier.getOperation() == AttributeModifier.Operation.MULTIPLY_BASE || attributeModifier.getOperation() == AttributeModifier.Operation.MULTIPLY_TOTAL ? d * 100.0 : (entry.getKey().equals(Attributes.KNOCKBACK_RESISTANCE) ? d * 10.0 : d);
						if (bl) {
							additional++;
						}
						if (d > 0.0) {
							additional++;
							continue;
						}
						if (!(d < 0.0)) continue;
						additional++;
					}
				}
			}
			if (!the.getEnchantmentTags().isEmpty()){
				additional += the.getEnchantmentTags().size();
			}
			additional+=6;
			Component a = CommonComponents.space().append(Component.translatable("attribute.modifier.take.1", ATTRIBUTE_MODIFIER_FORMAT.format(15.0), Component.translatable(Attributes.MOVEMENT_SPEED.getDescriptionId()))).withStyle(ChatFormatting.DARK_GREEN);
			List<Component> sublist1 = original.subList(0, Math.max(Math.min(additional+5, original.size()-1), 0));
			List<Component> sublist2 = original.subList(Math.min(additional+5, original.size()-1), original.size()-1);
			notOriginal.addAll(sublist1);
			notOriginal.add(a);
			notOriginal.addAll(sublist2);
			return notOriginal;
		}
		return original;
	}
}
