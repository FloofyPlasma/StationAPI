package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.class_561;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateMapBaseItem extends class_561 implements ItemTemplate {
    public TemplateMapBaseItem(Identifier identifier) {
        this(ItemTemplate.getNextId());
        ItemTemplate.onConstructor(this, identifier);
    }

    public TemplateMapBaseItem(int i) {
        super(i);
    }
}
