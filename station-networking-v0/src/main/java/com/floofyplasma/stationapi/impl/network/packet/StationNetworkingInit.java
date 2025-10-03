package com.floofyplasma.stationapi.impl.network.packet;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.network.packet.PacketRegisterEvent;
import com.floofyplasma.stationapi.api.event.registry.MessageListenerRegistryEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class StationNetworkingInit {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void registerPackets(PacketRegisterEvent event) {
        StationAPI.EVENT_BUS.post(new MessageListenerRegistryEvent());
    }
}
