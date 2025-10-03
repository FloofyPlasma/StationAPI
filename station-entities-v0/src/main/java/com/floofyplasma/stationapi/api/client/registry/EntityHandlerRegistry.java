package com.floofyplasma.stationapi.api.client.registry;

import com.mojang.serialization.Lifecycle;
import com.floofyplasma.stationapi.api.client.entity.factory.EntityWorldAndPosFactory;
import com.floofyplasma.stationapi.api.registry.Registries;
import com.floofyplasma.stationapi.api.registry.RegistryKey;
import com.floofyplasma.stationapi.api.registry.SimpleRegistry;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public final class EntityHandlerRegistry extends SimpleRegistry<EntityWorldAndPosFactory> {
    public static final RegistryKey<EntityHandlerRegistry> KEY = RegistryKey.ofRegistry(NAMESPACE.id("entity_handlers"));
    public static final EntityHandlerRegistry INSTANCE = Registries.create(KEY, new EntityHandlerRegistry(), Lifecycle.experimental());

    private EntityHandlerRegistry() {
        super(KEY, Lifecycle.experimental(), false);
    }
}
