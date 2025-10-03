package com.floofyplasma.stationapi.impl.network;

import net.minecraft.network.NetworkHandler;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.StationEntityEquipmentUpdateS2CPacket;
import com.floofyplasma.stationapi.impl.network.packet.s2c.play.StationItemEntitySpawnS2CPacket;

public abstract class StationItemsNetworkHandler extends NetworkHandler {
    public void onItemEntitySpawn(StationItemEntitySpawnS2CPacket packet) {
        handle(packet);
    }

    public void onEntityEquipmentUpdate(StationEntityEquipmentUpdateS2CPacket packet) {
        handle(packet);
    }
}
