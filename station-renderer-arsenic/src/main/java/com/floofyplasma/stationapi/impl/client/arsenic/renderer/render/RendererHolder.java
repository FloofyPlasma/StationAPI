package com.floofyplasma.stationapi.impl.client.arsenic.renderer.render;

import com.floofyplasma.stationapi.api.client.render.RendererAccess;
import com.floofyplasma.stationapi.api.client.render.model.BakedModelRenderer;

import java.util.Objects;

final class RendererHolder {
    private RendererHolder() { throw new RuntimeException("No"); }

    final static BakedModelRenderer RENDERER = Objects.requireNonNull(RendererAccess.INSTANCE.getRenderer()).bakedModelRenderer();
}
