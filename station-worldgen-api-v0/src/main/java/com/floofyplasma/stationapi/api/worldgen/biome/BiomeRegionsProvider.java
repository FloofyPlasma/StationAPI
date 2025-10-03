package com.floofyplasma.stationapi.api.worldgen.biome;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.class_458;
import net.minecraft.world.biome.Biome;
import com.floofyplasma.stationapi.impl.worldgen.IDVoronoiNoise;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BiomeRegionsProvider implements BiomeProvider {
    private final double[] buffer = new double[1];
    private final List<BiomeProvider> providers;

    private IDVoronoiNoise idNoise;
    private class_458 distortX;
    private class_458 distortZ;

    public BiomeRegionsProvider(List<BiomeProvider> providers) {
        this.providers = providers;
    }

    @Override
    public Biome getBiome(int x, int z, float temperature, float downfall) {
        double px = x * 0.01 + distortX.method_1516(buffer, x, z, 1, 1, 0.1, 0.1, 0.25)[0] * 0.1;
        double pz = z * 0.01 + distortZ.method_1516(buffer, x, z, 1, 1, 0.1, 0.1, 0.25)[0] * 0.1;
        int id = idNoise.getID(px, pz, providers.size());
        return providers.get(id).getBiome(x, z, temperature, downfall);
    }
    
    @Override
    public Collection<Biome> getBiomes() {
        Set<Biome> biomes = new ObjectOpenHashSet<>();
        providers.forEach(provider -> biomes.addAll(provider.getBiomes()));
        return biomes;
    }
    
    @Override
    public void setSeed(long seed) {
        Random random = new Random(seed);
        idNoise = new IDVoronoiNoise(random.nextInt());
        distortX = new class_458(new Random(random.nextLong()), 2);
        distortZ = new class_458(new Random(random.nextLong()), 2);
        providers.forEach(provider -> provider.setSeed(seed));
    }
}
