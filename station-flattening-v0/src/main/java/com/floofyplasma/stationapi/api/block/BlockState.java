package com.floofyplasma.stationapi.api.block;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.registry.BlockRegistry;
import com.floofyplasma.stationapi.api.state.property.Property;

public class BlockState extends AbstractBlockState {
   public static final Codec<BlockState> CODEC = createCodec(BlockRegistry.INSTANCE.getCodec(), Block::getDefaultState).stable();

   public BlockState(Block block, ImmutableMap<Property<?>, Comparable<?>> immutableMap, MapCodec<BlockState> mapCodec) {
      super(block, immutableMap, mapCodec);
   }

   protected BlockState asBlockState() {
      return this;
   }
}
