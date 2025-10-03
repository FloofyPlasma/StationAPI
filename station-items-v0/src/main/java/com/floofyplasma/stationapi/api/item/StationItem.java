package com.floofyplasma.stationapi.api.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.util.Namespace;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationItem {
    default Item setTranslationKey(Namespace namespace, String translationKey) {
        return Util.assertImpl();
    }

    default Item setTranslationKey(Identifier translationKey) {
        return setTranslationKey(translationKey.namespace, translationKey.path);
    }

    default boolean preHit(ItemStack stack, Entity otherEntity, PlayerEntity player) {
        return Util.assertImpl();
    }

    default boolean preMine(ItemStack stack, BlockState blockState, int x, int y, int z, int side, PlayerEntity player) {
        return Util.assertImpl();
    }

    default int getMaxDamage(ItemStack stack) {
        return Util.assertImpl();
    }
}
