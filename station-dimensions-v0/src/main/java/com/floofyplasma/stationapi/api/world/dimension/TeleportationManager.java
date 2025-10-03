package com.floofyplasma.stationapi.api.world.dimension;

import net.minecraft.entity.player.PlayerEntity;
import com.floofyplasma.stationapi.impl.block.NetherPortalImpl;

public interface TeleportationManager {

    default void switchDimension(PlayerEntity player) {
        NetherPortalImpl.switchDimension(player);
    }
}
