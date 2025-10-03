package com.floofyplasma.stationapi.impl.client.network;

import com.floofyplasma.stationapi.api.registry.RemapException;
import com.floofyplasma.stationapi.api.registry.RemappableRegistry;
import com.floofyplasma.stationapi.impl.network.RegistryPacketHandler;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.RemapClientRegistryS2CPacket;
import com.floofyplasma.stationapi.impl.registry.sync.RegistrySyncManager;

public class ClientRegistryNetworkHandler extends RegistryPacketHandler {
    @Override
    public boolean isServerSide() {
        return false;
    }

    @Override
    public void onRemapClientRegistry(RemapClientRegistryS2CPacket packet) {
        try {
            RegistrySyncManager.apply(packet.map, RemappableRegistry.RemapMode.REMOTE);
        } catch (RemapException e) {
            throw new RuntimeException(e);
        }
    }
}
