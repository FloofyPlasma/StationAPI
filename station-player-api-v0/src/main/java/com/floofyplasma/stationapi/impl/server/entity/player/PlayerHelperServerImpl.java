package com.floofyplasma.stationapi.impl.server.entity.player;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.NetworkHandler;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import com.floofyplasma.stationapi.impl.entity.player.PlayerHelperImpl;
import com.floofyplasma.stationapi.mixin.player.server.ServerPlayNetworkHandlerAccessor;

public class PlayerHelperServerImpl extends PlayerHelperImpl {

    @Override
    public PlayerEntity getPlayerFromGame() {
        return null;
    }

    @Override
    public PlayerEntity getPlayerFromPacketHandler(NetworkHandler packetHandler) {
        return packetHandler instanceof ServerPlayNetworkHandler ? ((ServerPlayNetworkHandlerAccessor) packetHandler).getField_920() : getPlayerFromGame();
    }
}
