package com.floofyplasma.stationapi.api.event.registry;

import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.item.Item;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.registry.ItemRegistry;

@EventPhases(StationAPI.INTERNAL_PHASE)
public class ItemRegistryEvent extends RegistryEvent.EntryTypeBound<Item, ItemRegistry> {
    public ItemRegistryEvent() {
        super(ItemRegistry.INSTANCE);
    }
}
