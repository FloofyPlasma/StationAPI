package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.GrassBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateGrassBlock extends GrassBlock implements BlockTemplate {
    public TemplateGrassBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateGrassBlock(int id) {
        super(id);
    }
}
