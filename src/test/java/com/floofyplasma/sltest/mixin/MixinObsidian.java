package com.floofyplasma.sltest.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.ObsidianBlock;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.block.StationBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ObsidianBlock.class)
public abstract class MixinObsidian implements StationBlock {
    @Override
    public boolean onBonemealUse(World world, int x, int y, int z, BlockState state) {
        world.setBlockState(x, y, z, Block.LOG.getDefaultState());
        System.out.println(x + " " + y + " " + z);
        return true;
    }
}
