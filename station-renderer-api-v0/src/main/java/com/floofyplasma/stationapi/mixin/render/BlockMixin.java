package com.floofyplasma.stationapi.mixin.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvironmentInterface;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.client.block.StationRendererBlock;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlas;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlases;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Block.class)
@EnvironmentInterface(value = EnvType.CLIENT, itf = StationRendererBlock.class)
class BlockMixin implements StationRendererBlock {
    @Override
    @Environment(EnvType.CLIENT)
    @Unique
    public Atlas getAtlas() {
        return Atlases.getTerrain();
    }
}
