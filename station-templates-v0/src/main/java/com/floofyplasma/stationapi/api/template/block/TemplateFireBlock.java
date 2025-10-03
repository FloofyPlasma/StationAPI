package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.FireBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateFireBlock extends FireBlock implements BlockTemplate {
    public TemplateFireBlock(Identifier identifier, int texture) {
        this(BlockTemplate.getNextId(), texture);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateFireBlock(int id, int texture) {
        super(id, texture);
    }
}
