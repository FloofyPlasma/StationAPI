package com.floofyplasma.stationapi.mixin.blockentity;

import net.minecraft.block.entity.BlockEntity;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.block.entity.BlockEntityRegisterEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlockEntity.class)
class BlockEntityMixin {
    @Shadow
    private static void method_1067(Class<?> arg, String string) {}

    @Inject(
            method = "<clinit>",
            at = @At("TAIL")
    )
    private static void stationapi_registerModdedTileEntities(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(BlockEntityRegisterEvent.builder().register(BlockEntityMixin::method_1067).build());
    }
}
