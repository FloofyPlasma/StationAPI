package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SugarCaneBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSugarCaneBlock extends SugarCaneBlock implements BlockTemplate {
    public TemplateSugarCaneBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSugarCaneBlock(int i, int j) {
        super(i, j);
    }
}
