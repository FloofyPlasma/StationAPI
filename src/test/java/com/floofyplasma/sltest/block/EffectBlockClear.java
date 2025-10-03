package com.floofyplasma.sltest.block;

import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.template.block.TemplateBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class EffectBlockClear extends TemplateBlock {
    public EffectBlockClear(Identifier id) {
        super(id, Material.WOOD);
    }

    @Override
    public int getTextureId(BlockView view, int x, int y, int z, int side) {
        return (side & 1) == 0 ? OBSIDIAN.textureId : LAVA.textureId;
    }

    @Override
    public int getTexture(int side) {
        return (side & 1) == 0 ? OBSIDIAN.textureId : LAVA.textureId;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity player) {
        player.removeAllEffects();
        return true;
    }
}
