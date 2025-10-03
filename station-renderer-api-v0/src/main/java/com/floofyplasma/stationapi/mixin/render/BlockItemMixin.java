package com.floofyplasma.stationapi.mixin.render;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlas;
import com.floofyplasma.stationapi.api.client.texture.atlas.CustomAtlasProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(BlockItem.class)
class BlockItemMixin implements CustomAtlasProvider {
    @Shadow private int itemId;

    @Override
    @Unique
    public Atlas getAtlas() {
        return Block.BLOCKS[itemId].getAtlas();
    }
}
