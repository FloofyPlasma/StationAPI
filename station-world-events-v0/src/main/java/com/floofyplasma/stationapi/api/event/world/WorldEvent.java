package com.floofyplasma.stationapi.api.event.world;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.minecraft.world.World;

@SuperBuilder
public abstract class WorldEvent extends Event {
    public final World world;

    @SuperBuilder
    public static class Init extends WorldEvent {}

    @SuperBuilder
    public static class Save extends WorldEvent {}
}
