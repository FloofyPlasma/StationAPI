package com.floofyplasma.sltest.block;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import com.floofyplasma.sltest.item.ItemListener;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.state.StateManager;
import com.floofyplasma.stationapi.api.state.property.EnumProperty;
import com.floofyplasma.stationapi.api.template.block.TemplateBlock;
import com.floofyplasma.stationapi.api.util.StringIdentifiable;

import java.util.List;

public class VariationBlock extends TemplateBlock {

    public enum Variant implements StringIdentifiable {
        IDLE,
        PASSIVE,
        ACTIVE;

        @Override
        public String asString() {
            return name().toLowerCase();
        }
    }

    public static final EnumProperty<Variant> VARIANT = EnumProperty.of("variant", Variant.class);

    public VariationBlock(Identifier identifier, Material material) {
        super(identifier, material);
    }

    @Override
    public void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VARIANT);
    }

    @Override
    public List<ItemStack> getDropList(World level, int x, int y, int z, BlockState blockState, int meta) {
        return List.of(new ItemStack(switch (blockState.get(VARIANT)) {
            case IDLE -> ItemListener.variationBlockIdle;
            case PASSIVE -> ItemListener.variationBlockPassive;
            case ACTIVE -> ItemListener.variationBlockActive;
        }));
    }
}
