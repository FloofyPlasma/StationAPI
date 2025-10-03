package com.floofyplasma.stationapi.api.client.resource;

import com.floofyplasma.stationapi.api.resource.ResourceType;
import com.floofyplasma.stationapi.impl.resource.ReloadableResourceManager;

public final class ReloadableAssetsManager extends ReloadableResourceManager {

    public static final ReloadableAssetsManager INSTANCE = new ReloadableAssetsManager();

    private ReloadableAssetsManager() {
        super(ResourceType.CLIENT_RESOURCES);
    }
}
