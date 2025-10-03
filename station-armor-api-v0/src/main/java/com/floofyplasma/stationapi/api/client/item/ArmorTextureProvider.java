package com.floofyplasma.stationapi.api.client.item;

import net.minecraft.item.ArmorItem;
import com.floofyplasma.stationapi.api.util.Identifier;

public interface ArmorTextureProvider {
    Identifier getTexture(ArmorItem armor);
}
