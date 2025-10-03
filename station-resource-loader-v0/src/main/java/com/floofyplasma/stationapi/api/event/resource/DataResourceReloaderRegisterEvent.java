package com.floofyplasma.stationapi.api.event.resource;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.resource.DataManager;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class DataResourceReloaderRegisterEvent extends Event {
    public final DataManager resourceManager;
}
