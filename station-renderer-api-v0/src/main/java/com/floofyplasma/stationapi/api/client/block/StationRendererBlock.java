package com.floofyplasma.stationapi.api.client.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvironmentInterface;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlas;
import com.floofyplasma.stationapi.api.client.texture.atlas.CustomAtlasProvider;
import com.floofyplasma.stationapi.api.util.Util;

@EnvironmentInterface(value = EnvType.CLIENT, itf = CustomAtlasProvider.class)
public interface StationRendererBlock extends CustomAtlasProvider {

    @Override
    @Environment(EnvType.CLIENT)
    default Atlas getAtlas() {
        return Util.assertImpl();
    }
}
