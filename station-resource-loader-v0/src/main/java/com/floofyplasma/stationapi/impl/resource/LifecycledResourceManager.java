package com.floofyplasma.stationapi.impl.resource;

import com.floofyplasma.stationapi.api.resource.ResourceManager;

public interface LifecycledResourceManager extends ResourceManager, AutoCloseable {
    void close();
}
