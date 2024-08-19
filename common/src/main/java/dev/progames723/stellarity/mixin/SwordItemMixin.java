package dev.progames723.stellarity.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import dev.progames723.stellarity.items.FrigidHarvesterItem;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.SwordItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.AbstractMap;

@Mixin(SwordItem.class)
public class SwordItemMixin {
	@Unique @Final private final SwordItem instance = (SwordItem) (Object) this;
	
//	@ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE_ASSIGN", target = "Lcom/google/common/collect/ImmutableMultimap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMultimap$Builder;", ordinal = 1))
//	private ImmutableMultimap.Builder<Attribute, AttributeModifier> injectInit(ImmutableMultimap.Builder<Attribute, AttributeModifier> original) {
//		AbstractMap.SimpleEntry<Attribute, AttributeModifier> entry = null;
//		if (instance instanceof FrigidHarvesterItem item) entry = new AbstractMap.SimpleEntry<>();
//		//TODO extend when other items get added
//		if (entry != null) original.put(entry);
//		return original;
//	}
	
	@ModifyExpressionValue(method = "<init>", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMultimap$Builder;build()Lcom/google/common/collect/ImmutableMultimap;"))
	private ImmutableMultimap<Attribute, AttributeModifier> injectInit(ImmutableMultimap<Attribute, AttributeModifier> original) {
		ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
		builder.putAll(original);
		if (instance instanceof FrigidHarvesterItem item) builder.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(item.getSpeedPenaltyUuid(), "Weapon modifier", -0.15, AttributeModifier.Operation.MULTIPLY_TOTAL));
		return builder.build();
	}
}
