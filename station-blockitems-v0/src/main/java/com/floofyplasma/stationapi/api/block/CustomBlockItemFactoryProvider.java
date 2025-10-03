package com.floofyplasma.stationapi.api.block;

import net.minecraft.item.BlockItem;
import com.floofyplasma.stationapi.api.event.block.BlockItemFactoryEvent;

import java.util.function.IntFunction;

/**
 * Interface that blocks can use to provide a custom block item factory on register via {@link BlockItemFactoryEvent} hook.
 * @author mine_diver
 * @see BlockItemFactoryEvent
 * @see HasCustomBlockItemFactory
 * @see MetaBlockItemProvider
 * @see HasMetaBlockItem
 * @see MetaNamedBlockItemProvider
 * @see HasMetaNamedBlockItem
 */
public interface CustomBlockItemFactoryProvider {
    /**
     * BlockItem factory supplier method.
     * @return the {@link IntFunction} instance that'll be executed to get block item's instance.
     */
    IntFunction<BlockItem> getBlockItemFactory();
}
