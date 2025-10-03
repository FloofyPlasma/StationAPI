package com.floofyplasma.stationapi.api.entity;

import com.floofyplasma.stationapi.api.world.dimension.TeleportationManager;

public interface HasTeleportationManager {

    void setTeleportationManager(TeleportationManager manager);

    TeleportationManager getTeleportationManager();
}
