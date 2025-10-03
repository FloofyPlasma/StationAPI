package com.floofyplasma.stationapi.api.client.render.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import com.floofyplasma.stationapi.api.block.BlockState;
import com.floofyplasma.stationapi.api.state.StateManager;

import java.util.function.Predicate;

@FunctionalInterface
@Environment(EnvType.CLIENT)
public interface MultipartModelSelector {
   MultipartModelSelector TRUE = (stateManager) -> (blockState) -> true;
   MultipartModelSelector FALSE = (stateManager) -> (blockState) -> false;

   Predicate<BlockState> getPredicate(StateManager<Block, BlockState> stateFactory);
}
