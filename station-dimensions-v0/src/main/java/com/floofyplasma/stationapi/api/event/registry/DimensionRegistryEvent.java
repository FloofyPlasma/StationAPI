package com.floofyplasma.stationapi.api.event.registry;

import net.mine_diver.unsafeevents.event.EventPhases;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.registry.DimensionContainer;
import com.floofyplasma.stationapi.api.registry.DimensionRegistry;

@EventPhases(StationAPI.INTERNAL_PHASE)
public class DimensionRegistryEvent extends RegistryEvent.EntryTypeBound<DimensionContainer<?>, DimensionRegistry> {
    public DimensionRegistryEvent() {
        super(DimensionRegistry.INSTANCE);
    }
}
