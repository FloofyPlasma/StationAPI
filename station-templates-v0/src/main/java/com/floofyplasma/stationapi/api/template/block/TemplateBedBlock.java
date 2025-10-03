package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.BedBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateBedBlock extends BedBlock implements BlockTemplate {
    public TemplateBedBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateBedBlock(int id) {
        super(id);
    }
}
