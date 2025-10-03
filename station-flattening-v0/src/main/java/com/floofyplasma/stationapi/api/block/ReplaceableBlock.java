package com.floofyplasma.stationapi.api.block;

import com.floofyplasma.stationapi.api.item.ItemPlacementContext;

public interface ReplaceableBlock {

    boolean canReplace(BlockState state, ItemPlacementContext context);
}
