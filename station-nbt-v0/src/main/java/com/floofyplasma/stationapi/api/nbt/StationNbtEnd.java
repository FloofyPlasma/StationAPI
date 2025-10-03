package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtEnd;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtEnd extends StationNbtElement {
    @Override
    default NbtEnd copy() {
        return Util.assertImpl();
    }
}
