package com.floofyplasma.stationapi.api.server.entity;

import net.minecraft.class_488;
import net.minecraft.class_80;
import com.floofyplasma.stationapi.api.server.event.entity.TrackEntityEvent;

/**
 * Entity interface that's used to do custom entity tracking logic inside the entity class via {@link TrackEntityEvent} hook.
 * Only use it if {@link TrackingParametersProvider} and {@link HasTrackingParameters} aren't enough.
 * @author mine_diver
 * @see TrackEntityEvent
 * @see TrackingParametersProvider
 * @see HasTrackingParameters
 */
public interface CustomTracking {

    /**
     * Track method that gets called after server tries tracking an entity by checking if it's instance of a vanilla class.
     * @param entityTracker current dimension's tracker instance. Can be used to (un)track entities.
     * @param trackedEntities the set of tracked entities. Can be used to check if entity is already tracked.
     * @see TrackingParametersProvider#track(class_488, class_80)
     */
    void track(class_488 entityTracker, class_80 trackedEntities);
}
