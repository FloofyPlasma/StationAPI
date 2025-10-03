package com.floofyplasma.stationapi.api.recipe;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.SmeltingRecipeManager;
import com.floofyplasma.stationapi.api.tag.TagKey;
import com.floofyplasma.stationapi.api.util.API;
import com.floofyplasma.stationapi.mixin.recipe.SmeltingRecipeManagerAccessor;

import java.util.Map;

public final class SmeltingRegistry {

    @API
    public static void addSmeltingRecipe(int input, ItemStack output) {
        ((SmeltingRecipeManagerAccessor) SmeltingRecipeManager.getInstance()).getRecipes().put(input, output);
    }

    @API
    public static void addSmeltingRecipe(ItemStack input, ItemStack output) {
        ((SmeltingRecipeManagerAccessor) SmeltingRecipeManager.getInstance()).getRecipes().put(input, output);
    }

    @API
    public static void addSmeltingRecipe(TagKey<Item> input, ItemStack output) {
        ((SmeltingRecipeManagerAccessor) SmeltingRecipeManager.getInstance()).getRecipes().put(input, output);
    }

    @API
    public static ItemStack getResultFor(ItemStack input) {
        for (Map.Entry<Object, ItemStack> entry : ((SmeltingRecipeManagerAccessor) SmeltingRecipeManager.getInstance()).getRecipes().entrySet()) {
            Object o = entry.getKey();
            //noinspection unchecked,ConstantConditions
            if (o instanceof ItemStack item && input.isItemEqual(item) || o instanceof TagKey<?> tag && input.isIn((TagKey<Item>) tag))
                return entry.getValue();
        }
        return SmeltingRecipeManager.getInstance().craft(input.getItem().id);
    }
}
