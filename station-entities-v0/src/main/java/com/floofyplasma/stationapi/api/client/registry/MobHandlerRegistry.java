package com.floofyplasma.stationapi.api.client.registry;

import com.mojang.serialization.Lifecycle;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.registry.Registries;
import com.floofyplasma.stationapi.api.registry.RegistryKey;
import com.floofyplasma.stationapi.api.registry.SimpleRegistry;

import java.util.function.Function;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

public final class MobHandlerRegistry extends SimpleRegistry<Function<World, LivingEntity>> {

    public static final RegistryKey<MobHandlerRegistry> KEY = RegistryKey.ofRegistry(NAMESPACE.id("mob_handlers"));
    public static final MobHandlerRegistry INSTANCE = Registries.create(KEY, new MobHandlerRegistry(), Lifecycle.experimental());

    private MobHandlerRegistry() {
        super(KEY, Lifecycle.experimental(), false);
    }
}
