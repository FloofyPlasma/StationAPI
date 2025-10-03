package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.Item;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateItem extends Item implements ItemTemplate {
    public TemplateItem(Identifier identifier) {
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }

    public TemplateItem(int id) {
        super(id);
    }
}
