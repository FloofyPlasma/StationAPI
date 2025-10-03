package com.floofyplasma.stationapi.mixin.lifecycle.server;

import net.minecraft.server.MinecraftServer;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.tick.GameTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
class MinecraftServerMixin {
    @Inject(
            method = "method_2171",
            at = @At("RETURN")
    )
    private void stationapi_endTick(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(GameTickEvent.End.builder().build());
    }
}
