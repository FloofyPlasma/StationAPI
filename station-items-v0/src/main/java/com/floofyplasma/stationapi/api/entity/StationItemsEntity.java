package com.floofyplasma.stationapi.api.entity;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationItemsEntity {
    @Environment(EnvType.CLIENT)
    default void equipStack(int slot, ItemStack stack) {
        Util.assertImpl();
    }
}
