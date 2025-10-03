package com.floofyplasma.stationapi.api.block;

import net.minecraft.item.BlockItem;
import com.floofyplasma.stationapi.api.event.block.BlockItemFactoryEvent;
import com.floofyplasma.stationapi.api.template.item.MetaBlockItem;
import com.floofyplasma.stationapi.impl.block.HasMetaBlockItemImpl;

import java.util.function.IntFunction;

/**
 * Interface that pre-defines block item's factory to be {@link MetaBlockItem#MetaBlockItem(int)}
 * @author mine_diver
 * @see BlockItemFactoryEvent
 * @see CustomBlockItemFactoryProvider
 * @see HasCustomBlockItemFactory
 * @see HasMetaBlockItem
 * @see MetaNamedBlockItemProvider
 * @see HasMetaNamedBlockItem
 * @see MetaBlockItem
 */
public interface MetaBlockItemProvider extends CustomBlockItemFactoryProvider {
    /**
     * The logic implementation.
     * @return {@link MetaBlockItem#MetaBlockItem(int)}.
     */
    @Override
    default IntFunction<BlockItem> getBlockItemFactory() {
        return HasMetaBlockItemImpl.FACTORY;
    }
}
