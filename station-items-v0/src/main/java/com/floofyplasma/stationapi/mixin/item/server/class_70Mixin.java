package com.floofyplasma.stationapi.mixin.item.server;

import net.minecraft.class_70;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.item.UseOnBlockFirst;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(class_70.class)
class class_70Mixin {
    @Shadow public PlayerEntity field_2309;

    @Inject(
            method = "method_1832",
            at = @At("HEAD"),
            cancellable = true
    )
    private void stationapi_injectOnPlaceBlock(PlayerEntity playerBase, World world, ItemStack stack, int i, int j, int k, int i1, CallbackInfoReturnable<Boolean> cir) {
        if (stack != null && stack.getItem() instanceof UseOnBlockFirst use && use.onUseOnBlockFirst(stack, playerBase, world, i, j, k, i1))
            cir.setReturnValue(true);
    }

    @Inject(
            method = "method_1830",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/class_73;getBlockId(III)I"
            ),
            cancellable = true
    )
    public void stationapi_method_1830_preMine(int x, int y, int z, int side, CallbackInfo ci){
        ItemStack stack = this.field_2309.inventory.getSelectedItem();
        if (stack != null && !stack.preMine(this.field_2309.world.getBlockState(x, y, z), x, y, z, side, this.field_2309))
            ci.cancel();
    }
}
