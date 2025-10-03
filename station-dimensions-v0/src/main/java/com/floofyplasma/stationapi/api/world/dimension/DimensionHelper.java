package com.floofyplasma.stationapi.api.world.dimension;

import net.minecraft.class_467;
import net.minecraft.entity.player.PlayerEntity;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.util.SideUtil;
import com.floofyplasma.stationapi.impl.client.world.dimension.DimensionHelperClientImpl;
import com.floofyplasma.stationapi.impl.server.world.dimension.DimensionHelperServerImpl;
import com.floofyplasma.stationapi.impl.world.dimension.DimensionHelperImpl;

public class DimensionHelper {

    @SuppressWarnings("Convert2MethodRef") // Method references load their target classes on both sides, causing crashes.
    private static final DimensionHelperImpl INSTANCE = SideUtil.get(() -> new DimensionHelperClientImpl(), () -> new DimensionHelperServerImpl());

    public static void switchDimension(PlayerEntity player, Identifier destination, double scale, class_467 travelAgent) {
        INSTANCE.switchDimension(player, destination, scale, travelAgent);
    }
}
