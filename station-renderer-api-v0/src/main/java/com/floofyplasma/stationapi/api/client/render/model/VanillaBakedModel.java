package com.floofyplasma.stationapi.api.client.render.model;

import com.google.common.collect.ImmutableList;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.client.StationRenderAPI;
import com.floofyplasma.stationapi.api.client.render.model.json.ModelOverrideList;
import com.floofyplasma.stationapi.api.client.render.model.json.ModelTransformation;
import com.floofyplasma.stationapi.api.client.texture.Sprite;
import com.floofyplasma.stationapi.api.util.math.Direction;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public final class VanillaBakedModel implements BakedModel {

    @Override
    public ImmutableList<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, Random random) {
        return ImmutableList.of();
    }

    @Override
    public boolean useAmbientOcclusion() {
        return false;
    }

    @Override
    public boolean hasDepth() {
        return false;
    }

    @Override
    public boolean isSideLit() {
        return false;
    }

    @Override
    public boolean isBuiltin() {
        return true;
    }

    @Override
    public Sprite getSprite() {
        return StationRenderAPI.getBakedModelManager().getMissingModel().getSprite();
    }

    @Override
    public ModelTransformation getTransformation() {
        return ModelTransformation.NONE;
    }

    @Override
    public ModelOverrideList getOverrides() {
        return ModelOverrideList.EMPTY;
    }
}
