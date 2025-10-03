package com.floofyplasma.stationapi.api.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import com.floofyplasma.stationapi.api.util.math.Direction;

public class AutomaticItemPlacementContext
extends ItemPlacementContext {

    private final BlockPos pos;
    private final Direction facing;

    public AutomaticItemPlacementContext(World world, BlockPos pos, Direction facing, ItemStack stack, Direction side) {
        super(world, null, stack, new HitResult(pos.getX(), pos.getY(), pos.getZ(), side.getId(), Vec3d.createCached(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5)));
        this.pos = pos;
        this.facing = facing;
    }

    @Override
    public BlockPos getBlockPos() {
        return pos;
    }

    @Override
    public boolean canPlace() {
        return this.getWorld().getBlockState(pos).canReplace(this);
    }

    @Override
    public boolean canReplaceExisting() {
        return this.canPlace();
    }

    @Override
    public Direction getPlayerLookDirection() {
        return Direction.DOWN;
    }

    @Override
    public Direction[] getPlacementDirections() {
        switch (this.facing) {
            default: {
                return new Direction[]{Direction.DOWN, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.UP};
            }
            case UP: {
                return new Direction[]{Direction.DOWN, Direction.UP, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
            }
            case NORTH: {
                return new Direction[]{Direction.DOWN, Direction.NORTH, Direction.EAST, Direction.WEST, Direction.UP, Direction.SOUTH};
            }
            case SOUTH: {
                return new Direction[]{Direction.DOWN, Direction.SOUTH, Direction.EAST, Direction.WEST, Direction.UP, Direction.NORTH};
            }
            case WEST: {
                return new Direction[]{Direction.DOWN, Direction.WEST, Direction.SOUTH, Direction.UP, Direction.NORTH, Direction.EAST};
            }
            case EAST: 
        }
        return new Direction[]{Direction.DOWN, Direction.EAST, Direction.SOUTH, Direction.UP, Direction.NORTH, Direction.WEST};
    }

    @Override
    public Direction getHorizontalPlayerFacing() {
        return this.facing.getAxis() == Direction.Axis.Y ? Direction.NORTH : this.facing;
    }

    @Override
    public boolean shouldCancelInteraction() {
        return false;
    }

    @Override
    public float getPlayerYaw() {
        return this.facing.getHorizontal() * 90;
    }
}

