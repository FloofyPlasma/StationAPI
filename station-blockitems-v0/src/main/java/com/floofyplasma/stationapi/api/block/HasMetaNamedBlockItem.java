package com.floofyplasma.stationapi.api.block;

import com.floofyplasma.stationapi.api.event.block.BlockItemFactoryEvent;
import com.floofyplasma.stationapi.api.template.item.MetaNamedBlockItem;

import java.lang.annotation.*;

/**
 * Annotation alternative of {@link MetaNamedBlockItemProvider}.
 * @author mine_diver
 * @see BlockItemFactoryEvent
 * @see CustomBlockItemFactoryProvider
 * @see HasCustomBlockItemFactory
 * @see MetaBlockItemProvider
 * @see HasMetaBlockItem
 * @see MetaNamedBlockItemProvider
 * @see MetaNamedBlockItem
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface HasMetaNamedBlockItem {
    int[] validMetas() default { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
}
