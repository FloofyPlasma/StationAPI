package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.MushroomStewItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateMushroomStewItem extends MushroomStewItem implements ItemTemplate {
    public TemplateMushroomStewItem(Identifier identifier, int healAmount) {
        this(ItemTemplate.getNextId(), healAmount);
        ItemTemplate.onConstructor(this, identifier);
    }
    
    public TemplateMushroomStewItem(int id, int healAmount) {
        super(id, healAmount);
    }
}
