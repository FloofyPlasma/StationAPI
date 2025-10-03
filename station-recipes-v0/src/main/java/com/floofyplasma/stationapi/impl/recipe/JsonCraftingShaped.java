package com.floofyplasma.stationapi.impl.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JsonCraftingShaped extends JsonRecipe {

    private String[] pattern;
}
