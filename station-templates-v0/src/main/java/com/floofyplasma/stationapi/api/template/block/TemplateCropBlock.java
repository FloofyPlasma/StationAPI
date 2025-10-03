package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.CropBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateCropBlock extends CropBlock implements BlockTemplate {
    public TemplateCropBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateCropBlock(int i, int j) {
        super(i, j);
    }
}
