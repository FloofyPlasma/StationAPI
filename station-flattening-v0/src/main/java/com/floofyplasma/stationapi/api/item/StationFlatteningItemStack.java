package com.floofyplasma.stationapi.api.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.registry.RegistryEntry;
import com.floofyplasma.stationapi.api.tag.TagKey;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationFlatteningItemStack extends ItemStackStrengthWithBlockState {

    default RegistryEntry.Reference<Item> getRegistryEntry() {
        return Util.assertImpl();
    }

    default boolean isIn(TagKey<Item> tag) {
        return getRegistryEntry().isIn(tag);
    }

    @Override
    default boolean isSuitableFor(PlayerEntity player, BlockView blockView, BlockPos blockPos, BlockState state) {
        return Util.assertImpl();
    }

    @Override
    default float getMiningSpeedMultiplier(PlayerEntity player, BlockView blockView, BlockPos blockPos, BlockState state) {
        return Util.assertImpl();
    }

    /**
     * {@return whether the item is {@code item}}
     */
    default boolean isOf(Item item) {
        return Util.assertImpl();
    }
}
