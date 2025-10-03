package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SnowBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSnowBlock extends SnowBlock implements BlockTemplate {
    public TemplateSnowBlock(Identifier identifier, int texUVStart) {
        this(BlockTemplate.getNextId(), texUVStart);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSnowBlock(int id, int texUVStart) {
        super(id, texUVStart);
    }
}
