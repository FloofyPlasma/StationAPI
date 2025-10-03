package com.floofyplasma.sltest.tileentity;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.sltest.SLTest;
import com.floofyplasma.stationapi.api.event.block.entity.BlockEntityRegisterEvent;

public class TileEntityListener {

    @EventListener
    public void registerTileEntities(BlockEntityRegisterEvent event) {
        SLTest.LOGGER.info("reeee tile entiites");
        event.register(TileEntityFreezer.class, "sltest:freezer");
    }
}
