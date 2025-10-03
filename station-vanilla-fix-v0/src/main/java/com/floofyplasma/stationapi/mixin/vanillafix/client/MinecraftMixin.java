package com.floofyplasma.stationapi.mixin.vanillafix.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.class_182;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NbtCompound;
import com.floofyplasma.stationapi.api.datafixer.DataFixers;
import com.floofyplasma.stationapi.api.nbt.NbtHelper;
import com.floofyplasma.stationapi.api.util.Namespace;
import com.floofyplasma.stationapi.impl.world.storage.FlattenedWorldStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;
import static com.floofyplasma.stationapi.impl.vanillafix.datafixer.VanillaDataFixerImpl.CURRENT_VERSION;

@Mixin(Minecraft.class)
class MinecraftMixin {
    @Shadow
    private class_182 field_2792;

    @ModifyArg(
            method = "method_2125",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/class_452;method_1491(Ljava/lang/String;)V"
            )
    )
    private String stationapi_changeProgressListenerTitle(String string, @Local(ordinal = 0) String worldName) {
        NbtCompound worldTag = ((FlattenedWorldStorage) this.field_2792).getWorldTag(worldName);

        Set<DataFixers.UpdateData> updateList = NbtHelper.getUpdateList(worldTag);

        for (DataFixers.UpdateData updateData : updateList) {
            if (updateData.namespace().equals(NAMESPACE) && updateData.currentVersion() == CURRENT_VERSION) {
                return string;
            }
        }

        return "Updating Data for Mods:";
    }

    @ModifyArg(
            method = "method_2125",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/class_452;method_1796(Ljava/lang/String;)V"
            )
    )
    private String stationapi_changeProgressListenerDesc(String string, @Local(ordinal = 0) String worldName) {
        NbtCompound worldTag = ((FlattenedWorldStorage) this.field_2792).getWorldTag(worldName);

        Set<DataFixers.UpdateData> updateList = NbtHelper.getUpdateList(worldTag);

        List<Namespace> list = new ArrayList<>();

        for (DataFixers.UpdateData updateData : updateList) {
            if (updateData.namespace().equals(NAMESPACE) && updateData.currentVersion() == CURRENT_VERSION) {
                return string;
            }

            list.add(updateData.namespace());
        }

        return list.stream().map(Namespace::toString).collect(Collectors.joining(", "));
    }
}
