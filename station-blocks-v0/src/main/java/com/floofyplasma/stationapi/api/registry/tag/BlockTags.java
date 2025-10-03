package com.floofyplasma.stationapi.api.registry.tag;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.registry.BlockRegistry;
import com.floofyplasma.stationapi.api.tag.TagKey;
import com.floofyplasma.stationapi.api.util.Identifier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BlockTags {
    public static final TagKey<Block>
            LOGS = of("logs"),
            LEAVES = of("leaves"),
            PLANKS = of("planks"),
            INFINIBURN = of("infiniburn");

    private static TagKey<Block> of(String id) {
        return TagKey.of(BlockRegistry.KEY, Identifier.of(id));
    }
}
