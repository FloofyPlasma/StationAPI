package com.floofyplasma.sltest.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.state.StateManager.Builder;
import com.floofyplasma.stationapi.api.state.property.BooleanProperty;
import com.floofyplasma.stationapi.api.template.block.TemplateBlock;
import com.floofyplasma.stationapi.api.world.BlockStateView;

public class LampBlock extends TemplateBlock {
    private static final BooleanProperty ACTIVE = BooleanProperty.of("active");

    public LampBlock(Identifier id) {
        super(id, Material.WOOD);
        setLuminance(state -> state.get(ACTIVE) ? 15 : 0);
        setTranslationKey(id);
        setSoundGroup(WOOD_SOUND_GROUP);
        setDefaultState(getDefaultState().with(ACTIVE, false));
    }

    @Override
    public void appendProperties(Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(ACTIVE);
    }

    @Override
    public int getTextureId(BlockView view, int x, int y, int z, int side) {
        if (view instanceof BlockStateView stateView) {
            return stateView.getBlockState(x, y, z).get(ACTIVE) ? LAVA.textureId : OBSIDIAN.textureId;
        }
        return OBSIDIAN.textureId;
    }

    @Override
    public int getTexture(int side) {
        return OBSIDIAN.textureId;
    }

    @Override
    public boolean onUse(World level, int x, int y, int z, PlayerEntity player) {
        BlockState state = level.getBlockState(x, y, z);
        state = state.with(ACTIVE, !state.get(ACTIVE));
        level.setBlockState(x, y, z, state);
        return super.onUse(level, x, y, z, player);
    }
}
