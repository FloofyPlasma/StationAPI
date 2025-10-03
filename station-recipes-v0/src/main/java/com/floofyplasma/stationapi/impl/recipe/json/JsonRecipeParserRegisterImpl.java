package com.floofyplasma.stationapi.impl.recipe.json;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.mod.InitEvent;
import com.floofyplasma.stationapi.api.event.registry.JsonRecipeParserRegistryEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;

import java.lang.invoke.MethodHandles;

@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class JsonRecipeParserRegisterImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void onInitialization(InitEvent event) {
        StationAPI.EVENT_BUS.post(new JsonRecipeParserRegistryEvent());
    }
}
