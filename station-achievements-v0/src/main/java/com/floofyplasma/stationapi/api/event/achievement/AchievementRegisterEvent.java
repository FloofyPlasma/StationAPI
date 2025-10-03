package com.floofyplasma.stationapi.api.event.achievement;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.Event;
import net.mine_diver.unsafeevents.event.EventPhases;
import net.minecraft.achievement.Achievement;
import com.floofyplasma.stationapi.api.StationAPI;

import java.util.List;

@SuperBuilder
@EventPhases(StationAPI.INTERNAL_PHASE)
public class AchievementRegisterEvent extends Event {
    public final List<Achievement> achievements;
}
