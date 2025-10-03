package com.floofyplasma.stationapi.api.server.entity;

import net.minecraft.network.packet.Packet;

public interface CustomSpawnDataProvider {

    Packet getSpawnData();
}
