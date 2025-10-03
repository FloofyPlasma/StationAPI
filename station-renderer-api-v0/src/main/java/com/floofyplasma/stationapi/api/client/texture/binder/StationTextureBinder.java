package com.floofyplasma.stationapi.api.client.texture.binder;

import lombok.Getter;
import net.minecraft.class_336;
import net.minecraft.client.texture.TextureManager;
import com.floofyplasma.stationapi.api.client.StationRenderAPI;
import com.floofyplasma.stationapi.api.client.texture.TexturePackDependent;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlas;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlases;

public abstract class StationTextureBinder extends class_336 implements StaticReferenceProvider, TexturePackDependent {

    @Getter
    private final Atlas.Sprite staticReference;

    public StationTextureBinder(Atlas.Sprite staticReference) {
        super(staticReference.index);
        this.staticReference = staticReference;
    }

    @Override
    public void method_1206(TextureManager manager) {
        StationRenderAPI.getBakedModelManager().getAtlas(Atlases.GAME_ATLAS_TEXTURE).bindTexture();
    }
}
