package com.floofyplasma.stationapi.impl.world;

import com.google.common.collect.Iterators;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.world.WorldPropertiesEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.nbt.NbtHelper;
import com.floofyplasma.stationapi.mixin.nbt.NbtCompoundAccessor;

import java.lang.invoke.MethodHandles;
import java.util.Map;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class WorldDataVersionImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void addDataVersions(WorldPropertiesEvent.Save event) {
        Map.Entry<String, ? extends NbtElement> entry = Iterators.getOnlyElement(((NbtCompoundAccessor) NbtHelper.addDataVersions(new NbtCompound())).stationapi$getEntries().entrySet().iterator());
        event.nbt.put(entry.getKey(), entry.getValue());
    }
}
