package com.floofyplasma.stationapi.api.client.render.block;

import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationRendererBlockRenderManager {
    default void renderAllSides(BlockState state, int x, int y, int z) {
        Util.assertImpl();
    }
}
