package com.floofyplasma.stationapi.impl.recipe;

import com.google.gson.Gson;
import net.mine_diver.unsafeevents.listener.EventListener;
import com.floofyplasma.stationapi.api.StationAPI;
import com.floofyplasma.stationapi.api.event.mod.PreInitEvent;
import com.floofyplasma.stationapi.api.mod.entrypoint.Entrypoint;
import com.floofyplasma.stationapi.api.mod.entrypoint.EntrypointManager;
import com.floofyplasma.stationapi.api.mod.entrypoint.EventBusPolicy;
import com.floofyplasma.stationapi.api.registry.JsonRecipesRegistry;
import com.floofyplasma.stationapi.api.registry.Registry;
import com.floofyplasma.stationapi.api.resource.Filters;
import com.floofyplasma.stationapi.api.resource.ResourceHelper;
import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.util.exception.MissingModException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.invoke.MethodHandles;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;

import static com.floofyplasma.stationapi.api.StationAPI.LOGGER;
import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

@Entrypoint(eventBus = @EventBusPolicy(registerInstance = false))
@EventListener(phase = StationAPI.INTERNAL_PHASE)
public class JsonRecipesLoader {
    static {
        EntrypointManager.registerLookup(MethodHandles.lookup());
    }

    @EventListener
    private static void loadJsonRecipes(PreInitEvent event) {
        LOGGER.info("Searching for JSON recipes...");
        String recipePath = NAMESPACE + "/recipes";
        ResourceHelper.DATA.find(recipePath, Filters.FileType.JSON).forEach(JsonRecipesLoader::registerRecipe);
        ResourceHelper.ASSETS.find(recipePath, Filters.FileType.JSON).forEach(recipe -> {
            LOGGER.warn("Found a recipe (" + recipe + ") under assets directory, which is deprecated for recipes!");
            registerRecipe(recipe);
        });
    }

    private static void registerRecipe(URL recipe) {
        try {
            String rawId = new Gson().fromJson(new InputStreamReader(recipe.openStream()), JsonRecipeType.class).getType();
            Identifier recipeId;
            try {
                recipeId = Identifier.of(rawId);
            } catch (MissingModException e) {
                LOGGER.warn("Found an unknown recipe type " + rawId + ". Ignoring.");
                return;
            }
            if (!JsonRecipesRegistry.INSTANCE.containsId(recipeId))
                Registry.register(JsonRecipesRegistry.INSTANCE, recipeId, new HashSet<>());
            Objects.requireNonNull(JsonRecipesRegistry.INSTANCE.get(recipeId)).add(recipe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
