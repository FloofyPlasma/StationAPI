package com.floofyplasma.stationapi.api.registry;

import com.mojang.serialization.Lifecycle;
import com.floofyplasma.stationapi.api.event.recipe.RecipeRegisterEvent;

import java.net.URL;
import java.util.function.Consumer;

import static com.floofyplasma.stationapi.api.StationAPI.NAMESPACE;

/**
 * The JSON recipe parser registry that holds all JSON recipe parsers to automatically run when {@link RecipeRegisterEvent} event is called with a proper identifier.
 * @author mine_diver
 */
public final class JsonRecipeParserRegistry extends SimpleRegistry<Consumer<URL>> {

    public static final RegistryKey<JsonRecipeParserRegistry> KEY = RegistryKey.ofRegistry(NAMESPACE.id("json_recipe_parsers"));
    public static final JsonRecipeParserRegistry INSTANCE = Registries.create(KEY, new JsonRecipeParserRegistry(), Lifecycle.experimental());

    private JsonRecipeParserRegistry() {
        super(KEY, Lifecycle.experimental(), false);
    }
}
