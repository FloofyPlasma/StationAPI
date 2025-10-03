package com.floofyplasma.stationapi.mixin.dimension.server;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import com.floofyplasma.stationapi.api.registry.DimensionRegistry;
import com.floofyplasma.stationapi.api.world.dimension.VanillaDimensions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ServerPlayNetworkHandler.class)
class ServerPlayNetworkHandlerMixin {
    @Shadow private ServerPlayerEntity field_920;

    @ModifyConstant(
            method = "onPlayerRespawn",
            constant = @Constant(intValue = 0)
    )
    private int stationapi_modifyRespawnDimension(int original) {
        return field_920.world.dimension.method_1766() ? field_920.dimensionId : DimensionRegistry.INSTANCE.getLegacyId(VanillaDimensions.OVERWORLD).orElseThrow(() -> new IllegalStateException("Overworld not found!"));
    }
}
