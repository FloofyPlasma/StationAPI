package com.floofyplasma.stationapi.api.item.tool;

import net.minecraft.item.ToolMaterial;
import com.floofyplasma.stationapi.mixin.tools.ToolMaterialAccessor;

public class ToolMaterialFactory {
    private static int nextId = ToolMaterial.values().length;

    public static ToolMaterial create(String materialName, int miningLevel, int durability, float miningSpeed, int attackDamage) {
        return ToolMaterialAccessor.stationapi_create(materialName, nextId++, miningLevel, durability, miningSpeed, attackDamage);
    }
}
