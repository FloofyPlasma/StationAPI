package com.floofyplasma.stationapi.api.item;

import com.floofyplasma.stationapi.api.dispenser.ItemDispenseContext;

/**
 * Intended to be applied to an Item, which provides a custom dispenser behavior
 * @author matthewperiut
 * @see ItemDispenseContext
 */
public interface CustomDispenseBehavior {
    void dispense(ItemDispenseContext context);
}
