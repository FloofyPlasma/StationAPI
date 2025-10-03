package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtShort;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtShort extends StationNbtElement {
    @Override
    default NbtShort copy() {
        return Util.assertImpl();
    }
}
