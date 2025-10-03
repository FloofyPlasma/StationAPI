package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.ChestBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateChestBlock extends ChestBlock implements BlockTemplate {
    public TemplateChestBlock(Identifier identifier) {
        this(BlockTemplate.getNextId());
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateChestBlock(int id) {
        super(id);
    }
}
