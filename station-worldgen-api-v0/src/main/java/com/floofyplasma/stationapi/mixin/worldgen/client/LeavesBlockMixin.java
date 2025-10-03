package com.floofyplasma.stationapi.mixin.worldgen.client;

import net.minecraft.block.LeavesBlock;
import net.minecraft.world.BlockView;
import com.floofyplasma.stationapi.impl.worldgen.BiomeColorsImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.At.Shift;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LeavesBlock.class)
class LeavesBlockMixin {
    @Inject(
            method = "getColorMultiplier",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/BlockView;method_1781()Lnet/minecraft/class_519;",
                    ordinal = 0,
                    shift = Shift.BEFORE
            ),
            cancellable = true
    )
    private void stationapi_getBiomeColor(BlockView view, int x, int y, int z, CallbackInfoReturnable<Integer> info) {
        int color = BiomeColorsImpl.LEAVES_INTERPOLATOR.getColor(view.method_1781(), x, z);
        info.setReturnValue(color);
    }
}
