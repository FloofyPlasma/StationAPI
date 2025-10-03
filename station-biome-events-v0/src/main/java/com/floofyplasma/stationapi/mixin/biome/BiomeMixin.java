package com.floofyplasma.stationapi.mixin.biome;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.biome.Biome;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.world.biome.BiomeByClimateEvent;
import com.floofyplasma.stationapi.api.event.world.biome.BiomeRegisterEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Biome.class)
class BiomeMixin {
    @Inject(
            method = "<clinit>",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/biome/Biome;init()V",
                    shift = At.Shift.BEFORE
            )
    )
    private static void stationapi_afterVanillaBiomes(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(BiomeRegisterEvent.builder().build());
    }

    @ModifyReturnValue(
            method = "method_787",
            at = @At("RETURN")
    )
    private static Biome stationapi_getBiome(Biome currentBiome, float temperature, float downfall) {
        return StationAPI.EVENT_BUS.post(
                BiomeByClimateEvent.builder()
                        .temperature(temperature)
                        .downfall(downfall)
                        .currentBiome(currentBiome)
                        .build()
        ).currentBiome;
    }
}
