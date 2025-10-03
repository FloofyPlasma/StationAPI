package com.floofyplasma.stationapi.api.entity.player;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import com.floofyplasma.stationapi.api.block.BlockState;

public interface PlayerStrengthWithBlockState {

    boolean canHarvest(BlockView blockView, BlockPos blockPos, BlockState state);

    float getBlockBreakingSpeed(BlockView blockView, BlockPos blockPos, BlockState state);
}
