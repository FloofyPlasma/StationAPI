package com.floofyplasma.stationapi.impl.effect;

import com.floofyplasma.stationapi.api.effect.EntityEffect;
import com.floofyplasma.stationapi.api.effect.EntityEffectType;

public interface StationEffectsEntityImpl {
    void stationapi_addEffect(EntityEffect<?> effect, boolean appliedNow);

    void stationapi_removeAllEffects();

    void stationapi_removeEffect(EntityEffectType<?> effectType);
}
