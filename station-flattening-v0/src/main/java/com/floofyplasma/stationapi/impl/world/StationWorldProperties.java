package com.floofyplasma.stationapi.impl.world;

import net.minecraft.nbt.NbtCompound;
import com.floofyplasma.stationapi.api.util.Identifier;

public interface StationWorldProperties {
    NbtCompound getDimensionTag(Identifier id);
}
