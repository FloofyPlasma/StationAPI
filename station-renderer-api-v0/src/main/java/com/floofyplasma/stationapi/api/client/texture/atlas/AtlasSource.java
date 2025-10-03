package com.floofyplasma.stationapi.api.client.texture.atlas;

import com.floofyplasma.stationapi.api.client.texture.SpriteContents;
import com.floofyplasma.stationapi.api.client.texture.SpriteLoader;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.resource.Resource;
import com.floofyplasma.stationapi.api.resource.ResourceFinder;
import com.floofyplasma.stationapi.api.resource.ResourceManager;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public interface AtlasSource {
    ResourceFinder RESOURCE_FINDER = new ResourceFinder(NAMESPACE + "/textures", ".png");

    void load(ResourceManager var1, SpriteRegions var2);

    AtlasSourceType getType();

    interface SpriteRegion extends Supplier<SpriteContents> {
        default void close() {}
    }

    interface SpriteRegions {
        default void add(Identifier id, Resource resource) {
            this.add(id, () -> SpriteLoader.load(id, resource));
        }

        void add(Identifier var1, SpriteRegion var2);

        void removeIf(Predicate<Identifier> var1);
    }
}

