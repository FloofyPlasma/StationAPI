package com.floofyplasma.sltest.block;

import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import com.floofyplasma.sltest.effect.TestPlayerInfEffect;
import com.floofyplasma.stationapi.api.template.block.TemplateBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class EffectBlockInf extends TemplateBlock {
    public EffectBlockInf(Identifier id) {
        super(id, Material.WOOD);
    }

    @Override
    public int getTextureId(BlockView view, int x, int y, int z, int side) {
        return (side & 1) == 0 ? LOG.textureId : PLANKS.textureId;
    }

    @Override
    public int getTexture(int side) {
        return (side & 1) == 0 ? GOLD_BLOCK.textureId : DIAMOND_BLOCK.textureId;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity player) {
        player.addInfiniteEffect(TestPlayerInfEffect.TYPE);
        return true;
    }
}
