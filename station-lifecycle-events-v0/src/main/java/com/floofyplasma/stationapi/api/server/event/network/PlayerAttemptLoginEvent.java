package com.floofyplasma.stationapi.api.server.event.network;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.network.packet.login.LoginHelloPacket;
import net.minecraft.server.network.ServerLoginNetworkHandler;
import com.floofyplasma.stationapi.api.StationAPI;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class PlayerAttemptLoginEvent extends Event {
    public final ServerLoginNetworkHandler serverLoginNetworkHandler;
    public final LoginHelloPacket loginHelloPacket;
}
