package com.floofyplasma.sltest.entity;

import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.event.entity.EntityRegister;
import com.floofyplasma.stationapi.api.event.registry.EntityHandlerRegistryEvent;
import com.floofyplasma.stationapi.api.event.registry.MobHandlerRegistryEvent;

import static com.floofyplasma.sltest.SLTest.NAMESPACE;
import static com.floofyplasma.stationapi.api.util.Identifier.of;

public class EntityListener {

    @EventListener
    public void registerEntities(EntityRegister event) {
        event.register(TestEntity.class, "sltest:test");
        event.register(PoorGuy.class, "GPoor");
    }

    @EventListener
    public void registerEntityHandlers(EntityHandlerRegistryEvent event) {
        event.register(TestEntity.ID, TestEntity::new);
    }

    @EventListener
    public void registerMobHandlers(MobHandlerRegistryEvent event) {
        event.register(of(NAMESPACE, "gpoor"), PoorGuy::new);
    }
}
