package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtLong;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtLong extends StationNbtElement {
    @Override
    default NbtLong copy() {
        return Util.assertImpl();
    }
}
