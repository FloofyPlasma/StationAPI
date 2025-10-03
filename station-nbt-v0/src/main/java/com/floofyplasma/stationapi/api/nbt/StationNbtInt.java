package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtInt;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtInt extends StationNbtElement {
    @Override
    default NbtInt copy() {
        return Util.assertImpl();
    }
}
