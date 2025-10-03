package com.floofyplasma.sltest.item;

import net.minecraft.entity.EntityRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.dispenser.ItemDispenseContext;
import com.floofyplasma.stationapi.api.item.CustomDispenseBehavior;
import com.floofyplasma.stationapi.api.template.item.TemplatePickaxeItem;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.util.math.Direction;

public class ModdedPickaxeItem extends TemplatePickaxeItem implements CustomDispenseBehavior {

    public ModdedPickaxeItem(Identifier identifier, ToolMaterial material) {
        super(identifier, material);
    }

    @Override
    public boolean useOnBlock(ItemStack item, PlayerEntity player, World level, int x, int y, int z, int facing) {
        if (player.method_1373()) {
            if (!level.isRemote) {
                level.setBlock(x, y, z, 0);
            }
            item.bobbingAnimationTime = 20;
            return true;
        } else if (facing == Direction.UP.ordinal()) {
            if (!level.isRemote) {
                LivingEntity entity = (LivingEntity) EntityRegistry.create("GPoor", level);
                entity.method_1340(x + 0.5, y + 1, z + 0.5);
                level.method_210(entity);
                entity.method_919();
            }
            item.bobbingAnimationTime = 20;
            return true;
        } else
            return false;
    }

    @Override
    public void dispense(ItemDispenseContext context) {
        LivingEntity entity = (LivingEntity) EntityRegistry.create("GPoor", context.dispenser.world);
        context.shootEntity(entity);
    }
}
