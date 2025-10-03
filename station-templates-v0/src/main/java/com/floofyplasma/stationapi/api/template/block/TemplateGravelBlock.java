package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.GravelBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateGravelBlock extends GravelBlock implements BlockTemplate {
    public TemplateGravelBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateGravelBlock(int i, int j) {
        super(i, j);
    }
}
