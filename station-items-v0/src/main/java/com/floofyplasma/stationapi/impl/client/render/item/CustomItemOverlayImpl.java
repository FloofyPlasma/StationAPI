package com.floofyplasma.stationapi.impl.client.render.item;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.event.render.item.ItemOverlayRenderEvent;
import com.floofyplasma.stationapi.api.client.item.CustomItemOverlay;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class CustomItemOverlayImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void renderItemOverlay(ItemOverlayRenderEvent event) {
        if (event.itemStack != null && event.itemStack.getItem() instanceof CustomItemOverlay itemOverlay)
            itemOverlay.renderItemOverlay(event.itemRenderer, event.itemX, event.itemY, event.itemStack, event.textRenderer, event.textureManager);
    }
}
