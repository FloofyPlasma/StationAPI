package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SandstoneBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSandstoneBlock extends SandstoneBlock implements BlockTemplate {
    public TemplateSandstoneBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSandstoneBlock(int i) {
        super(i);
    }
}
