package com.floofyplasma.stationapi.impl.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.floofyplasma.stationapi.api.item.json.JsonItemKey;

@EqualsAndHashCode(callSuper = true)
@Data
public class JsonSmelting extends JsonRecipe {

    private JsonItemKey ingredient;
}
