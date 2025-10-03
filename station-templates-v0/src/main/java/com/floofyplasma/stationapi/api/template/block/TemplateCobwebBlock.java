package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.CobwebBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateCobwebBlock extends CobwebBlock implements BlockTemplate {
    public TemplateCobwebBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateCobwebBlock(int i, int j) {
        super(i, j);
    }
}
