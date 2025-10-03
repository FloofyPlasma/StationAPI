package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SoulSandBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSoulSandBlock extends SoulSandBlock implements BlockTemplate {
    public TemplateSoulSandBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSoulSandBlock(int i, int j) {
        super(i, j);
    }
}
