package com.floofyplasma.stationapi.api.registry.legacy;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.api.registry.RegistryKey;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public abstract class AbstractInt2ObjectMapBackedLegacyRegistry<T> extends AbstractLegacyRegistry<T> {

    public AbstractInt2ObjectMapBackedLegacyRegistry(@NotNull RegistryKey<? extends Registry<T>> key, boolean intrusive) {
        super(key, intrusive);
    }

    public AbstractInt2ObjectMapBackedLegacyRegistry(@NotNull RegistryKey<? extends Registry<T>> key, boolean shiftSerialIDOnRegister, boolean intrusive) {
        super(key, shiftSerialIDOnRegister, intrusive);
    }

    protected abstract Int2ObjectMap<T> getBackingInt2ObjectMap();

    @Override
    public int getSize() {
        return Integer.MAX_VALUE;
    }

    @Override
    public @NotNull Optional<T> getByLegacyId(int serialID) {
        Int2ObjectMap<T> map = getBackingInt2ObjectMap();
        return map.containsKey(serialID) ? Optional.ofNullable(map.get(serialID)) : Optional.empty();
    }
}
