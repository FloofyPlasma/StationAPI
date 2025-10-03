package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SpongeBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSpongeBlock extends SpongeBlock implements BlockTemplate {
    public TemplateSpongeBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSpongeBlock(int i) {
        super(i);
    }
}
