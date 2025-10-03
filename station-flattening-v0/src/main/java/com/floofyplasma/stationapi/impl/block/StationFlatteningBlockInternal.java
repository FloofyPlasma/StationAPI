package com.floofyplasma.stationapi.impl.block;

import com.floofyplasma.stationapi.api.block.BlockState;

import java.util.function.ToIntFunction;

public interface StationFlatteningBlockInternal {
    ToIntFunction<BlockState> stationapi_getLuminanceProvider();
}
