package com.floofyplasma.stationapi.api.client.texture.atlas;

import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.impl.client.texture.StationRenderImpl;

import static com.floofyplasma.stationapi.api.util.Identifier.of;

public final class Atlases {

    public static final Identifier GAME_ATLAS_TEXTURE = of("textures/atlas/game.png");

    public static ExpandableAtlas getTerrain() {
        return StationRenderImpl.getTerrain();
    }

    public static ExpandableAtlas getGuiItems() {
        return StationRenderImpl.getGuiItems();
    }

    /* !==========================! */
    /* !--- DEPRECATED SECTION ---! */
    /* !==========================! */

    @Deprecated
    public static ExpandableAtlas getStationTerrain() {
        return getTerrain();
    }

    @Deprecated
    public static ExpandableAtlas getStationGuiItems() {
        return getGuiItems();
    }
}
