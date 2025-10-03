package com.floofyplasma.stationapi.api.client.event.render.item;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.StationAPI;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class ItemOverlayRenderEvent extends Event {
    public final int itemX, itemY;
    public final ItemStack itemStack;
    public final TextRenderer textRenderer;
    public final TextureManager textureManager;
    public final ItemRenderer itemRenderer;
}
