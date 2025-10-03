package com.floofyplasma.stationapi.mixin.worldgen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.OverworldDimension;
import com.floofyplasma.stationapi.api.worldgen.BiomeAPI;
import org.spongepowered.asm.mixin.Mixin;

import java.util.Collection;

@Mixin(OverworldDimension.class)
class OverworldDimensionMixin extends Dimension {
    @Override
    public Collection<Biome> getBiomes() {
        return BiomeAPI.getOverworldProvider().getBiomes();
    }
}
