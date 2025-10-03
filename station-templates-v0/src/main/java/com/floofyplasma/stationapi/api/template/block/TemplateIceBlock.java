package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.IceBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateIceBlock extends IceBlock implements BlockTemplate {
    public TemplateIceBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateIceBlock(int i, int j) {
        super(i, j);
    }
}
