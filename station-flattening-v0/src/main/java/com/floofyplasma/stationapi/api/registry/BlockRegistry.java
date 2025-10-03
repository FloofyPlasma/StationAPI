package com.floofyplasma.stationapi.api.registry;

import com.mojang.serialization.Lifecycle;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttribute;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttributeHolder;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public final class BlockRegistry extends SimpleRegistry<Block> {

    public static final RegistryKey<Registry<Block>> KEY = RegistryKey.ofRegistry(NAMESPACE.id("blocks"));
    public static final BlockRegistry INSTANCE = Registries.create(KEY, new BlockRegistry(), Lifecycle.experimental());

    private BlockRegistry() {
        super(KEY, Lifecycle.experimental(), true);
        RegistryAttributeHolder.get(this).addAttribute(RegistryAttribute.SYNCED);
        nextId = 256;
    }
}
