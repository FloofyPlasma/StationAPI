package com.floofyplasma.stationapi.api.nbt;

import net.minecraft.nbt.NbtByte;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationNbtByte extends StationNbtElement {
    @Override
    default NbtByte copy() {
        return Util.assertImpl();
    }
}
