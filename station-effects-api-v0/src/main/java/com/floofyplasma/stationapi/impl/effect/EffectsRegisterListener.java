package com.floofyplasma.stationapi.impl.effect;

import com.floofyplasma.stationapi.impl.effect.packet.*;
import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.effect.EntityEffectTypeRegistryEvent;
import com.floofyplasma.stationapi.api.event.network.packet.PacketRegisterEvent;
import com.floofyplasma.stationapi.api.event.registry.AfterBlockAndItemRegisterEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.registry.PacketTypeRegistry;
import com.floofyplasma.stationapi.api.registry.Registry;
import net.modificationstation.stationapi.impl.effect.packet.*;

import java.lang.invoke.MethodHandles;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
public class EffectsRegisterListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void onInit(AfterBlockAndItemRegisterEvent event) {
        StationAPI.EVENT_BUS.post(new EntityEffectTypeRegistryEvent());
    }

    @EventListener(phase = StationAPI.INTERNAL_PHASE)
    private static void registerPackets(PacketRegisterEvent event) {
        Registry.register(PacketTypeRegistry.INSTANCE, NAMESPACE)
                .accept("effects/effect_add", EffectAddS2CPacket.TYPE)
                .accept("effects/effect_remove", EffectRemoveS2CPacket.TYPE)
                .accept("effects/effect_remove_all", EffectRemoveAllS2CPacket.TYPE)
                .accept("effects/send_all_effects", SendAllEffectsS2CPacket.TYPE)
                .accept("effects/send_all_effects_player", SendAllEffectsPlayerS2CPacket.TYPE);
    }
}
