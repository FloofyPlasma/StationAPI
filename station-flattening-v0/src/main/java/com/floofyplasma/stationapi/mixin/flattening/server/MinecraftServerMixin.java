package com.floofyplasma.stationapi.mixin.flattening.server;

import net.minecraft.class_294;
import net.minecraft.server.MinecraftServer;
import com.floofyplasma.stationapi.impl.world.dimension.FlattenedDimensionFile;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.io.File;

@Mixin(MinecraftServer.class)
class MinecraftServerMixin {
    @Redirect(
            method = "method_2159",
            at = @At(
                    value = "NEW",
                    target = "(Ljava/io/File;Ljava/lang/String;Z)Lnet/minecraft/class_294;"
            )
    )
    private class_294 stationapi_flatten(File file, String string, boolean bl) {
        return new FlattenedDimensionFile(file, string, bl);
    }
}
