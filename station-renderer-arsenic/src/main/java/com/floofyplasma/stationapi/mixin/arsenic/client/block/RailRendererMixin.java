package com.floofyplasma.stationapi.mixin.arsenic.client.block;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.block.RailBlock;
import net.minecraft.client.render.block.BlockRenderManager;
import com.floofyplasma.stationapi.api.client.StationRenderAPI;
import com.floofyplasma.stationapi.api.client.texture.Sprite;
import com.floofyplasma.stationapi.api.client.texture.atlas.Atlases;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.floofyplasma.stationapi.impl.client.arsenic.renderer.render.ArsenicBlockRenderer.*;

@Mixin(BlockRenderManager.class)
class RailRendererMixin {
    @Inject(
            method = "renderRail",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/render/block/BlockRenderManager;textureOverride:I",
                    opcode = Opcodes.GETFIELD,
                    ordinal = 1,
                    shift = At.Shift.BY,
                    by = 3
            )
    )
    private void stationapi_rails_captureTexture(
            RailBlock block, int j, int k, int par4, CallbackInfoReturnable<Boolean> cir,
            @Local(index = 7) int textureId,
            @Share("texture") LocalRef<Sprite> texture
    ) {
        texture.set(block.getAtlas().getTexture(textureId).getSprite());
    }

    @ModifyVariable(
            method = "renderRail",
            index = 9,
            at = @At("STORE")
    )
    private int stationapi_rails_modTextureX(
            int value,
            @Share("texture") LocalRef<Sprite> texture
    ) {
        return texture.get().getX();
    }

    @ModifyVariable(
            method = "renderRail",
            index = 10,
            at = @At("STORE")
    )
    private int stationapi_rails_modTextureY(
            int value,
            @Share("texture") LocalRef<Sprite> texture
    ) {
        return texture.get().getY();
    }

    @ModifyConstant(
            method = "renderRail",
            constant = {
                    @Constant(
                            floatValue = ATLAS_SIZE,
                            ordinal = 0
                    ),
                    @Constant(
                            floatValue = ATLAS_SIZE,
                            ordinal = 1
                    )
            }
    )
    private float stationapi_rails_modAtlasWidth(float constant) {
        return StationRenderAPI.getBakedModelManager().getAtlas(Atlases.GAME_ATLAS_TEXTURE).getWidth();
    }

    @ModifyConstant(
            method = "renderRail",
            constant = @Constant(
                    floatValue = ADJUSTED_TEX_SIZE,
                    ordinal = 0
            )
    )
    private float stationapi_rails_modTextureWidth(
            float constant,
            @Share("texture") LocalRef<Sprite> texture
    ) {
        return adjustToWidth(constant, texture.get());
    }

    @ModifyConstant(
            method = "renderRail",
            constant = {
                    @Constant(
                            floatValue = ATLAS_SIZE,
                            ordinal = 2
                    ),
                    @Constant(
                            floatValue = ATLAS_SIZE,
                            ordinal = 3
                    )
            }
    )
    private float stationapi_rails_modAtlasHeight(float constant) {
        return StationRenderAPI.getBakedModelManager().getAtlas(Atlases.GAME_ATLAS_TEXTURE).getHeight();
    }

    @ModifyConstant(
            method = "renderRail",
            constant = @Constant(
                    floatValue = ADJUSTED_TEX_SIZE,
                    ordinal = 1
            )
    )
    private float stationapi_rails_modTextureHeight(
            float constant,
            @Share("texture") LocalRef<Sprite> texture
    ) {
        return adjustToHeight(constant, texture.get());
    }
}
