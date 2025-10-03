package com.floofyplasma.stationapi.impl.resource;

import com.floofyplasma.stationapi.api.resource.ResourceType;

import java.util.function.Consumer;

public class DefaultResourcePackProvider implements ResourcePackProvider {
    @Override
    public void register(Consumer<ResourcePackProfile> consumer) {
        consumer.accept(
                ResourcePackProfile.create(
                        "vanilla",
                        "fixText",
                        true,
                        name -> new DefaultResourcePack(),
                        ResourceType.CLIENT_RESOURCES,
                        ResourcePackProfile.InsertionPosition.BOTTOM,
                        ResourcePackSource.BUILTIN
                )
        );
    }
}
