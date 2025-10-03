package com.floofyplasma.stationapi.impl.client.network;

import net.fabricmc.loader.api.FabricLoader;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.gui.screen.GuiHandler;
import com.floofyplasma.stationapi.api.client.registry.GuiHandlerRegistry;
import com.floofyplasma.stationapi.api.event.registry.GuiHandlerRegistryEvent;
import com.floofyplasma.stationapi.api.event.registry.MessageListenerRegistryEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.network.packet.MessagePacket;
import com.floofyplasma.stationapi.api.util.Identifier;

import java.lang.invoke.MethodHandles;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class GuiClientNetworkHandler {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void registerMessageListeners(MessageListenerRegistryEvent event) {
        event.register(NAMESPACE.id("open_gui"), GuiClientNetworkHandler::handleGui);
        StationAPI.EVENT_BUS.post(new GuiHandlerRegistryEvent());
    }

    private static void handleGui(PlayerEntity player, MessagePacket message) {
        boolean isClient = player.world.isRemote;
        GuiHandler guiHandler = GuiHandlerRegistry.INSTANCE.get(Identifier.of(message.strings[0]));
        if (guiHandler != null)
            //noinspection deprecation
            ((Minecraft) FabricLoader.getInstance().getGameInstance()).setScreen(guiHandler.screenFactory().create(player, isClient ? guiHandler.inventoryFactory().create() : (Inventory) message.objects[0], message));
        if (isClient)
            player.container.syncId = message.ints[0];
    }
}
