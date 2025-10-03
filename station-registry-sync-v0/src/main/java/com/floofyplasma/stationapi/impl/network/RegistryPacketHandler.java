package com.floofyplasma.stationapi.impl.network;

import net.minecraft.network.NetworkHandler;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.RemapClientRegistryS2CPacket;

public abstract class RegistryPacketHandler extends NetworkHandler {
    public void onRemapClientRegistry(RemapClientRegistryS2CPacket packet) {
        handle(packet);
    }
}
