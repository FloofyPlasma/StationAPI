package com.floofyplasma.stationapi.mixin.recipe;

import net.minecraft.stat.Stats;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.recipe.BeforeRecipeStatsEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Stats.class)
class StatsMixin {
    @Inject(
            method = "initializeCraftedItemStats",
            at = @At(
                    value = "NEW",
                    target = "()Ljava/util/HashSet;",
                    remap = false
            )
    )
    private static void stationapi_beforeRecipeStats(CallbackInfo ci) {
        StationAPI.EVENT_BUS.post(BeforeRecipeStatsEvent.builder().build());
    }
}
