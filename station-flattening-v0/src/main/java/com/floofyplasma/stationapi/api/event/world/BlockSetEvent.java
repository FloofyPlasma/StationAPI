package com.floofyplasma.stationapi.api.event.world;

import lombok.experimental.SuperBuilder;
import net.mine_diver.unsafeevents.event.Cancelable;
import net.minecraft.world.chunk.Chunk;
import com.floofyplasma.stationapi.api.block.BlockState;

@Cancelable
@SuperBuilder
public class BlockSetEvent extends WorldEvent {
    public final Chunk chunk;
    public final int
            x, y, z,
            blockMeta;
    public final BlockState blockState;
    public BlockState overrideState;
    public int overrideMeta;
}
