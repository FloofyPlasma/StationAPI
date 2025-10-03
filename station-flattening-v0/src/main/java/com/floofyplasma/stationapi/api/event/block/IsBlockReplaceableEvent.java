package com.floofyplasma.stationapi.api.event.block;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import com.floofyplasma.stationapi.api.item.ItemPlacementContext;

@SuperBuilder
public class IsBlockReplaceableEvent extends Event {
    public final ItemPlacementContext context;
}
