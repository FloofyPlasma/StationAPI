package com.floofyplasma.sltest.bonemeal;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.mine_diver.unsafeevents.listener.ListenerPriority;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.bonemeal.BonemealAPI;
import com.floofyplasma.stationapi.api.event.registry.BlockRegistryEvent;

public class BonemealListener {
    @EventListener(priority = ListenerPriority.LOW)
    public void registerItems(BlockRegistryEvent event) {
        BonemealAPI.addPlant(Block.SAND.getDefaultState(), Block.BOOKSHELF.getDefaultState(), 1);
    }
}
