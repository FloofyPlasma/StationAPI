package com.floofyplasma.stationapi.api.server.event.network;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.entity.player.ServerPlayerEntity;
import com.floofyplasma.stationapi.api.StationAPI;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class PlayerPacketHandlerSetEvent extends Event {
    public final ServerPlayerEntity player;
}
