package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtFloat;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtFloat extends StationNbtElement {
    @Override
    default NbtFloat copy() {
        return Util.assertImpl();
    }
}
