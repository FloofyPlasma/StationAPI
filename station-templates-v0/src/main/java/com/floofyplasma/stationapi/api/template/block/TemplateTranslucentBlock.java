package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.Material;
import net.minecraft.class_221;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateTranslucentBlock extends class_221 implements BlockTemplate {
    public TemplateTranslucentBlock(Identifier identifier, int j, Material arg, boolean flag) {
        this(BlockTemplate.getNextId(), j, arg, flag);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateTranslucentBlock(int i, int j, Material arg, boolean flag) {
        super(i, j, arg, flag);
    }
}
