package com.floofyplasma.stationapi.api.block;

import com.floofyplasma.stationapi.api.event.block.BlockItemFactoryEvent;
import com.floofyplasma.stationapi.api.template.item.MetaBlockItem;

import java.lang.annotation.*;

/**
 * Annotation alternative of {@link MetaBlockItemProvider}.
 * @author mine_diver
 * @see BlockItemFactoryEvent
 * @see CustomBlockItemFactoryProvider
 * @see HasCustomBlockItemFactory
 * @see MetaBlockItemProvider
 * @see MetaNamedBlockItemProvider
 * @see HasMetaNamedBlockItem
 * @see MetaBlockItem
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface HasMetaBlockItem {}
