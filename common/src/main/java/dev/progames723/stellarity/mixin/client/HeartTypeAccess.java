package dev.progames723.stellarity.mixin.client;

import net.minecraft.client.gui.Gui;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Gui.HeartType.class)
public interface HeartTypeAccess {
    @Invoker("forPlayer")
    static Gui.HeartType forPlayer(Player player) {return null;}
    
    @Invoker("$values")
    static Gui.HeartType[] values(){
        return new Gui.HeartType[]{};
    }
    
    
}
