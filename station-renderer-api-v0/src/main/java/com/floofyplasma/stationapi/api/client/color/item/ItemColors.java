package com.floofyplasma.stationapi.api.client.color.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.client.color.block.BlockColors;
import com.floofyplasma.stationapi.api.client.event.color.item.ItemColorsRegisterEvent;
import com.floofyplasma.stationapi.api.item.ItemConvertible;
import com.floofyplasma.stationapi.api.registry.ItemRegistry;
import com.floofyplasma.stationapi.api.registry.sync.trackers.IdListTracker;
import com.floofyplasma.stationapi.api.util.collection.IdList;

@Environment(value=EnvType.CLIENT)
public class ItemColors {

    private final IdList<ItemColorProvider> providers = new IdList<>(32);

    public static ItemColors create(BlockColors blockColors) {
        ItemColors itemColors = new ItemColors();
        StationAPI.EVENT_BUS.post(
                ItemColorsRegisterEvent.builder()
                        .blockColors(blockColors)
                        .itemColors(itemColors)
                        .build()
        );
        return itemColors;
    }

    public ItemColors() {
        IdListTracker.register(ItemRegistry.INSTANCE, "ItemColors.providers", providers);
    }

    public int getColor(ItemStack item, int tintIndex) {
        ItemColorProvider itemColorProvider = this.providers.get(ItemRegistry.INSTANCE.getRawId(item.getItem()));
        return itemColorProvider == null ? -1 : itemColorProvider.getColor(item, tintIndex);
    }

    public void register(ItemColorProvider provider, ItemConvertible ... items) {
        for (ItemConvertible itemConvertible : items) {
            this.providers.set(provider, ItemRegistry.INSTANCE.getRawId(itemConvertible.asItem()));
        }
    }
}

