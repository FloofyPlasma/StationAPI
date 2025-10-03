package com.floofyplasma.stationapi.impl.registry;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.resource.DataResourceReloaderRegisterEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.registry.ServerDynamicRegistryType;
import com.floofyplasma.stationapi.api.tag.TagManagerLoader;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class TagReloaderImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void registerTagLoader(DataResourceReloaderRegisterEvent event) {
        event.resourceManager.registerReloader(new TagManagerLoader(ServerDynamicRegistryType.createCombinedDynamicRegistries().getPrecedingRegistryManagers(ServerDynamicRegistryType.RELOADABLE)));
    }
}
