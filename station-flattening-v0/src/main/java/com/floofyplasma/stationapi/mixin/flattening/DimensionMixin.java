package com.floofyplasma.stationapi.mixin.flattening;

import net.minecraft.world.dimension.Dimension;
import com.floofyplasma.stationapi.api.world.dimension.StationDimension;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Dimension.class)
class DimensionMixin implements StationDimension {}
