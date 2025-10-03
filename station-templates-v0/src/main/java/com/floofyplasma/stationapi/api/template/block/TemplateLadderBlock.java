package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.LadderBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateLadderBlock extends LadderBlock implements BlockTemplate {
    public TemplateLadderBlock(Identifier identifier, int texUVStart) {
        this(BlockTemplate.getNextId(), texUVStart);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateLadderBlock(int id, int texUVStart) {
        super(id, texUVStart);
    }
}
