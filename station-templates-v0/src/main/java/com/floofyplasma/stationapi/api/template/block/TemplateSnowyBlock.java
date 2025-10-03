package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SnowyBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSnowyBlock extends SnowyBlock implements BlockTemplate {
    public TemplateSnowyBlock(Identifier identifier, int texUVStart) {
        this(BlockTemplate.getNextId(), texUVStart);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSnowyBlock(int id, int texUVStart) {
        super(id, texUVStart);
    }
}
