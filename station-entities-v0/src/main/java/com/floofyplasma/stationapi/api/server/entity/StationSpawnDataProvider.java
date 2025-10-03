package com.floofyplasma.stationapi.api.server.entity;

import com.floofyplasma.stationapi.api.network.packet.MessagePacket;
import com.floofyplasma.stationapi.api.util.Identifier;

public interface StationSpawnDataProvider extends CustomSpawnDataProvider {

    Identifier getHandlerIdentifier();

    default void writeToMessage(MessagePacket message) { }

    default void readFromMessage(MessagePacket message) { }
}
