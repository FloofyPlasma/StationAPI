package com.floofyplasma.stationapi.api.event.registry;

import com.floofyplasma.stationapi.api.client.gui.screen.GuiHandler;
import com.floofyplasma.stationapi.api.client.registry.GuiHandlerRegistry;

public class GuiHandlerRegistryEvent extends RegistryEvent.EntryTypeBound<GuiHandler, GuiHandlerRegistry> {
    public GuiHandlerRegistryEvent() {
        super(GuiHandlerRegistry.INSTANCE);
    }
}
