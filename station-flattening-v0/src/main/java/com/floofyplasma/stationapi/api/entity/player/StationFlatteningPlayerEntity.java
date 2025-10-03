package com.floofyplasma.stationapi.api.entity.player;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationFlatteningPlayerEntity extends PlayerStrengthWithBlockState {

    @Override
    default boolean canHarvest(BlockView blockView, BlockPos blockPos, BlockState state) {
        return Util.assertImpl();
    }

    @Override
    default float getBlockBreakingSpeed(BlockView blockView, BlockPos blockPos, BlockState state) {
        return Util.assertImpl();
    }
}
