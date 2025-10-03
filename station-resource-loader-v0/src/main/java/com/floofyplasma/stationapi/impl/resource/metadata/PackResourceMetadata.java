package com.floofyplasma.stationapi.impl.resource.metadata;

import com.floofyplasma.stationapi.api.resource.metadata.ResourceMetadataSerializer;

public class PackResourceMetadata {
    public static final ResourceMetadataSerializer<PackResourceMetadata> SERIALIZER = new PackResourceMetadataReader();
    private final String description;
    private final int packFormat;

    public PackResourceMetadata(String description, int format) {
        this.description = description;
        this.packFormat = format;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPackFormat() {
        return this.packFormat;
    }
}
