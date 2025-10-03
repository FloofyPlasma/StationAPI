package com.floofyplasma.stationapi.api.event.registry;

import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.api.registry.RegistryKey;
import com.floofyplasma.stationapi.impl.registry.sync.RegistryAttributeImpl;

public interface RegistryAttributeHolder {
    static RegistryAttributeHolder get(RegistryKey<?> registryKey) {
        return RegistryAttributeImpl.getHolder(registryKey);
    }

    static RegistryAttributeHolder get(Registry<?> registry) {
        return get(registry.getKey());
    }

    RegistryAttributeHolder addAttribute(RegistryAttribute attribute);

    boolean hasAttribute(RegistryAttribute attribute);
}