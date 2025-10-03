package com.floofyplasma.stationapi.impl.network;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.network.packet.PacketRegisterEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.registry.PacketTypeRegistry;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.RemapClientRegistryS2CPacket;

import java.lang.invoke.MethodHandles;

import static net.mine_diver.unsafeevents.listener.ListenerPriority.HIGH;
import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE, priority = HIGH)
public final class RegistryNetworkingInit {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void onInitialize(PacketRegisterEvent event) {
        Registry.register(PacketTypeRegistry.INSTANCE, NAMESPACE.id("registry/remap_client"), RemapClientRegistryS2CPacket.TYPE);
    }
}
