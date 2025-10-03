package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateStairsBlock extends StairsBlock implements BlockTemplate {
    public TemplateStairsBlock(Identifier identifier, Block arg) {
        this(BlockTemplate.getNextId(), arg);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateStairsBlock(int i, Block arg) {
        super(i, arg);
    }
}
