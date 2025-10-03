package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.ButtonBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateButtonBlock extends ButtonBlock implements BlockTemplate {
    public TemplateButtonBlock(Identifier identifier, int texture) {
        this(BlockTemplate.getNextId(), texture);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateButtonBlock(int id, int texture) {
        super(id, texture);
    }
}
