package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.block.Block;
import net.minecraft.item.SecondaryBlockItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSecondaryBlockItem extends SecondaryBlockItem implements ItemTemplate {
    public TemplateSecondaryBlockItem(Identifier identifier, Block tile) {
        this(ItemTemplate.getNextId(), tile);
        ItemTemplate.onConstructor(this, identifier);
    }

    public TemplateSecondaryBlockItem(int id, Block tile) {
        super(id, tile);
    }
}
