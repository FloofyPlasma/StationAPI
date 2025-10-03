package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.MusicDiscItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateMusicDiscItem extends MusicDiscItem implements ItemTemplate {
    public TemplateMusicDiscItem(Identifier identifier, String title) {
        this(ItemTemplate.getNextId(), title);
        ItemTemplate.onConstructor(this, identifier);
    }

    public TemplateMusicDiscItem(int id, String title) {
        super(id, title);
    }
}
