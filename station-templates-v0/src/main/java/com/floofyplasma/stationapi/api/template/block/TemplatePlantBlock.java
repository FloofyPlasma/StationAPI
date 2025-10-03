package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.PlantBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplatePlantBlock extends PlantBlock implements BlockTemplate {
    public TemplatePlantBlock(Identifier identifier, int texture) {
        this(BlockTemplate.getNextId(), texture);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplatePlantBlock(int id, int texture) {
        super(id, texture);
    }
}
