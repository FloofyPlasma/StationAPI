package com.floofyplasma.stationapi.impl.network.packet;

import net.fabricmc.api.ModInitializer;
import com.floofyplasma.stationapi.api.network.packet.ManagedPacket;
import com.floofyplasma.stationapi.api.network.packet.MessagePacket;
import com.floofyplasma.stationapi.api.registry.PacketTypeRegistry;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.mixin.network.AbstractPacketAccessor;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public class StationNetworkingImpl implements ModInitializer {
    @Override
    public void onInitialize() {
        // Avoid side checks for IdentifiablePacket by numerical ID
        AbstractPacketAccessor.getClientBoundPackets().add(ManagedPacket.PACKET_ID);
        AbstractPacketAccessor.getServerBoundPackets().add(ManagedPacket.PACKET_ID);

        Registry.register(PacketTypeRegistry.INSTANCE, NAMESPACE.id("message"), MessagePacket.TYPE);
    }
}
