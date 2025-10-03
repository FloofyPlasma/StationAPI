package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.RepeaterBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateRepeaterBlock extends RepeaterBlock implements BlockTemplate {
    public TemplateRepeaterBlock(Identifier identifier, boolean flag) {
        this(BlockTemplate.getNextId(), flag);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateRepeaterBlock(int i, boolean flag) {
        super(i, flag);
    }
}
