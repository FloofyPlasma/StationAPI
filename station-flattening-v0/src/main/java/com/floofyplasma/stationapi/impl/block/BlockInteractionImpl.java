package com.floofyplasma.stationapi.impl.block;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.block.BeforeBlockRemoved;
import com.floofyplasma.stationapi.api.event.block.BlockEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class BlockInteractionImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void beforeBlockRemoved(BlockEvent.BeforeRemoved event) {
        if (event.block instanceof BeforeBlockRemoved listener) listener.beforeBlockRemoved(event.world, event.x, event.y, event.z);
    }
}
