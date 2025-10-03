package com.floofyplasma.sltest.dimension;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.event.registry.DimensionRegistryEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.registry.DimensionContainer;
import com.floofyplasma.stationapi.api.registry.DimensionRegistry;

import java.lang.invoke.MethodHandles;

import static com.floofyplasma.sltest.SLTest.NAMESPACE;
import static com.floofyplasma.stationapi.api.util.Identifier.of;

public class DimensionListener {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void registerDimensions(DimensionRegistryEvent event) {
        DimensionRegistry r = event.registry;
        r.register(of(NAMESPACE, "test_dimension"), new DimensionContainer<>(TestDimension::new));
    }
}
