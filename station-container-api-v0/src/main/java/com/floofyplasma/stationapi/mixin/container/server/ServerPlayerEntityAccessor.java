package com.floofyplasma.stationapi.mixin.container.server;

import net.minecraft.entity.player.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ServerPlayerEntity.class)
public interface ServerPlayerEntityAccessor {
    @Invoker
    void invokeMethod_314();

    @Accessor
    int getField_260();
}
