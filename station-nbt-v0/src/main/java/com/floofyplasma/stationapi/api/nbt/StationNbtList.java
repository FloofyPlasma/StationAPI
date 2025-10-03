package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtList;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtList extends StationNbtElement {
    @Override
    default NbtList copy() {
        return Util.assertImpl();
    }
}
