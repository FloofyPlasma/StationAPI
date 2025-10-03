package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.Material;
import net.minecraft.block.TrapdoorBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateTrapdoorBlock extends TrapdoorBlock implements BlockTemplate {
    public TemplateTrapdoorBlock(Identifier identifier, Material arg) {
        this(BlockTemplate.getNextId(), arg);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateTrapdoorBlock(int i, Material arg) {
        super(i, arg);
    }
}
