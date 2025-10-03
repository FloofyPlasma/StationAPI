package com.floofyplasma.stationapi.api.block.entity;

import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationFlatteningPistonBlockEntity {
    default BlockState getPushedBlockState() {
        return Util.assertImpl();
    }
}
