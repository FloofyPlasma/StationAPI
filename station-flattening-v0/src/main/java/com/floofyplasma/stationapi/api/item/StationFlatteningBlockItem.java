package com.floofyplasma.stationapi.api.item;

import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.util.Util;
import org.jetbrains.annotations.ApiStatus;

public interface StationFlatteningBlockItem extends BlockItemForm {

    default Block getBlock() {
        return Util.assertImpl();
    }

    @ApiStatus.Internal
    default void setBlock(Block block) {
        Util.assertImpl();
    }
}
