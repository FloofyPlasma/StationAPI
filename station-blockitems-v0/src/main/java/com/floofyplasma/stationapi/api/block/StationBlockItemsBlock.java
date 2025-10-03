package com.floofyplasma.stationapi.api.block;

import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationBlockItemsBlock extends BlockItemToggle {
    @Override
    default Block disableAutoItemRegistration() {
        return Util.assertImpl();
    }

    @Override
    default boolean isAutoItemRegistrationDisabled() {
        return Util.assertImpl();
    }
}
