package com.floofyplasma.stationapi.api.client.event.network;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.Cancelable;
import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.client.network.ClientNetworkHandler;
import net.minecraft.network.packet.login.LoginHelloPacket;
import com.floofyplasma.stationapi.api.StationAPI;

@Cancelable
@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class ServerLoginSuccessEvent extends Event {
    public final ClientNetworkHandler clientNetworkHandler;
    public final LoginHelloPacket loginHelloPacket;
}
