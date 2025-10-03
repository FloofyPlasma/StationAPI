package com.floofyplasma.stationapi.api.event.registry.legacy;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import com.floofyplasma.stationapi.api.registry.legacy.WorldLegacyRegistry;

/**
 * An event that's fired after all {@link WorldLegacyRegistry}
 * instances have been remapped.
 *
 * @author mine_diver
 * @see WorldLegacyRegistry
 */
@SuperBuilder
public class PostRegistryRemapEvent extends Event {}
