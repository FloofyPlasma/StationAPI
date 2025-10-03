package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtDouble;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtDouble extends StationNbtElement {
    @Override
    default NbtDouble copy() {
        return Util.assertImpl();
    }
}
