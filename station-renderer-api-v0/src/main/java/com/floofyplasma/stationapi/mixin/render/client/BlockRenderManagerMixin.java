package com.floofyplasma.stationapi.mixin.render.client;

import net.minecraft.block.Block;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.world.BlockView;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.client.StationRenderAPI;
import com.floofyplasma.stationapi.api.client.render.RendererAccess;
import com.floofyplasma.stationapi.api.client.render.block.StationRendererBlockRenderManager;
import com.floofyplasma.stationapi.api.client.render.model.VanillaBakedModel;
import com.floofyplasma.stationapi.api.util.math.MutableBlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import java.util.Random;

@Mixin(BlockRenderManager.class)
abstract class BlockRenderManagerMixin implements StationRendererBlockRenderManager {
    @Unique
    private final MutableBlockPos stationapi_pos = new MutableBlockPos(0, 0, 0);
    @Unique
    private final Random stationapi_random = new Random();

    @Shadow public abstract void renderWithoutCulling(Block arg, int i, int j, int k);

    @Shadow private BlockView blockView;

    @SuppressWarnings("AddedMixinMembersNamePattern")
    @Override
    @Unique
    public void renderAllSides(BlockState state, int x, int y, int z) {
        if (StationRenderAPI.getBakedModelManager().getBlockModels().getModel(state) instanceof VanillaBakedModel)
            renderWithoutCulling(state.getBlock(), x, y, z);
        else if (RendererAccess.INSTANCE.hasRenderer())
            RendererAccess.INSTANCE.getRenderer().bakedModelRenderer().renderBlock(state, stationapi_pos.set(x, y, z), blockView, false, stationapi_random);
    }
}
