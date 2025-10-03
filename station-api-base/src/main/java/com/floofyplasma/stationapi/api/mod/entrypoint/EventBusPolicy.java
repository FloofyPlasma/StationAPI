package com.floofyplasma.stationapi.api.mod.entrypoint;

import com.floofyplasma.stationapi.api.StationAPI;
import net.mine_diver.unsafeevents.listener.EventListener;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EventBus entrypoint registration policy.
 * @author mine_diver
 */
@Target({})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EventBusPolicy {
    /**
     * @return whether should static {@link EventListener} methods be registered in the {@link StationAPI#EVENT_BUS}.
     */
    boolean registerStatic() default true;

    /**
     * @return whether should non-static {@link EventListener} methods be registered in the {@link StationAPI#EVENT_BUS}.
     */
    boolean registerInstance() default true;
}
