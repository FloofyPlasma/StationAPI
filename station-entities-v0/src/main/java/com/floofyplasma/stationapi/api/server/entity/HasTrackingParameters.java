package com.floofyplasma.stationapi.api.server.entity;

import com.floofyplasma.stationapi.api.server.event.entity.TrackEntityEvent;
import com.floofyplasma.stationapi.api.util.TriState;

import java.lang.annotation.*;

/**
 * Annotation alternative of {@link TrackingParametersProvider}.
 * @author mine_diver
 * @see TrackEntityEvent
 * @see CustomTracking
 * @see TrackingParametersProvider
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface HasTrackingParameters {

    /**
     * TrackingDistance supplier method.
     * @return the distance from the player to the entity in blocks within which the entity should be sent to client (tracked).
     */
    int trackingDistance();

    /**
     * UpdatePeriod supplier method.
     * @return the period in ticks with which the entity updates should be sent to client (position, velocity, etc).
     */
    int updatePeriod();

    /**
     * SendVelocity supplier method.
     * @return whether or not should server send velocity updates to clients (fireballs don't send velocity, because client can calculate it itself, and paintings don't have velocity at all).
     */
    TriState sendVelocity() default TriState.UNSET;
}
