package com.floofyplasma.sltest.item;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.floofyplasma.sltest.block.Blocks;
import com.floofyplasma.stationapi.api.client.item.CustomTooltipProvider;
import com.floofyplasma.stationapi.api.dispenser.ItemDispenseContext;
import com.floofyplasma.stationapi.api.item.CustomDispenseBehavior;

public class IndispensableBlockItem extends BlockItem implements CustomDispenseBehavior, CustomTooltipProvider {
    public IndispensableBlockItem(int i) {
        super(i);
    }

    @Override
    public void dispense(ItemDispenseContext context) {
        World world = context.dispenser.world;
        BlockPos pos = context.getFacingBlockPos();
        if (world.getBlockId(pos.x, pos.y, pos.z) == 0) {
            world.setBlock(pos.x, pos.y, pos.z, Blocks.INDISPENSABLE_BLOCK.get().id);
            world.playSound((float)pos.x + 0.5f, (float)pos.y + 0.5f, (float)pos.z + 0.5f, Blocks.INDISPENSABLE_BLOCK.get().soundGroup.getSound(), (Blocks.INDISPENSABLE_BLOCK.get().soundGroup.method_1976() + 1.0f) / 2.0f, Blocks.INDISPENSABLE_BLOCK.get().soundGroup.method_1977() * 0.8f);
        }
    }

    @Override
    public String[] getTooltip(ItemStack stack, String originalTooltip) {
        return new String[]{originalTooltip, "Dispensers can only place this block"};
    }
}
