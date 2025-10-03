package com.floofyplasma.stationapi.api.item.tool;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import com.floofyplasma.stationapi.api.tag.TagKey;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationToolItem extends StationTool {
    @Override
    default void setEffectiveBlocks(TagKey<Block> effectiveBlocks) {
        Util.assertImpl();
    }

    @Override
    default TagKey<Block> getEffectiveBlocks(ItemStack stack) {
        return Util.assertImpl();
    }

    @Override
    default ToolMaterial getMaterial(ItemStack stack) {
        return Util.assertImpl();
    }
}
