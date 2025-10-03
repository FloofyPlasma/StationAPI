package com.floofyplasma.stationapi.mixin.tools;

import net.minecraft.block.Block;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import com.floofyplasma.stationapi.api.registry.BlockRegistry;
import com.floofyplasma.stationapi.api.tag.TagKey;
import com.floofyplasma.stationapi.api.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ShovelItem.class)
public class ShovelItemMixin extends ToolItem {
    private ShovelItemMixin(int i, int j, ToolMaterial arg, Block[] args) {
        super(i, j, arg, args);
    }

    @Inject(
            method = "<init>",
            at = @At("RETURN")
    )
    private void stationapi_injectAtCtor(int arg, ToolMaterial par2, CallbackInfo ci) {
        setEffectiveBlocks(TagKey.of(BlockRegistry.INSTANCE.getKey(), Identifier.of("mineable/shovel")));
    }
}
