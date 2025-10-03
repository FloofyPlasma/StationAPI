package com.floofyplasma.stationapi.api.block;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.registry.RemappableRawIdHolder;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.util.Namespace;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationBlock extends RemappableRawIdHolder {
    default Block setTranslationKey(Namespace namespace, String translationKey) {
        return Util.assertImpl();
    }

    default Block setTranslationKey(Identifier translationKey) {
        return setTranslationKey(translationKey.namespace, translationKey.path);
    }
    
    default boolean onBonemealUse(World world, int x, int y, int z, BlockState state) {
        return false;
    }
}
