package com.floofyplasma.stationapi.api.item.json;

import com.mojang.datafixers.util.Either;
import lombok.Data;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import com.floofyplasma.stationapi.api.registry.ItemRegistry;
import com.floofyplasma.stationapi.api.tag.TagKey;

import static com.floofyplasma.stationapi.api.util.Identifier.of;

@Data
public class JsonItemKey {
    private String item;
    private int count = 1;
    private int damage = 0;
    private String tag;

    public ItemStack getItemStack() {
        Item item = ItemRegistry.INSTANCE.get(of(this.item));
        return item == null ? null : new ItemStack(item, count, damage);
    }

    public TagKey<Item> getTag() {
        return TagKey.of(ItemRegistry.KEY, of(tag));
    }

    public Either<ItemStack, TagKey<Item>> get() {
        if (item == null && tag != null)
            return Either.right(getTag());
        else if (item != null && tag == null)
            return Either.left(getItemStack());
        else throw new IllegalStateException("Neither item nor tag, or both are specified in the JsonItemKey!");
    }
}