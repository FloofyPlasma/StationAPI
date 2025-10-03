package com.floofyplasma.stationapi.impl.resource;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.resource.ReloadScreenManager;
import com.floofyplasma.stationapi.api.event.resource.DataReloadEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.resource.CompositeResourceReload;
import com.floofyplasma.stationapi.api.resource.DataManager;
import com.floofyplasma.stationapi.api.resource.ResourceReload;
import com.floofyplasma.stationapi.api.resource.ResourceType;
import com.floofyplasma.stationapi.api.util.Unit;
import com.floofyplasma.stationapi.api.util.Util;
import com.floofyplasma.stationapi.impl.resource.loader.ModResourcePackCreator;

import java.lang.invoke.MethodHandles;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

import static net.mine_diver.unsafeevents.listener.ListenerPriority.LOW;
import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class DataReloaderImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    private static final ResourcePackManager DATA_PACK_MANAGER = new ResourcePackManager(consumer -> consumer.accept(ResourcePackProfile.create("vanilla", "fixText", true, name -> new DefaultResourcePack(), ResourceType.SERVER_DATA, ResourcePackProfile.InsertionPosition.BOTTOM, ResourcePackSource.BUILTIN)), new ModResourcePackCreator(ResourceType.SERVER_DATA));
    private static final Queue<Runnable> TASKS = new ConcurrentLinkedQueue<>();
    private static final CompletableFuture<Unit> COMPLETED_UNIT_FUTURE = CompletableFuture.completedFuture(Unit.INSTANCE);

    @EventListener
    private static void scanPacks(DataReloadEvent event) {
        DATA_PACK_MANAGER.scanPacks();
    }

    @Environment(EnvType.SERVER)
    @EventListener(priority = LOW)
    private static void reloadResourceManager(DataReloadEvent event) {
        ResourceReload resourceReload = DataManager.INSTANCE.reload(
                Util.getMainWorkerExecutor(),
                TASKS::add,
                COMPLETED_UNIT_FUTURE,
                (reloader, formatString, location) -> {},
                DATA_PACK_MANAGER.createResourcePacks()
        );
        while (!resourceReload.isComplete()) {
            Runnable task = TASKS.poll();
            if (task != null)
                task.run();
        }
        resourceReload.throwException();
    }

    @Environment(EnvType.CLIENT)
    @EventListener(priority = LOW)
    private static void reloadResourceManagerClient(DataReloadEvent event) {
        ReloadScreenManager.getCurrentReload()
                .flatMap(reload1 -> reload1 instanceof CompositeResourceReload composite ? Optional.of(composite) : Optional.empty())
                .ifPresent(manager -> manager.scheduleReload(
                        NAMESPACE.id("data"),
                        () -> DataManager.INSTANCE.reload(
                                Util.getMainWorkerExecutor(),
                                ReloadScreenManager.getApplicationExecutor(),
                                DataReloaderImpl.COMPLETED_UNIT_FUTURE,
                                ReloadScreenManager::pushLocation,
                                DATA_PACK_MANAGER.createResourcePacks()
                        )
                ));
    }
}
