package dev.progames723.stellarity.mixin;

import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.SwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SwordItem.class)
public interface SwordItemAccess {//hmmm should i use reflection instead
	@Accessor
	void setAttackDamage(float attackDamage);
	
	@Accessor
	void setDefaultModifiers(Multimap<Attribute, AttributeModifier> multimap);
}
