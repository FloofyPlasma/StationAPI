package com.floofyplasma.stationapi.mixin.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.event.item.ItemEvent;
import com.floofyplasma.stationapi.api.item.StationItem;
import com.floofyplasma.stationapi.api.util.Namespace;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Item.class)
abstract class ItemMixin implements StationItem {
    @Mutable
    @Shadow @Final public int id;

    @Shadow public abstract Item setTranslationKey(String string);

    @Shadow public abstract int getMaxDamage();

    @ModifyVariable(
            method = "setTranslationKey(Ljava/lang/String;)Lnet/minecraft/item/Item;",
            at = @At("HEAD"),
            argsOnly = true
    )
    private String stationapi_getName(String name) {
        return StationAPI.EVENT_BUS.post(
                ItemEvent.TranslationKeyChanged.builder()
                        .item(Item.class.cast(this))
                        .translationKeyOverride(name)
                        .build()
        ).translationKeyOverride;
    }

    @Override
    @Unique
    public Item setTranslationKey(Namespace namespace, String translationKey) {
        return setTranslationKey(namespace + "." + translationKey);
    }

    @Override
    @Unique
    public boolean preHit(ItemStack stack, Entity otherEntity, PlayerEntity player) {
        return true;
    }

    @Override
    @Unique
    public boolean preMine(ItemStack stack, BlockState blockState, int x, int y, int z, int side, PlayerEntity player) {
        return true;
    }

    @Override
    @Unique
    public int getMaxDamage(ItemStack stack) {
        return getMaxDamage();
    }
}
