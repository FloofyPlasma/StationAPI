package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.NetherrackBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateNetherrackBlock extends NetherrackBlock implements BlockTemplate {
    public TemplateNetherrackBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateNetherrackBlock(int i, int j) {
        super(i, j);
    }
}
