package com.floofyplasma.stationapi.api.registry;

import com.floofyplasma.stationapi.api.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface DefaultedRegistry<T> extends Registry<T> {
    @NotNull
    Identifier getId(T value);

    @NotNull
    T get(@Nullable Identifier id);

    @NotNull
    T get(int index);

    Identifier getDefaultId();
}
