package com.floofyplasma.stationapi.api.template.block;

import net.minecraft.block.JukeboxBlock;
import com.floofyplasma.stationapi.api.util.Identifier;

public class TemplateJukeboxBlock extends JukeboxBlock implements BlockTemplate {
    public TemplateJukeboxBlock(Identifier identifier, int j) {
        this(BlockTemplate.getNextId(), j);
        BlockTemplate.onConstructor(this, identifier);
    }
    
    public TemplateJukeboxBlock(int i, int j) {
        super(i, j);
    }
}
