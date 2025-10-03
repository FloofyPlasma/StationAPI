package com.floofyplasma.stationapi.impl.dispenser;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.dispenser.DispenseEvent;
import com.floofyplasma.stationapi.api.item.CustomDispenseBehavior;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class CustomDispenseBehaviorImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void implementCustomDispenseBehaviorInterface(DispenseEvent event) {
        if (event.context.itemStack != null) {
            if (event.context.itemStack.getItem() instanceof CustomDispenseBehavior behavior) {
                behavior.dispense(event.context);
                event.cancel();
            }
        }
    }
}
