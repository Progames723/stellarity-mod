package dev.progames723.stellarity.mixin.client;

import com.google.common.collect.Multimap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.progames723.stellarity.OldCaching;
import dev.progames723.stellarity.items.StellarityItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;

import static net.minecraft.world.item.ItemStack.*;

@Debug(export = true)
@Environment(value = EnvType.CLIENT)
@Mixin(ItemStack.class)
public abstract class ItemStackMixin {//might remove later
	@Unique	private static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
	@Unique	private static final UUID BASE_ATTACK_SPEED_UUID = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
	@Unique @Final private final UUID SPEED_PENALTY_UUID = UUID.fromString("8F8EDC14-6974-4A06-8EDC-1469748A0665");
	
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/enchantment/EnchantmentHelper;getDamageBonus(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/entity/MobType;)F"))
	private float test(float value) {
		float damage_boost = (float) ((ItemStack) (Object) this).getOrCreateTagElement("frigid_harvester").getDouble("damage_boost");
		return value + damage_boost;
	}
	
	@Unique private final ItemStack stellarity$the = (ItemStack) (Object) this;
	@Unique private final OldCaching stellarity$cache = OldCaching.getInstance();
	@Unique @Final private final Component stellarity$a = stellarity$createComponent();
	
	@Unique private static Component stellarity$createComponent() {
		return CommonComponents.space().append(Component.translatable("attribute.modifier.take.1", new DecimalFormat("#.##", DecimalFormatSymbols.getInstance(Locale.ROOT)).format(15.0), Component.translatable(Attributes.MOVEMENT_SPEED.getDescriptionId()))).withStyle(ChatFormatting.DARK_GREEN);
	}
	
	@Shadow public abstract boolean is(Item item);
	
	@Shadow public abstract Item getItem();
	
//	@Inject(method = "getTooltipLines", at = @At(value = "RETURN"), cancellable = true)
//	private void appendTooltipLines(@Nullable Player player, TooltipFlag tooltipFlag, CallbackInfoReturnable<List<Component>> cir) {
//		List<Component> componentList = cir.getReturnValue();
//		int number = 0;
//		int i = getHideFlags();
//		if (stellarity$the.hasTag()) {
//			ListTag listTag2;
//			if (shouldShowInTooltip(i, TooltipPart.UNBREAKABLE) && this.tag.getBoolean(TAG_UNBREAKABLE)) {
//				number++;
//			}
//			if (shouldShowInTooltip(i, TooltipPart.CAN_DESTROY) && this.tag.contains(TAG_CAN_DESTROY_BLOCK_LIST, 9) && !(listTag2 = this.tag.getList(TAG_CAN_DESTROY_BLOCK_LIST, 8)).isEmpty()) {
//				number+=2;
//				for (int k = 0; k < listTag2.size(); ++k) {
//					number += expandBlockState(listTag2.getString(k)).size();
//				}
//			}
//			if (shouldShowInTooltip(i, TooltipPart.CAN_PLACE) && this.tag.contains(TAG_CAN_DESTROY_BLOCK_LIST, 9) && !(listTag2 = this.tag.getList(TAG_CAN_PLACE_ON_BLOCK_LIST, 8)).isEmpty()) {
//				number+=2;
//				for (int k = 0; k < listTag2.size(); ++k) {
//					number += expandBlockState(listTag2.getString(k)).size();
//				}
//			}
//		}
//		if (tooltipFlag.isAdvanced()) {
//			if (stellarity$the.isDamaged()) {
//				number++;
//			}
//			number++;
//			if (stellarity$the.hasTag()) {
//				number++;
//			}
//		}
//		if (player != null && !stellarity$the.getItem().isEnabled(player.level().enabledFeatures())) {
//			number++;
//		}
//		List<Component> sublist1 = componentList.subList(0, Math.max(Math.max(number-1, 0), componentList.size()-1));//foolproof 1
//		List<Component> sublist2 = componentList.subList(Math.max(Math.max(number, 0), componentList.size()-1), Math.max(0, componentList.size()-1));//foolproof 2
//		sublist1.add(stellarity$a);
//		sublist1.addAll(sublist2);
//		componentList.clear();
//		componentList.addAll(sublist1);
//
//		cir.setReturnValue(componentList);
//	}

