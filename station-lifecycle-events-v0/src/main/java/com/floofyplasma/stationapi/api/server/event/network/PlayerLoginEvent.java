package com.floofyplasma.stationapi.api.server.event.network;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.packet.login.LoginHelloPacket;

@SuperBuilder
public class PlayerLoginEvent extends Event {
    public final LoginHelloPacket loginHelloPacket;
    public final ServerPlayerEntity player;
}
