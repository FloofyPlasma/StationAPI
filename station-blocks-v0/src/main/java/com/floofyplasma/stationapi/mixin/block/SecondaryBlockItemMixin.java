package com.floofyplasma.stationapi.mixin.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.mob.player.PlayerEntity;
import net.minecraft.item.ItemStack;
//import net.minecraft.item.SecondaryBlockItem;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.block.BlockEvent;
import com.floofyplasma.stationapi.api.registry.BlockRegistry;
import com.floofyplasma.stationapi.api.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

// This class is currently unknown - FloofyPlasma
/*
@Mixin(SecondaryBlockItem.class)
class SecondaryBlockItemMixin {
    @WrapOperation(
            method = "useOnBlock",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlock(IIII)Z"
            )
    )
    private boolean stationapi_handlePlace(
            World world, int x, int y, int z, int id, Operation<Boolean> placeFunction,
            ItemStack blockItem, PlayerEntity player, World argWorld, int argX, int argY, int argZ, int side
    ) {
        return StationAPI.EVENT_BUS.post(
                BlockEvent.BeforePlacedByItem.builder()
                        .world(world)
                        .player(player)
                        .x(x).y(y).z(z)
                        .side(Direction.byId(side))
                        .block(BlockRegistry.INSTANCE.get(id))
                        .blockItem(blockItem)
                        .placeFunction(() -> placeFunction.call(world, x, y, z, id))
                        .build()
        ).placeFunction.getAsBoolean();
    }
}
*/