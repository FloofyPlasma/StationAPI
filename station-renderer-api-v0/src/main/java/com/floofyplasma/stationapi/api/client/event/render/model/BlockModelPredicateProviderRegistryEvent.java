package com.floofyplasma.stationapi.api.client.event.render.model;

import com.floofyplasma.stationapi.api.client.model.block.BlockModelPredicateProvider;
import com.floofyplasma.stationapi.api.client.registry.BlockModelPredicateProviderRegistry;
import com.floofyplasma.stationapi.api.event.registry.RegistryEvent;

public final class BlockModelPredicateProviderRegistryEvent extends RegistryEvent.EntryTypeBound<BlockModelPredicateProvider, BlockModelPredicateProviderRegistry> {
    public BlockModelPredicateProviderRegistryEvent() {
        super(BlockModelPredicateProviderRegistry.INSTANCE);
    }
}
