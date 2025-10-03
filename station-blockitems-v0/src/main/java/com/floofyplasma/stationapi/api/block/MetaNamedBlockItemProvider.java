package com.floofyplasma.stationapi.api.block;

import net.minecraft.item.BlockItem;
import com.floofyplasma.stationapi.api.event.block.BlockItemFactoryEvent;
import com.floofyplasma.stationapi.api.template.item.MetaNamedBlockItem;
import com.floofyplasma.stationapi.impl.block.HasMetaNamedBlockItemImpl;

import java.util.function.IntFunction;

/**
 * Interface that pre-defines block item's factory to be {@link MetaNamedBlockItem#MetaNamedBlockItem(int)}
 * @author mine_diver
 * @see BlockItemFactoryEvent
 * @see CustomBlockItemFactoryProvider
 * @see HasCustomBlockItemFactory
 * @see MetaBlockItemProvider
 * @see HasMetaBlockItem
 * @see HasMetaNamedBlockItem
 * @see MetaNamedBlockItem
 */
public interface MetaNamedBlockItemProvider extends CustomBlockItemFactoryProvider {
    /**
     * The logic implementation.
     * @return {@link MetaNamedBlockItem#MetaNamedBlockItem(int)}.
     */
    @Override
    default IntFunction<BlockItem> getBlockItemFactory() {
        return HasMetaNamedBlockItemImpl.FACTORY;
    }

    default int[] getValidMetas() {
        return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
    }
}
