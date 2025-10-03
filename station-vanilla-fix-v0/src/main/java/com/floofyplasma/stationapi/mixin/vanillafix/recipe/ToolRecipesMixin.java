package com.floofyplasma.stationapi.mixin.vanillafix.recipe;

import com.llamalad7.mixinextras.injector.WrapWithCondition;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CraftingRecipeManager;
import net.minecraft.recipe.ToolRecipes;
import com.floofyplasma.stationapi.api.recipe.CraftingRegistry;
import com.floofyplasma.stationapi.impl.vanillafix.recipe.VanillaTagRecipeFixImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolRecipes.class)
class ToolRecipesMixin {
    @WrapWithCondition(
            method = "add",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/recipe/CraftingRecipeManager;addShapedRecipe(Lnet/minecraft/item/ItemStack;[Ljava/lang/Object;)V"
            )
    )
    private boolean stationapi_tagifyShapedRecipes(
            CraftingRecipeManager registry, ItemStack result, Object[] ingredientMap
    ) {
        boolean tagified = VanillaTagRecipeFixImpl.tagifyIngredients(ingredientMap);
        if (tagified) CraftingRegistry.addShapedRecipe(result, ingredientMap);
        return !tagified;
    }
}
