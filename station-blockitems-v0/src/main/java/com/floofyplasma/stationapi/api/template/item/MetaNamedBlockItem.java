package com.floofyplasma.stationapi.api.template.item;

import net.minecraft.item.ItemStack;

public class MetaNamedBlockItem extends MetaBlockItem {
    public MetaNamedBlockItem(int i) {
        super(i);
    }

    // Removed as I believe items do not store their individual durability like this - FloofyPlasma
    /*
    @Override
    public String getTranslationKey(ItemStack item) {
        return getTranslationKey() + item.getDamage();
    }
     */
}
