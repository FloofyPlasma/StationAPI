package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.FlowingLiquidBlock;
import net.minecraft.block.Material;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateFlowingLiquidBlock extends FlowingLiquidBlock implements BlockTemplate {
    public TemplateFlowingLiquidBlock(Identifier identifier, Material material) {
        this(BlockTemplate.getNextId(), material);
        BlockTemplate.onConstructor(this, identifier);
    }

    public TemplateFlowingLiquidBlock(int i, Material arg) {
        super(i, arg);
    }
}