	/**
	 * @author Progames723
	 * @reason yes
	 */
	@ModifyExpressionValue(method = "getTooltipLines", at = @At(value = "INVOKE", target = "Lnet/minecraft/network/chat/Component;translatable(Ljava/lang/String;[Ljava/lang/Object;)Lnet/minecraft/network/chat/MutableComponent;", ordinal = 3))
	public MutableComponent getTooltipLines(MutableComponent original) {
		if (stellarity$the.is(StellarityItems.FRIGID_HARVESTER)) return CommonComponents.space().append(original);
		return original;
	}
	
	/*
	@Deprecated
	@ModifyReturnValue(method = "getTooltipLines", at = @At(value = "RETURN"))
	private List<Component> getTooltipLines(List<Component> original) {
		int i = stellarity$the.getOrCreateTag().getInt("HideFlags");
		List<Component> notOriginal = Lists.newArrayList();
		List<Component> preCashedFinalList = Lists.newArrayList();
		int additional = 0;
		Random random = new Random();
		try {
			if (stellarity$the.is(StellarityItems.FRIGID_HARVESTER)) {
				if (!(original.size() + 1 == stellarity$cache.getFinalListCached().size()) ||
						!stellarity$cache.getFinalListCached().contains(original.get(random.nextInt(original.size())))){
					if (Minecraft.getInstance().options.advancedItemTooltips && !stellarity$the.hasCustomHoverName() && (stellarity$the.is(Items.FILLED_MAP) && (MapItem.getMapId(stellarity$the) != null))) {
						additional++;
					}
					if (stellarity$the.hasTag()) {
						if (this.tag.contains(TAG_DISPLAY, 10)) {
							CompoundTag compoundTag = this.tag.getCompound(TAG_DISPLAY);
							if (shouldShowInTooltip(i, TooltipPart.DYE) && compoundTag.contains(TAG_COLOR, 99)) {
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
							Multimap<Attribute, AttributeModifier> multimap = stellarity$the.getAttributeModifiers(equipmentSlot);
							if (multimap.isEmpty()) continue;
							additional+= 2;
							for (Map.Entry<Attribute, AttributeModifier> entry : multimap.entries()) {
								AttributeModifier attributeModifier = entry.getValue();
								double d = attributeModifier.getAmount();
								boolean bl = false;
								if (attributeModifier.getId() == BASE_ATTACK_DAMAGE_UUID) {
									d += EnchantmentHelper.getDamageBonus(stellarity$the, MobType.UNDEFINED);
									bl = true;
								} else if (attributeModifier.getId() == BASE_ATTACK_SPEED_UUID) {
									bl = true;
								}
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
					if (!stellarity$the.getEnchantmentTags().isEmpty()){
						additional += stellarity$the.getEnchantmentTags().size();
					}
					additional+=6;
					stellarity$cache.setTooltipLinesCached(additional);
					List<Component> sublist1 = original.subList(0, Math.max(Math.min(additional+5, original.size()-1), 0));
					List<Component> sublist2 = original.subList(Math.min(additional+5, original.size()-1), original.size()-1);
					notOriginal.addAll(sublist1);
					notOriginal.add(stellarity$a);
					notOriginal.addAll(sublist2);
					stellarity$cache.setFinalListCached(notOriginal);
				} else {
					List<Component> sublist1 = original.subList(0, Math.max(Math.min(stellarity$cache.getTooltipLinesCached()+5, original.size()-1), 0));
					List<Component> sublist2 = original.subList(Math.min(stellarity$cache.getTooltipLinesCached()+5, original.size()-1), original.size()-1);
					preCashedFinalList.addAll(sublist1);
					preCashedFinalList.add(stellarity$a);
					preCashedFinalList.addAll(sublist2);
					if (stellarity$cache.getFinalListCached() != preCashedFinalList) {
						stellarity$cache.setFinalListCached(preCashedFinalList);
					}
					return stellarity$cache.getFinalListCached();
				}
				return notOriginal;
			}
			return original;
		} catch (Exception e){
			e.printStackTrace(System.err);
		}
		return original;
	}
	*/
	
}
