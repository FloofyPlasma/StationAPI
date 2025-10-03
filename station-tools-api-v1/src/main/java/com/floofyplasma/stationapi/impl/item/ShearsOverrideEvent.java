package com.floofyplasma.stationapi.impl.item;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.event.EventPhases;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.item.ItemStackEvent;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class ShearsOverrideEvent extends ItemStackEvent {
    public boolean overrideShears;
}