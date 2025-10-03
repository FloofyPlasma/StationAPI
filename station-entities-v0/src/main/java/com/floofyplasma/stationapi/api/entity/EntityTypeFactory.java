package com.floofyplasma.stationapi.api.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.block.Material;
import net.minecraft.class_238;
import net.minecraft.entity.Entity;
import com.floofyplasma.stationapi.mixin.entity.EntityTypeAccessor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EntityTypeFactory {
    private static int nextId = class_238.values().length;

    public static class_238 create(String typeName, Class<? extends Entity> typeSuperClass, int unusedInt, Material spawnMaterial, boolean unusedBoolean) {
        return EntityTypeAccessor.stationapi_create(typeName, nextId++, typeSuperClass, unusedInt, spawnMaterial, unusedBoolean);
    }
}
