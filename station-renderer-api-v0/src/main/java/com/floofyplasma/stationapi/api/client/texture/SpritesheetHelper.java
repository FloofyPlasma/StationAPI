package com.floofyplasma.stationapi.api.client.texture;

import it.unimi.dsi.fastutil.ints.IntIntPair;
import com.floofyplasma.stationapi.api.util.Identifier;

public interface SpritesheetHelper {

    IntIntPair DEFAULT_RESOLUTION_MULTIPLIER = IntIntPair.of(1, 1);

    Identifier generateIdentifier(int textureIndex);

    IntIntPair getResolutionMultiplier(int textureIndex);
}
