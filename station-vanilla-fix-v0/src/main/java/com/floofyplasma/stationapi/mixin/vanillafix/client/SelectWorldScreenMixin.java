package com.floofyplasma.stationapi.mixin.vanillafix.client;

import net.minecraft.class_591;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import com.floofyplasma.stationapi.impl.vanillafix.client.gui.screen.WorldConversionWarning;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(SelectWorldScreen.class)
class SelectWorldScreenMixin extends Screen {
    @Shadow private List<class_591> field_2436;

    @Redirect(
            method = "buttonClicked",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screen/world/SelectWorldScreen;method_1891(I)V"
            )
    )
    private void stationapi_warn(SelectWorldScreen instance, int i) {
        WorldConversionWarning.warnIfMcRegion(minecraft, instance, field_2436.get(i), () -> instance.method_1891(i));
    }
}
