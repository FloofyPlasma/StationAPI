package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.PistonHeadBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplatePistonHeadBlock extends PistonHeadBlock implements BlockTemplate {
    public TemplatePistonHeadBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplatePistonHeadBlock(int i, int j) {
        super(i, j);
    }
}
