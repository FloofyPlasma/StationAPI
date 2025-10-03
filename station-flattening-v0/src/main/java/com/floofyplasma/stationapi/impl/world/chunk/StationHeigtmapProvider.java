package com.floofyplasma.stationapi.impl.world.chunk;

public interface StationHeigtmapProvider {
    byte[] getStoredHeightmap();
    void loadStoredHeightmap(byte[] heightmap);
}
