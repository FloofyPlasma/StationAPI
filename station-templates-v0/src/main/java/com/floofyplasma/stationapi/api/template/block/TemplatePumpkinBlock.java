package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.PumpkinBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplatePumpkinBlock extends PumpkinBlock implements BlockTemplate {
    public TemplatePumpkinBlock(Identifier identifier, int j, boolean flag) {
        this(BlockTemplate.getNextId(), j, flag);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplatePumpkinBlock(int i, int j, boolean flag) {
        super(i, j, flag);
    }
}
