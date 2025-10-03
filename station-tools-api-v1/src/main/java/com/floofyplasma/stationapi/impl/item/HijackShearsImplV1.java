package com.floofyplasma.stationapi.impl.item;

import lombok.val;
import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.item.tool.StationTool;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.util.Identifier;

import java.lang.invoke.MethodHandles;

@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class HijackShearsImplV1 {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    //TODO: Make this match anything that has shear tool properties. Not sure how to go around this at the moment.
    @EventListener
    private static void hijackShearsEvent(ShearsOverrideEvent event) {
        if (!event.overrideShears && event.itemStack.getItem() instanceof StationTool tool) {
            val effectiveBlocks = tool.getEffectiveBlocks(event.itemStack);
            if (effectiveBlocks != null)
                event.overrideShears = effectiveBlocks.id().equals(Identifier.of("mineable/shears"));
        }
    }
}
