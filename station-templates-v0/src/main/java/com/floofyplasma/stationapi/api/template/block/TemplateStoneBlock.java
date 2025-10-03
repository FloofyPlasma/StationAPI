package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.StoneBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateStoneBlock extends StoneBlock implements BlockTemplate {
    public TemplateStoneBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateStoneBlock(int i, int j) {
        super(i, j);
    }
}
