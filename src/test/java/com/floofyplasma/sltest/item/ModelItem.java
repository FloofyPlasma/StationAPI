package com.floofyplasma.sltest.item;

import com.floofyplasma.stationapi.api.util.Identifier;
import com.floofyplasma.stationapi.api.template.item.TemplateItem;

public class ModelItem extends TemplateItem/* implements ItemModelProvider*/ {

    public ModelItem(Identifier identifier) {
        super(identifier);
    }

//    @Override
//    public Model getModel(int damage) {
//        return TextureListener.testItemModel;
//    }
}
