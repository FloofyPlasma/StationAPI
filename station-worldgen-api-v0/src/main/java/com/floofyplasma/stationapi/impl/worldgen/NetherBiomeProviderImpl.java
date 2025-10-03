package com.floofyplasma.stationapi.impl.worldgen;

import net.minecraft.world.biome.Biome;
import com.floofyplasma.stationapi.api.worldgen.biome.VoronoiBiomeProvider;

public class NetherBiomeProviderImpl extends VoronoiBiomeProvider {
    private static final NetherBiomeProviderImpl INSTANCE = new NetherBiomeProviderImpl();

    private NetherBiomeProviderImpl() {
        addBiome(Biome.HELL);
    }

    public static NetherBiomeProviderImpl getInstance() {
        return INSTANCE;
    }
}
