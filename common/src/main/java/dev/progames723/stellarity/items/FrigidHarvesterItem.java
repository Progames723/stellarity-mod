package dev.progames723.stellarity.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.contents.TranslatableContents;
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

import static dev.progames723.stellarity.items.FrigidHarvesterItem.DynamicTexture.BASE;

public class FrigidHarvesterItem extends SwordItem {
	public enum DynamicTexture {
		BASE(90000),
		TIER_1(90001),
		TIER_2(90002),
		TIER_3(90003),
		TIER_4(90004);
		DynamicTexture(int CustomModelData) {}
	}
	public FrigidHarvesterItem(Tier tier, int i, float f, Properties properties) {
		super(tier, i, f, properties);
	}
	private static final AttributeModifier frigidHarvesterDebuff = new AttributeModifier(UUID.fromString("842489a8-98ac-4587-a489-a898ac058739"), "frigid_harvester_debuff", -0.15, AttributeModifier.Operation.MULTIPLY_BASE);
	@Override
	public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
		super.appendHoverText(itemStack, level, list, tooltipFlag);
		itemStack.setHoverName(Component.translatableWithFallback("stellarity.items.weapons.frigid_harvester", "Frigid Harvester").setStyle(Style.EMPTY).withStyle(ChatFormatting.AQUA));
		list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.1", "Imbues itself with souls of slain mobs", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.2", "permanently increasing its damage", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.3", "and unlocking passive abilities", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("stellarity.items.weapons.frigid_harvester.description.4", "Gets less damage the more souls it absorbs", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("- Developer Item -", "§fꑡ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents("Stellarity", "§fꑟ", new Object[]{})));
		list.add(MutableComponent.create(new TranslatableContents(" ", " ", new Object[]{})));
	}
	private void addSlowdown(Player player) {
		player.getAttribute(Attributes.MOVEMENT_SPEED).addTransientModifier(frigidHarvesterDebuff);
	}
	private void removeSlowdown(Player player) {
		player.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(frigidHarvesterDebuff.getId());
	}
	private boolean hasSlowdown(Player player) {
		if (player.getAttribute(Attributes.MOVEMENT_SPEED).hasModifier(frigidHarvesterDebuff)){
			return true;
		} else if (player.getAttribute(Attributes.MOVEMENT_SPEED) == null) {
			return false;
		}
		return false;
	}
	@Override
	public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean bl){
		if (entity instanceof Player player){
			if (player.getInventory().getSelected().is(this) && itemStack.is(this) && !hasSlowdown(player)){
				this.addSlowdown(player);
			} else if (!player.getInventory().getSelected().is(this) && itemStack.is(this) && hasSlowdown(player)){
				this.removeSlowdown(player);
			}
			if (player.getInventory().getSelected().is(this) && itemStack.is(this)) {
				double damageBoostAmount = itemStack.getOrCreateTagElement("frigid_harvester").getDouble("damage_boost");
				if (damageBoostAmount >= 14) {
					damageBoostAmount = 14;
					itemStack.getOrCreateTagElement("frigid_harvester").putDouble("damage_boost", 14);
				} else if (damageBoostAmount < 0){
					damageBoostAmount = 0;
					itemStack.getOrCreateTagElement("frigid_harvester").putDouble("damage_boost", 0);
				}
				if (damageBoostAmount < 3) {
					changeItemTexture(itemStack, BASE);
					itemStack.getOrCreateTag().putBoolean("Unbreakable", false);
				} else if (damageBoostAmount >= 3 && damageBoostAmount < 6) {
					changeItemTexture(itemStack, DynamicTexture.TIER_1);
					itemStack.getOrCreateTag().putBoolean("Unbreakable", false);
				} else if (damageBoostAmount >= 6 && damageBoostAmount < 9) {
					changeItemTexture(itemStack, DynamicTexture.TIER_2);
					itemStack.getOrCreateTag().putBoolean("Unbreakable", false);
				} else if (damageBoostAmount >= 9 && damageBoostAmount < 14) {
					changeItemTexture(itemStack, DynamicTexture.TIER_3);
					itemStack.getOrCreateTag().putBoolean("Unbreakable", false);
				} else if (damageBoostAmount >= 14) {
					changeItemTexture(itemStack, DynamicTexture.TIER_4);
					itemStack.getOrCreateTag().putBoolean("Unbreakable", true);
					itemStack.getOrCreateTag().putInt("HideFlags", 4);
				}
			}
		}
	}
	public static void changeItemTexture(ItemStack item, FrigidHarvesterItem.DynamicTexture texture) {
		switch (texture) {
			case BASE -> item.getOrCreateTag().putInt("CustomModelData", 90000);
			case TIER_1 -> item.getOrCreateTag().putInt("CustomModelData", 90001);
			case TIER_2 -> item.getOrCreateTag().putInt("CustomModelData", 90002);
			case TIER_3 -> item.getOrCreateTag().putInt("CustomModelData", 90003);
			case TIER_4 -> item.getOrCreateTag().putInt("CustomModelData", 90004);
			default -> throw new IllegalArgumentException("Unexpected value: " + texture);
		}
	}
}
