package com.floofyplasma.sltest.block;

import net.minecraft.block.Material;
import com.floofyplasma.sltest.texture.TextureListener;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.template.block.TemplateBlock;

public class BlockAltar extends TemplateBlock {

    public BlockAltar(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public int getTexture(int side) {
        return TextureListener.altarTextures[side];
    }
}
