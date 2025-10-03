package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.WorkbenchBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateWorkbenchBlock extends WorkbenchBlock implements BlockTemplate {
    public TemplateWorkbenchBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateWorkbenchBlock(int i) {
        super(i);
    }
}
