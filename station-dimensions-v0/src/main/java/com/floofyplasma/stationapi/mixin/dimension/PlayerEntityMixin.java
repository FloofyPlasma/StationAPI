package com.floofyplasma.stationapi.mixin.dimension;

import net.minecraft.entity.player.PlayerEntity;
import com.floofyplasma.stationapi.api.entity.HasTeleportationManager;
import com.floofyplasma.stationapi.api.world.dimension.TeleportationManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(PlayerEntity.class)
class PlayerEntityMixin implements HasTeleportationManager {
    @Unique
    private TeleportationManager stationapi_teleportationManager;

    @Unique
    @Override
    public void setTeleportationManager(TeleportationManager manager) {
        stationapi_teleportationManager = manager;
    }

    @Unique
    @Override
    public TeleportationManager getTeleportationManager() {
        return stationapi_teleportationManager;
    }
}
