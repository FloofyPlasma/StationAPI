package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.LogBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateLogBlock extends LogBlock implements BlockTemplate {
    public TemplateLogBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateLogBlock(int i) {
        super(i);
    }
}
