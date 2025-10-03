package com.floofyplasma.stationapi.impl.server.registry;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.server.event.network.PlayerPacketHandlerSetEvent;
import com.floofyplasma.stationapi.impl.registry.sync.RegistrySyncManager;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class ServerRegistrySynchronizer {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void sendWorldRegistry(PlayerPacketHandlerSetEvent event) {
        // only StAPI clients can join StAPI servers anyway, at least at the moment
//        if (((ModdedPacketHandler) event.player.field_255).isModded())
        RegistrySyncManager.configureClient(event.player);
    }
}
