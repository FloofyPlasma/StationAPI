package com.floofyplasma.stationapi.impl.registry;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.nbt.NbtCompound;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.world.WorldPropertiesEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.registry.legacy.WorldLegacyRegistry;

import java.lang.invoke.MethodHandles;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;
import static com.floofyplasma.stationapi.api.util.Identifier.of;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class WorldRegistryRemapper {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void saveProperties(WorldPropertiesEvent.Save event) {
        NbtCompound registriesTag = new NbtCompound();
        WorldLegacyRegistry.saveAll(registriesTag);
        event.nbt.put(of(NAMESPACE, "level_serial_registries").toString(), registriesTag);
    }

    @EventListener
    private static void loadProperties(WorldPropertiesEvent.LoadOnWorldInit event) {
        String lsr = of(NAMESPACE, "level_serial_registries").toString();
        if (event.nbt.contains(lsr))
            WorldLegacyRegistry.loadAll(event.nbt.getCompound(lsr));
    }
}
