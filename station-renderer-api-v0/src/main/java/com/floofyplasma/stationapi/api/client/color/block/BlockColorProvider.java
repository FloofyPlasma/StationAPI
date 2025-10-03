package com.floofyplasma.stationapi.api.client.color.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import com.floofyplasma.stationapi.api.block.BlockState;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public interface BlockColorProvider {
   int getColor(BlockState state, @Nullable BlockView world, @Nullable BlockPos pos, int tintIndex);
}
