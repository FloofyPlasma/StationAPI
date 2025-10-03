package com.floofyplasma.sltest.block;

import net.minecraft.block.Material;
import com.floofyplasma.sltest.item.IndispensableBlockItem;
import com.floofyplasma.stationapi.api.block.HasCustomBlockItemFactory;
import com.floofyplasma.stationapi.api.template.block.TemplateBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

@HasCustomBlockItemFactory(IndispensableBlockItem.class)
public class IndispensableBlock extends TemplateBlock {
    public IndispensableBlock(Identifier identifier) {
        super(identifier, Material.WOOD);
    }
}
