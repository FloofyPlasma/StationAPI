package com.floofyplasma.stationapi.api.event.registry;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import com.floofyplasma.stationapi.api.util.Identifier;

@SuperBuilder
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class RegistryEntryRemovedEvent<T> extends Event {
    int rawId; Identifier id; T object;
}
