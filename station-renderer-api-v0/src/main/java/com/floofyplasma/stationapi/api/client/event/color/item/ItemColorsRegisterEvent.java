package com.floofyplasma.stationapi.api.client.event.color.item;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import com.floofyplasma.stationapi.api.client.color.block.BlockColors;
import com.floofyplasma.stationapi.api.client.color.item.ItemColors;

@SuperBuilder
public class ItemColorsRegisterEvent extends Event {
    public final BlockColors blockColors;
    public final ItemColors itemColors;
}
