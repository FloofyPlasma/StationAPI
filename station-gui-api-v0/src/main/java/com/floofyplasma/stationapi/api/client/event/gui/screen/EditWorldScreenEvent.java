package com.floofyplasma.stationapi.api.client.event.gui.screen;

import com.google.common.collect.ImmutableList;
import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.gui.screen.EditWorldScreen;
import com.floofyplasma.stationapi.api.client.gui.widget.ButtonWidgetDeferredDetachedContext;

@SuperBuilder
public abstract class EditWorldScreenEvent extends Event {
    @SuperBuilder
    @EventPhases(StationAPI.INTERNAL_PHASE)
    public static class ScrollableButtonContextRegister extends EditWorldScreenEvent {
        public final ImmutableList.Builder<ButtonWidgetDeferredDetachedContext<EditWorldScreen>> contexts;
    }
}
