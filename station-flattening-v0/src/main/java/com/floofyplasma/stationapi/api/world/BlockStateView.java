package com.floofyplasma.stationapi.api.world;

import net.minecraft.util.math.BlockPos;
import com.floofyplasma.stationapi.api.block.BlockState;

public interface BlockStateView {

    BlockState getBlockState(int x, int y, int z);

    default BlockState getBlockState(BlockPos pos) {
        return getBlockState(pos.getX(), pos.getY(), pos.getZ());
    }
}
