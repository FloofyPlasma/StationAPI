package com.floofyplasma.stationapi.mixin.block;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.block.StationBlock;
import com.floofyplasma.stationapi.api.util.Namespace;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Block.class)
abstract class BlockMixin implements StationBlock {
    // Minecraft doesn't support translations yet. - FloofyPlasma
    /*
    @Shadow public abstract Block setTranslationKey(String string);

    @Override
    public Block setTranslationKey(Namespace namespace, String translationKey) {
        return setTranslationKey(namespace + "." + translationKey);
    }
    */
    @WrapOperation(
            method = "getDropItem",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/block/Block;id:I"
            )
    )
    private int stationapi_returnCorrectItem(Block instance, Operation<Integer> original) {
        return instance.id; // No idea what this was trying to do, just disregard for now - FloofyPlasma
    }
}
