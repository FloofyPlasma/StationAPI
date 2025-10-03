package com.floofyplasma.stationapi.impl.mod;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.mod.InitEvent;
import com.floofyplasma.stationapi.api.event.mod.PostInitEvent;
import com.floofyplasma.stationapi.api.event.mod.PreInitEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;

import java.lang.invoke.MethodHandles;

@SuppressWarnings("deprecation")
@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
public final class DeprecatedInitEventsImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener(phase = InitEvent.PRE_INIT_PHASE)
    private static void postPreInit(InitEvent event) {
        StationAPI.EVENT_BUS.post(PreInitEvent.builder().build());
    }

    @EventListener(phase = InitEvent.POST_INIT_PHASE)
    private static void postPostInit(InitEvent event) {
        StationAPI.EVENT_BUS.post(PostInitEvent.builder().build());
    }
}
