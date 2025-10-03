package com.floofyplasma.sltest.keyboard;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.sltest.SLTest;
import com.floofyplasma.sltest.option.OptionListener;
import com.floofyplasma.stationapi.api.client.event.keyboard.KeyStateChangedEvent;
import com.floofyplasma.stationapi.api.network.packet.MessagePacket;
import com.floofyplasma.stationapi.api.network.packet.PacketHelper;
import com.floofyplasma.stationapi.api.util.Identifier;
import org.lwjgl.input.Keyboard;

public class KeyboardListener {

    @EventListener
    public static void keyStateChange(KeyStateChangedEvent event) {
        if (event.environment == KeyStateChangedEvent.Environment.IN_GAME && Keyboard.getEventKey() == OptionListener.testBind.code)
            PacketHelper.send(new MessagePacket(Identifier.of(SLTest.NAMESPACE, "give_me_diamonds")));
    }
}
