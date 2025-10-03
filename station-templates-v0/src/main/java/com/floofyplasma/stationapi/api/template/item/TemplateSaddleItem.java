package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.SaddleItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateSaddleItem extends SaddleItem implements ItemTemplate {
    public TemplateSaddleItem(Identifier identifier) {
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }
    
    public TemplateSaddleItem(int i) {
        super(i);
    }
}
