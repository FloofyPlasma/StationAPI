package com.floofyplasma.stationapi.impl.client.resource;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.event.resource.AssetsReloadEvent;
import com.floofyplasma.stationapi.api.client.event.resource.TexturePackLoadedEvent;
import com.floofyplasma.stationapi.api.client.resource.ReloadScreenManager;
import com.floofyplasma.stationapi.api.client.resource.ReloadableAssetsManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.resource.CompositeResourceReload;
import com.floofyplasma.stationapi.api.util.Unit;
import com.floofyplasma.stationapi.api.util.Util;
import com.floofyplasma.stationapi.impl.resource.DefaultResourcePackProvider;
import com.floofyplasma.stationapi.impl.resource.ResourcePackManager;
import com.floofyplasma.stationapi.impl.resource.TexturePackProvider;
import com.floofyplasma.stationapi.impl.resource.loader.ModResourcePackCreator;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class AssetsReloaderImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    public static final ResourcePackManager RESOURCE_PACK_MANAGER = new ResourcePackManager(
            new DefaultResourcePackProvider(),
            ModResourcePackCreator.CLIENT_RESOURCE_PACK_PROVIDER,
            new TexturePackProvider()
    );
    public static final CompletableFuture<Unit> COMPLETED_UNIT_FUTURE = CompletableFuture.completedFuture(Unit.INSTANCE);

    @EventListener
    private static void reload(TexturePackLoadedEvent.After event) {
        StationAPI.EVENT_BUS.post(AssetsReloadEvent.builder().build());
    }

    @EventListener
    private static void reloadResourceManager(final AssetsReloadEvent event) {
        RESOURCE_PACK_MANAGER.scanPacks();
        if (ReloadScreenManager.getCurrentReload().isEmpty())
            ReloadScreenManager.open();
        ReloadScreenManager.getCurrentReload()
                .flatMap(reload1 -> reload1 instanceof CompositeResourceReload composite ? Optional.of(composite) : Optional.empty())
                .ifPresent(manager -> manager.scheduleReload(
                        NAMESPACE.id("assets"),
                        () -> ReloadableAssetsManager.INSTANCE.reload(
                                Util.getMainWorkerExecutor(),
                                ReloadScreenManager.getApplicationExecutor(),
                                AssetsReloaderImpl.COMPLETED_UNIT_FUTURE,
                                ReloadScreenManager::pushLocation,
                                RESOURCE_PACK_MANAGER.createResourcePacks()
                        )
                ));
    }
}
