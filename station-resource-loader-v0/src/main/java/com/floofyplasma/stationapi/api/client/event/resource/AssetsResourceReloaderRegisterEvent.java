package com.floofyplasma.stationapi.api.client.event.resource;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.resource.ReloadableAssetsManager;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class AssetsResourceReloaderRegisterEvent extends Event {
    public final ReloadableAssetsManager resourceManager;
}
