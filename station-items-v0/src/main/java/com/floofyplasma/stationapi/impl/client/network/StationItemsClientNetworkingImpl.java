package com.floofyplasma.stationapi.impl.client.network;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.network.NetworkHandler;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.StationEntityEquipmentUpdateS2CPacket;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.StationItemEntitySpawnS2CPacket;

public class StationItemsClientNetworkingImpl implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        NetworkHandler handler = new StationItemsClientNetworkHandler();
        StationItemEntitySpawnS2CPacket.TYPE.setHandler(handler);
        StationEntityEquipmentUpdateS2CPacket.TYPE.setHandler(handler);
    }
}
