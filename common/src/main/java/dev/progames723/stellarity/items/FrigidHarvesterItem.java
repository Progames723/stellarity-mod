package dev.progames723.stellarity.items;

import dev.progames723.stellarity.utils.ColorUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class FrigidHarvesterItem extends SwordItem implements SpecialAbilityItem {
	private int progressBarValue;
	
	private int progressBarMaxValue;
	
	private double progressBarPercentage;
	
	private boolean isMaxedOut;
	
	private Vec3i gradientColors1 = new Vec3i(18, 71, 140);
	
	private Vec3i gradientColors2 = new Vec3i(162, 30, 199);
	
	public static final UUID SPEED_PENALTY_UUID = UUID.fromString("8F8EDC14-6974-4A06-8EDC-1469748A0665");
	
	@Override
	public void setProgressBarPercentage(double percentage) {
		percentage = Mth.clamp(percentage, 0, 1);
		progressBarPercentage = percentage;
		progressBarValue = (int) (progressBarMaxValue * percentage);
		isMaxedOut = progressBarPercentage == 1.0;
	}
	
	public UUID getSpeedPenaltyUuid() {
		return SPEED_PENALTY_UUID;
	}
	
	@Override
	public void setProgressBarValue(int value) {
		progressBarValue = value;
		progressBarPercentage = (double) progressBarValue / progressBarMaxValue;
		isMaxedOut = progressBarPercentage == 1.0;
	}
	
	@Override
	public void setProgressBarMaxValue(int value) {
		progressBarMaxValue = value;
		progressBarPercentage = (double) progressBarValue / progressBarMaxValue;
		isMaxedOut = progressBarPercentage == 1.0;
	}
	
	@Override public double getProgressBarPercentage() {return progressBarPercentage;}
	
	@Override public int getProgressBarValue() {return progressBarValue;}
	
	@Override public int getProgressBarMaxValue() {return progressBarMaxValue;}
	
	@Override public Vec3i getGradientColors1() {return gradientColors1;}
	
	@Override public void setGradientColors1(Vec3i colors) {gradientColors1 = colors;}
	
	@Override public boolean shouldOverrideHiddenBar() {return false;}
	
	@Override public Vec3i getGradientColors2() {return gradientColors2;}
	
	@Override public void setGradientColors2(Vec3i colors) {gradientColors2 = colors;}
	
	@Override public boolean showCustomBar() {return !isMaxedOut;}
	
	public enum DynamicTexture {
		BASE(90000), TIER_1(90001), TIER_2(90002), TIER_3(90003), TIER_4(90004);
		
		private final int customModelData;
		
		DynamicTexture(int customModelData) {this.customModelData = customModelData;}
	}
	
	public FrigidHarvesterItem(Tier tier, int i, float f, Properties properties) {
		super(tier, i, f, properties);
		progressBarValue = 0;
		progressBarMaxValue = 14;
		progressBarPercentage = 0;
		isMaxedOut = false;
	}
	
	@Override
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		super.appendHoverText(itemStack, level, list, tooltipFlag);
		if (isMaxedOut) {
			if (!itemStack.hasCustomHoverName()) itemStack.setHoverName(Component.translatableWithFallback("stellarity.items.weapons.frigid_harvester", "Frigid Harvester").setStyle(Style.EMPTY.withItalic(false).withColor(TextColor.fromRgb((int) ColorUtil.RGBToDecimalColor(167, 39, 184)))));
		} else {
			if (!itemStack.hasCustomHoverName()) itemStack.setHoverName(Component.translatableWithFallback("stellarity.items.weapons.frigid_harvester", "Frigid Harvester").setStyle(Style.EMPTY.withItalic(false).withColor(ChatFormatting.AQUA)));
			list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
			list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.1", "Imbues itself with souls of slain mobs", new Object[]{})));
			list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.2", "permanently increasing its damage", new Object[]{})));
			list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.3", "and unlocking passive abilities", new Object[]{})));
			list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.4", "Gets less damage the more souls it absorbs", new Object[]{})));
			list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
		}
		list.add(MutableComponent.create(new TranslatableContents("- Developer Item -", "§fꑡ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("Stellarity", "§fꑟ", new Object[]{})));
	}
	
	@Override
	public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl){//i agree with the plugin on that one -> (code complexity)
		if (!(entity instanceof Player)) return;
		if (!itemStack.is(this)) return;
		if (itemStack.getTagElement("frigid_harvester") == null) {
			itemStack.addTagElement("frigid_harvester", new CompoundTag());
			CompoundTag tag = itemStack.getTagElement("frigid_harvester");
			assert tag != null;
			tag.putDouble("damage_boost", 0.0);
			return;
		}
		CompoundTag tag = itemStack.getTagElement("frigid_harvester");
		assert tag != null;
		double damageBoostAmount = tag.getDouble("damage_boost");
		setProgressBarPercentage(Mth.clamp(damageBoostAmount/14, 0, 1));//also sets isMaxedOut
		if (isMaxedOut) {
			changeItemTexture(itemStack, DynamicTexture.TIER_4);
			itemStack.getOrCreateTag().putBoolean("Unbreakable", true);
			itemStack.getOrCreateTagElement("frigid_harvester").putDouble("damage_boost", 14);
			itemStack.getOrCreateTagElement("frigid_harvester").putBoolean("fully_maxed_out", true);
			itemStack.getOrCreateTag().putInt("HideFlags", 4);
		} else {
			if (damageBoostAmount >= 14) {
				isMaxedOut = true;
				return;
			} else if (damageBoostAmount < 0){
				damageBoostAmount = 0;
				itemStack.getOrCreateTagElement("frigid_harvester").putDouble("damage_boost", 0);
			}
			if (damageBoostAmount < 3) {
				changeItemTexture(itemStack, DynamicTexture.BASE);
			} else if (damageBoostAmount >= 3 && damageBoostAmount < 6) {
				changeItemTexture(itemStack, DynamicTexture.TIER_1);
			} else if (damageBoostAmount >= 6 && damageBoostAmount < 9) {
				changeItemTexture(itemStack, DynamicTexture.TIER_2);
			} else if (damageBoostAmount >= 9 && damageBoostAmount < 14) {
				changeItemTexture(itemStack, DynamicTexture.TIER_3);
			}
		}
	}
	
	public static void changeItemTexture(ItemStack item, FrigidHarvesterItem.DynamicTexture texture) {
		switch (texture) {
			case BASE, TIER_1, TIER_2, TIER_3, TIER_4 -> item.getOrCreateTag().putInt("CustomModelData", texture.customModelData);
			default -> throw new IllegalArgumentException("Unexpected value: " + texture);
		}
	}
}
