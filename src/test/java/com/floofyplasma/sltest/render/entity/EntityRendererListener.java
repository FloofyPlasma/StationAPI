package com.floofyplasma.sltest.render.entity;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.client.render.entity.SkeletonEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import com.floofyplasma.sltest.entity.PoorGuy;
import com.floofyplasma.stationapi.api.client.event.render.entity.EntityRendererRegisterEvent;

public class EntityRendererListener {

    @EventListener
    public void registerEntityRenderers(EntityRendererRegisterEvent event) {
        event.renderers.put(PoorGuy.class, new SkeletonEntityRenderer(new BipedEntityModel(), 0.5f));
    }
}
