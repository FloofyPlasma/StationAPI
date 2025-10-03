package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.SpawnerBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSpawnerBlock extends SpawnerBlock implements BlockTemplate {
    public TemplateSpawnerBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateSpawnerBlock(int i, int j) {
        super(i, j);
    }
}
