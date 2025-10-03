package com.floofyplasma.stationapi.impl.item;

import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.item.tool.StationTool;
import com.floofyplasma.stationapi.api.item.tool.ToolLevel;
import com.floofyplasma.stationapi.api.registry.BlockRegistry;
import com.floofyplasma.stationapi.api.registry.ItemRegistry;
import com.floofyplasma.stationapi.api.util.Namespace;

import java.util.Objects;

public class ToolEffectivenessImpl {
    public static boolean shouldApplyCustomLogic(ItemStack item, BlockState state) {
        // 1. Disable custom tool logic if both the block and the tool are vanilla
        // This is done to preserve the vanilla mining speeds
        // 2. Disable custom tool logic if the tool doesn't provide its tool type tag
        // This is done to allow tools to handle suitability and speed the vanilla way
        return (Objects.requireNonNull(ItemRegistry.INSTANCE.getId(item.getItem())).namespace != Namespace.MINECRAFT
                || Objects.requireNonNull(BlockRegistry.INSTANCE.getId(state.getBlock())).namespace != Namespace.MINECRAFT)
                && (!(item.getItem() instanceof StationTool stationTool)
                || stationTool.getEffectiveBlocks(item) != null);
    }

    public static boolean isSuitableFor(ItemStack item, BlockState state) {
        return item.getItem() instanceof StationTool stationTool
                && state.isIn(stationTool.getEffectiveBlocks(item))
                && ToolLevel.isSuitable(stationTool.getMaterial(item).getToolLevel(), state);
    }

    public static float getMiningSpeedMultiplier(ItemStack item) {
        return ((StationTool) item.getItem()).getMaterial(item).getMiningSpeedMultiplier();
    }
}
