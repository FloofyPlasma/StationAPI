package com.floofyplasma.stationapi.api.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Util;

public interface StationItemStack extends StationItemNbt {
    @Override
    default NbtCompound getStationNbt() {
        return Util.assertImpl();
    }

    default boolean preHit(Entity otherEntity, PlayerEntity player) {
        return Util.assertImpl();
    }

    default boolean preMine(BlockState blockState, int x, int y, int z, int side, PlayerEntity player) {
        return Util.assertImpl();
    }
}
