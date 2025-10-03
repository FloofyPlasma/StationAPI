package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.RedstoneItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateRedstoneItem extends RedstoneItem implements ItemTemplate {
    public TemplateRedstoneItem(Identifier identifier) {
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }
    
    public TemplateRedstoneItem(int i) {
        super(i);
    }
}
