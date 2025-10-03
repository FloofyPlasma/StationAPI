package com.floofyplasma.stationapi.impl.block;

import com.floofyplasma.stationapi.api.block.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.item.BlockItem;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.block.*;
import com.floofyplasma.stationapi.api.event.block.BlockItemFactoryEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.template.item.MetaBlockItem;

import java.lang.invoke.MethodHandles;
import java.util.function.IntFunction;

/**
 * {@link MetaBlockItemProvider} implementation class.
 * @author mine_diver
 * @see BlockItemFactoryEvent
 * @see CustomBlockItemFactoryProvider
 * @see HasCustomBlockItemFactory
 * @see MetaBlockItemProvider
 * @see HasMetaBlockItem
 * @see MetaNamedBlockItemProvider
 * @see HasMetaNamedBlockItem
 */
@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class HasMetaBlockItemImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    /**
     * Handles block's {@link HasMetaBlockItem} annotation if it's present via {@link BlockItemFactoryEvent} hook.
     * @param event blockitemfactory callback.
     */
    @EventListener
    private static void getBlockItemFactory(BlockItemFactoryEvent event) {
        if (event.block.getClass().isAnnotationPresent(HasMetaBlockItem.class))
            event.currentFactory = FACTORY;
    }

    /**
     * {@link MetaBlockItem#MetaBlockItem(int)} field.
     */
    @SuppressWarnings("Convert2MethodRef") // Method references load their target classes, which may load Item before it should be loaded normally.
    public static final IntFunction<BlockItem> FACTORY = i -> new MetaBlockItem(i);
}
