package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.Item;
import com.floofyplasma.stationapi.api.registry.ItemRegistry;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.api.util.Identifier;

public interface ItemTemplate {
    static int getNextId() {
        return ItemRegistry.AUTO_ID;
    }

    static void onConstructor(Item item, Identifier id) {
        Registry.register(ItemRegistry.INSTANCE, item.id, id, item);
    }
}
