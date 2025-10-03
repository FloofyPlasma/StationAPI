package com.floofyplasma.stationapi.impl.client.registry;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.event.network.MultiplayerLogoutEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.registry.RemapException;
import com.floofyplasma.stationapi.impl.registry.sync.RegistrySyncManager;

import java.lang.invoke.MethodHandles;

@Environment(EnvType.CLIENT)
@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class ClientRegistryRestorer {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @Environment(EnvType.CLIENT)
    @EventListener
    private static void onDisconnect(MultiplayerLogoutEvent event) throws RemapException {
        RegistrySyncManager.unmap();
    }
}
