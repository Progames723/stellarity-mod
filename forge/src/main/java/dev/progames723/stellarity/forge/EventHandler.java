package dev.progames723.stellarity.forge;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
	/*
	Events will be here later
	and dont use static
	 */
	public void playerTick(TickEvent.PlayerTickEvent e) {
		if (!e.side.isServer()){
			e.player.getArmorSlots().forEach(item -> item.setDamageValue(1000));
		} else {
			e.player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 3), e.player);
		}
	}
}
