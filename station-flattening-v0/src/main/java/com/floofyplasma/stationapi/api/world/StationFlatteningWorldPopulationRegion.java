package com.floofyplasma.stationapi.api.world;

import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationFlatteningWorldPopulationRegion extends BlockStateView {

    @Override
    default BlockState getBlockState(int x, int y, int z) {
        return Util.assertImpl();
    }
}
