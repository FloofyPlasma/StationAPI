package com.floofyplasma.stationapi.api.resource;

import com.floofyplasma.stationapi.impl.resource.ReloadableResourceManager;

public class DataManager extends ReloadableResourceManager {
    public static final DataManager INSTANCE = new DataManager();

    private DataManager() {
        super(ResourceType.SERVER_DATA);
    }
}
