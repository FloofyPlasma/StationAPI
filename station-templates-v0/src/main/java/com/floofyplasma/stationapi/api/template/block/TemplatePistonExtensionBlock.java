package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.entity.PistonExtensionBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplatePistonExtensionBlock extends PistonExtensionBlock implements BlockTemplate {
    public TemplatePistonExtensionBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplatePistonExtensionBlock(int id) {
        super(id);
    }
}
