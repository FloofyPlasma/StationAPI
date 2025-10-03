package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.TntBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateTntBlock extends TntBlock implements BlockTemplate {
    public TemplateTntBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateTntBlock(int i, int j) {
        super(i, j);
    }
}
