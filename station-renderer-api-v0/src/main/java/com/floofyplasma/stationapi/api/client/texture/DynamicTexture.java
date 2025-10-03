package com.floofyplasma.stationapi.api.client.texture;

import com.floofyplasma.stationapi.api.util.Identifier;

import java.io.IOException;
import java.nio.file.Path;

public interface DynamicTexture {
    void save(Identifier id, Path path) throws IOException;
}

