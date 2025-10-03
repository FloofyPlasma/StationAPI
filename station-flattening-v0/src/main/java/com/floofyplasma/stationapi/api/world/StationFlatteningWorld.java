package com.floofyplasma.stationapi.api.world;

import net.minecraft.util.math.BlockPos;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationFlatteningWorld extends BlockStateView, HeightLimitView {

    @Override
    default BlockState getBlockState(int x, int y, int z) {
        return Util.assertImpl();
    }

    default BlockState setBlockState(int x, int y, int z, BlockState blockState) {
        return Util.assertImpl();
    }

    default BlockState setBlockStateWithNotify(int x, int y, int z, BlockState blockState) {
        return Util.assertImpl();
    }

    default BlockState setBlockStateWithMetadata(int x, int y, int z, BlockState blockState, int meta) {
        return Util.assertImpl();
    }

    default BlockState setBlockState(BlockPos pos, BlockState blockState) {
        return setBlockState(pos.x, pos.y, pos.z, blockState);
    }

    default BlockState setBlockStateWithNotify(BlockPos pos, BlockState blockState) {
        return setBlockStateWithNotify(pos.x, pos.y, pos.z, blockState);
    }

    default BlockState setBlockStateWithMetadataWithNotify(int x, int y, int z, BlockState blockState, int meta) {
        return Util.assertImpl();
    }

    @Override
    default int getHeight() {
        return Util.assertImpl();
    }

    @Override
    default int getBottomY() {
        return Util.assertImpl();
    }
}
