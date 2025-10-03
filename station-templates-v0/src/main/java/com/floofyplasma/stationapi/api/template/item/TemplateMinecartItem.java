package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.MinecartItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateMinecartItem extends MinecartItem implements ItemTemplate {
    public TemplateMinecartItem(Identifier identifier, int j) {
        this(ItemTemplate.getNextId(), j);
        ItemTemplate.onConstructor(this, identifier);
    }
    
    public TemplateMinecartItem(int i, int j) {
        super(i, j);
    }
}
