package com.floofyplasma.stationapi.impl.world.dimension;

import net.minecraft.class_467;
import net.minecraft.entity.player.PlayerEntity;
import com.floofyplasma.stationapi.api.util.Identifier;

public abstract class DimensionHelperImpl {

    public abstract void switchDimension(PlayerEntity player, Identifier destination, double scale, class_467 travelAgent);
}
