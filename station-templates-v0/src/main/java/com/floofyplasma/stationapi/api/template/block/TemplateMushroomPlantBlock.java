package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.MushroomPlantBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateMushroomPlantBlock extends MushroomPlantBlock implements BlockTemplate {
    public TemplateMushroomPlantBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateMushroomPlantBlock(int i, int j) {
        super(i, j);
    }
}
