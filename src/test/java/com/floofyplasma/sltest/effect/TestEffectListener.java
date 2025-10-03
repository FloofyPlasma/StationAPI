package com.floofyplasma.sltest.effect;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.sltest.SLTest;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.effect.EntityEffectTypeRegistryEvent;

public class TestEffectListener {
    @EventListener
    public void registerEffects(EntityEffectTypeRegistryEvent event) {
        event.register(SLTest.NAMESPACE)
                .accept("test_effect", TestPlayerEffect.TYPE)
                .accept("infinity_effect", TestPlayerInfEffect.TYPE);
        StationAPI.LOGGER.info("Registered Entity Effects!");
    }
}
