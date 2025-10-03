package com.floofyplasma.stationapi.api.registry;

import com.mojang.serialization.Lifecycle;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttribute;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttributeHolder;
import com.floofyplasma.stationapi.api.network.packet.PacketType;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public final class PacketTypeRegistry extends SimpleRegistry<PacketType<?>> {
    public static final RegistryKey<Registry<PacketType<?>>> KEY = RegistryKey.ofRegistry(NAMESPACE.id("packet_types"));
    public static final Registry<PacketType<?>> INSTANCE = Registries.create(KEY, new PacketTypeRegistry(), Lifecycle.experimental());

    private PacketTypeRegistry() {
        super(KEY, Lifecycle.experimental(), true);
        RegistryAttributeHolder.get(this).addAttribute(RegistryAttribute.SYNCED);
    }
}
