package com.floofyplasma.stationapi.api.event.effect;

import net.mine_diver.unsafeevents.event.EventPhases;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.effect.EntityEffectType;
import com.floofyplasma.stationapi.api.effect.EntityEffectTypeRegistry;
import com.floofyplasma.stationapi.api.event.registry.AfterBlockAndItemRegisterEvent;
import com.floofyplasma.stationapi.api.event.registry.RegistryEvent;

/**
 * Posted during {@link AfterBlockAndItemRegisterEvent}
 */
@EventPhases(StationAPI.INTERNAL_PHASE)
public class EntityEffectTypeRegistryEvent extends RegistryEvent.EntryTypeBound<EntityEffectType<?>, EntityEffectTypeRegistry> {
    public EntityEffectTypeRegistryEvent() {
        super(EntityEffectTypeRegistry.INSTANCE);
    }
}
