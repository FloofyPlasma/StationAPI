package com.floofyplasma.stationapi.api.registry;

import com.mojang.serialization.Lifecycle;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.item.Item;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttribute;
import com.floofyplasma.stationapi.api.event.registry.RegistryAttributeHolder;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public final class ItemRegistry extends SimpleRegistry<Item> {

    public static final RegistryKey<Registry<Item>> KEY = RegistryKey.ofRegistry(NAMESPACE.id("items"));
    public static final ItemRegistry INSTANCE = Registries.create(KEY, new ItemRegistry(), Lifecycle.experimental());
    public static final int ID_SHIFT = 256;
    public static final Int2IntFunction SHIFTED_ID = id -> id - ID_SHIFT;
    public static final int AUTO_ID = SHIFTED_ID.get(Registry.AUTO_ID);

    private ItemRegistry() {
        super(KEY, Lifecycle.experimental(), true);
        RegistryAttributeHolder.get(this).addAttribute(RegistryAttribute.SYNCED);
    }
}
