package com.floofyplasma.stationapi.impl.client.gui.screen.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandler;
import com.floofyplasma.stationapi.api.network.packet.MessagePacket;
import com.floofyplasma.stationapi.impl.gui.screen.container.GuiHelperImpl;

public class GuiHelperClientImpl extends GuiHelperImpl {

    @Override
    protected void sideDependentPacket(PlayerEntity player, Inventory inventory, MessagePacket message) {
        message.objects = new Object[] { inventory };
    }

    @Override
    protected void afterPacketSent(PlayerEntity player, ScreenHandler container) {

    }
}
