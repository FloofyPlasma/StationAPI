package com.floofyplasma.stationapi.impl.worldgen;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.minecraft.world.biome.Biome;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.world.biome.BiomeRegisterEvent;
import com.floofyplasma.stationapi.api.event.worldgen.biome.BiomeProviderRegisterEvent;
import com.floofyplasma.stationapi.api.worldgen.BiomeAPI;

public class WorldgenListener {
    private boolean initiated;

    @EventListener(priority = ListenerPriority.LOWEST)
    public void afterInit(BiomeRegisterEvent event) {
        if (initiated) return;
        StationAPI.EVENT_BUS.post(BiomeProviderRegisterEvent.builder().build());
        initiated = true;
    }

    @EventListener(phase = StationAPI.INTERNAL_PHASE)
    public void registerBiomes(BiomeProviderRegisterEvent event) {
        BiomeAPI.addOverworldBiomeProvider(
                StationAPI.NAMESPACE.id("overworld_biome_provider"),
                OverworldBiomeProviderImpl.getInstance()
        );
        BiomeAPI.addNetherBiomeProvider(
                StationAPI.NAMESPACE.id("nether_biome_provider"),
                NetherBiomeProviderImpl.getInstance()
        );
        Biome.HELL.setFogColor(0xFF330707);
    }
}
