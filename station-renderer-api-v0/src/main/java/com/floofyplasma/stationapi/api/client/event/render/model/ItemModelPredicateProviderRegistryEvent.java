package com.floofyplasma.stationapi.api.client.event.render.model;

import com.floofyplasma.stationapi.api.client.model.item.ItemModelPredicateProvider;
import com.floofyplasma.stationapi.api.client.registry.ItemModelPredicateProviderRegistry;
import com.floofyplasma.stationapi.api.event.registry.RegistryEvent;

public class ItemModelPredicateProviderRegistryEvent extends RegistryEvent.EntryTypeBound<ItemModelPredicateProvider, ItemModelPredicateProviderRegistry> {
    public ItemModelPredicateProviderRegistryEvent() {
        super(ItemModelPredicateProviderRegistry.INSTANCE);
    }
}
