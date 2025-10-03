package com.floofyplasma.stationapi.impl.server.registry;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtIo;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.network.ModdedPacketHandler;
import com.floofyplasma.stationapi.api.network.packet.MessagePacket;
import com.floofyplasma.stationapi.api.network.packet.PacketHelper;
import com.floofyplasma.stationapi.api.registry.legacy.WorldLegacyRegistry;
import com.floofyplasma.stationapi.api.server.event.network.PlayerPacketHandlerSetEvent;

import java.io.ByteArrayOutputStream;
import java.lang.invoke.MethodHandles;

import static com.floofyplasma.stationapi.api.StationAPI.LOGGER;
import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;
import static com.floofyplasma.stationapi.api.util.Identifier.of;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class ServerRegistrySender {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void sendWorldRegistry(PlayerPacketHandlerSetEvent event) {
        if (((ModdedPacketHandler) event.player.field_255).isModded()) {
            LOGGER.info("Sending level registries to \"" + event.player.name + "\"...");
            NbtCompound registries = new NbtCompound();
            WorldLegacyRegistry.saveAll(registries);
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            NbtIo.writeCompressed(registries, byteOutputStream);
            MessagePacket message = new MessagePacket(of(NAMESPACE, "server_registry_sync"));
            message.bytes = byteOutputStream.toByteArray();
            PacketHelper.sendTo(event.player, message);
        }
    }
}
