package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplatePickaxeItem extends PickaxeItem implements ItemTemplate {
    public TemplatePickaxeItem(Identifier identifier, ToolMaterial material) {
        this(ItemTemplate.getNextId(), material);
        ItemTemplate.onConstructor(this, identifier);
    }
    
    public TemplatePickaxeItem(int id, ToolMaterial material) {
        super(id, material);
    }
}
