package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtString;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtString extends StationNbtElement {
    @Override
    default NbtString copy() {
        return Util.assertImpl();
    }
}
