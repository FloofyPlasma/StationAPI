package com.floofyplasma.stationapi.api.worldgen.surface.condition;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.block.BlockState;

public class BlockSurfaceCondition implements SurfaceCondition {
    private final Block block;

    public BlockSurfaceCondition(Block block) {
        this.block = block;
    }

    @Override
    public boolean canApply(World world, int x, int y, int z, BlockState state) {
        return state.isOf(block);
    }
}
