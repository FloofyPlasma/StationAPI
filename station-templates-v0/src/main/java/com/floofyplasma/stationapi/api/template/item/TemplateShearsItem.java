package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.ShearsItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateShearsItem extends ShearsItem implements ItemTemplate {
    public TemplateShearsItem(Identifier identifier) {
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }
    
    public TemplateShearsItem(int i) {
        super(i);
    }
}
