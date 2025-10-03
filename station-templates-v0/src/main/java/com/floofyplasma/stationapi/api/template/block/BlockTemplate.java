package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.registry.BlockRegistry;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.api.util.Identifier;

public interface BlockTemplate {
    static int getNextId() {
        return BlockRegistry.AUTO_ID;
    }

    static void onConstructor(Block block, Identifier id) {
        Registry.register(BlockRegistry.INSTANCE, block.id, id, block);
    }
}
