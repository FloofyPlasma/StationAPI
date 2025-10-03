package com.floofyplasma.stationapi.api.client.registry;

import com.mojang.serialization.Lifecycle;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.gui.screen.GuiHandler;
import com.floofyplasma.stationapi.api.registry.Registries;
import com.floofyplasma.stationapi.api.registry.RegistryKey;
import com.floofyplasma.stationapi.api.registry.SimpleRegistry;
import com.floofyplasma.stationapi.api.util.Identifier;

public final class GuiHandlerRegistry extends SimpleRegistry<GuiHandler> {
    public static final RegistryKey<GuiHandlerRegistry> KEY = RegistryKey.ofRegistry(Identifier.of(StationAPI.NAMESPACE, "gui_handlers"));
    public static final GuiHandlerRegistry INSTANCE = Registries.create(KEY, new GuiHandlerRegistry(), Lifecycle.experimental());

    private GuiHandlerRegistry() {
        super(KEY, Lifecycle.experimental(), false);
    }
}
