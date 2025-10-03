package com.floofyplasma.stationapi.api.effect;

import com.mojang.serialization.Lifecycle;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttribute;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttributeHolder;
import com.floofyplasma.stationapi.api.registry.Registries;
import com.floofyplasma.stationapi.api.registry.RegistryKey;
import com.floofyplasma.stationapi.api.registry.SimpleRegistry;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public class EntityEffectTypeRegistry extends SimpleRegistry<EntityEffectType<?>> {
    public static final RegistryKey<EntityEffectTypeRegistry> KEY = RegistryKey.ofRegistry(NAMESPACE.id("entity_effects"));
    public static final EntityEffectTypeRegistry INSTANCE = Registries.create(KEY, new EntityEffectTypeRegistry(), Lifecycle.experimental());
    
    private EntityEffectTypeRegistry() {
        super(KEY, Lifecycle.experimental(), true);
        RegistryAttributeHolder.get(this).addAttribute(RegistryAttribute.SYNCED);
    }
}
