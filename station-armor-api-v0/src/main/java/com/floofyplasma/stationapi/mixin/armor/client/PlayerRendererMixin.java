package com.floofyplasma.stationapi.mixin.armor.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.client.render.entity.MobRenderer;
import net.minecraft.client.render.entity.PlayerRenderer;
import net.minecraft.client.render.model.Model;
import net.minecraft.entity.mob.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import com.floofyplasma.stationapi.api.client.item.ArmorTextureProvider;
import com.floofyplasma.stationapi.api.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

@Mixin(PlayerRenderer.class)
class PlayerRendererMixin extends MobRenderer {
    @Unique private static final Map<Identifier, String[]> STATIONAPI$ARMOR_CACHE = new Reference2ObjectOpenHashMap<>();
    
    public PlayerRendererMixin(Model model, float f) {
        super(model, f);
    }

    /*
    // Old signature kept for historical purposes, just incase something is incorrect. - FloofyPlasma
        private void stationapi_onArmorTexture(
            PlayerEntityRenderer renderer, String texture,
            Operation<Void> fallback,
            PlayerEntity player, int i, float f,
            @Local(index = 6) ArmorItem armor
    )
     */

    // TODO: refactor. this seems a bit off in some places
    @WrapOperation( // Updated method hooks, we know the names.
            method = "bindTexture(Lnet/minecraft/entity/mob/player/PlayerEntity;I)Z",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/PlayerRenderer;bindTexture(Ljava/lang/String;)V"
            )
    )
    private void stationapi_onArmorTexture( // Updated function signature, float f doesn't exist in this version. - FloofyPlasma
            PlayerRenderer renderer, String texture, Operation<Void> fallback, PlayerEntity player, int i, @Local(ordinal = 0) ArmorItem armor
    ) {
        if (armor instanceof ArmorTextureProvider provider) {
            Identifier id = provider.getTexture(armor);
            String[] textures = STATIONAPI$ARMOR_CACHE.computeIfAbsent(id, k -> new String[4]);
            if (textures[i] == null) textures[i] = stationapi_getTexturePath(id, i);
            fallback.call(renderer, textures[i]);
        }
        else fallback.call(renderer, texture);
    }

    @Unique
    private String stationapi_getTexturePath(Identifier identifier, int armorIndex) {
        return "/assets/" + identifier.namespace + "/stationapi/textures/armor/" + identifier.path + (armorIndex == 2 ? "_2.png" : "_1.png");
    }
}
