package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtByteArray;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtByteArray extends StationNbtElement {
    @Override
    default NbtByteArray copy() {
        return Util.assertImpl();
    }
}
