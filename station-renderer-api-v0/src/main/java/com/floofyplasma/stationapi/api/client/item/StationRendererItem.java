package com.floofyplasma.stationapi.api.client.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvironmentInterface;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlas;
import com.floofyplasma.stationapi.api.client.texture.atlas.CustomAtlasProvider;
import com.floofyplasma.stationapi.api.client.texture.binder.StationTextureBinder;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.util.Util;

import java.util.function.Function;

@EnvironmentInterface(value = EnvType.CLIENT, itf = CustomAtlasProvider.class)
public interface StationRendererItem extends CustomAtlasProvider {

    @Override
    @Environment(EnvType.CLIENT)
    default Atlas getAtlas() {
        return Util.assertImpl();
    }

    @Environment(EnvType.CLIENT)
    default Atlas.Sprite setTexture(Identifier textureIdentifier) {
        return Util.assertImpl();
    }

    @Deprecated
    @Environment(EnvType.CLIENT)
    default Atlas.Sprite setTexture(String texturePath) {
        return Util.assertImpl();
    }

    @Environment(EnvType.CLIENT)
    default <E extends StationTextureBinder> E setTextureBinder(Identifier staticReference, Function<Atlas.Sprite, E> initializer) {
        return Util.assertImpl();
    }
}
