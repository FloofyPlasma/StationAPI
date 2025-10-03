package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.TallPlantBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateTallPlantBlock extends TallPlantBlock implements BlockTemplate {
    public TemplateTallPlantBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateTallPlantBlock(int i, int j) {
        super(i, j);
    }
}
