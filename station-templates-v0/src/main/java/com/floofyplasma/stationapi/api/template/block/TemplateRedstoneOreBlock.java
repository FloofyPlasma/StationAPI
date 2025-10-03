package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.RedstoneOreBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateRedstoneOreBlock extends RedstoneOreBlock implements BlockTemplate {
    public TemplateRedstoneOreBlock(Identifier identifier, int j, boolean isLit) {
        this(BlockTemplate.getNextId(), j, isLit);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateRedstoneOreBlock(int i, int j, boolean isLit) {
        super(i, j, isLit);
    }
}
