package com.floofyplasma.stationapi.api.client.model.block;

import net.minecraft.client.render.block.BlockRenderManager;
import com.floofyplasma.stationapi.api.client.model.Model;

@Deprecated
public interface BlockInventoryModelProvider extends BlockWithInventoryRenderer {

    /**
     * Model to render inside the inventory.
     */
    @Deprecated
    Model getInventoryModel(int meta);

    @Override
    @Deprecated
    default void renderInventory(BlockRenderManager blockRenderer, int meta) {
        // TODO: maybe implement this later for backwards compat with PRE2
//        BAKED_MODEL_RENDERER.get().renderInventory(getInventoryModel(meta).getBaked());
    }
}
