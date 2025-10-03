package com.floofyplasma.stationapi.api.block;

import com.google.common.base.Suppliers;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.registry.BlockRegistryEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.util.collection.IdList;

import java.lang.invoke.MethodHandles;
import java.util.function.Supplier;

import static com.floofyplasma.stationapi.api.util.Identifier.of;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class States {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    private static final Supplier<Block> AIR_BLOCK = Suppliers.memoize(() -> new Air(0));

    public static final Supplier<BlockState> AIR = Suppliers.memoize(() -> AIR_BLOCK.get().getDefaultState());

    /**
     * @deprecated Use {@link Block#STATE_IDS} instead
     */
    @Deprecated
    public static final IdList<BlockState> STATE_IDS = Block.STATE_IDS;

    @EventListener
    private static void registerBlocks(BlockRegistryEvent event) {
        event.register(of("air"), AIR_BLOCK.get());
    }
}
