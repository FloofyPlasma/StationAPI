package com.floofyplasma.stationapi.api.event.registry;

import com.floofyplasma.stationapi.api.client.entity.factory.EntityWorldAndPosFactory;
import com.floofyplasma.stationapi.api.client.registry.EntityHandlerRegistry;

public class EntityHandlerRegistryEvent extends RegistryEvent.EntryTypeBound<EntityWorldAndPosFactory, EntityHandlerRegistry> {
    public EntityHandlerRegistryEvent() {
        super(EntityHandlerRegistry.INSTANCE);
    }
}
