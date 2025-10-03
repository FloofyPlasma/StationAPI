package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.MapItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateMapItem extends MapItem implements ItemTemplate {
    public TemplateMapItem(Identifier identifier) {
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }

    public TemplateMapItem(int i) {
        super(i);
    }
}
