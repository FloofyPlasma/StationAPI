package com.floofyplasma.stationapi.impl.vanillafix.recipe;

import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.recipe.RecipeRegisterEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.recipe.FuelRegistry;
import com.floofyplasma.stationapi.api.registry.tag.ItemTags;

import java.lang.invoke.MethodHandles;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public final class VanillaFuelItemFixImpl {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void registerFuel(RecipeRegisterEvent event) {
        if (RecipeRegisterEvent.Vanilla.SMELTING.type() == event.recipeId) {
            for (Block block : Block.BLOCKS)
                if (block != null && block.material == Material.WOOD && Item.ITEMS[block.id] != null)
                    FuelRegistry.addFuelItem(Item.ITEMS[block.id], 300);
            FuelRegistry.addFuelItem(Item.STICK, 100);
            FuelRegistry.addFuelTag(ItemTags.COALS, 1600);
            FuelRegistry.addFuelItem(Item.LAVA_BUCKET, 20000);
            FuelRegistry.addFuelTag(ItemTags.SAPLINGS, 100);
        }
    }
}
