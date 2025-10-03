package com.floofyplasma.sltest.entity;

import lombok.Getter;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import com.floofyplasma.sltest.SLTest;
import com.floofyplasma.stationapi.api.server.entity.HasTrackingParameters;
import com.floofyplasma.stationapi.api.server.entity.MobSpawnDataProvider;
import com.floofyplasma.stationapi.api.util.Identifier;

import static com.floofyplasma.sltest.SLTest.NAMESPACE;
import static com.floofyplasma.stationapi.api.util.Identifier.of;

@HasTrackingParameters(trackingDistance = 5, updatePeriod = 2)
public class PoorGuy extends AnimalEntity implements MobSpawnDataProvider {

    public PoorGuy(World arg) {
        super(arg);
        SLTest.LOGGER.info("well guess im dead");
        texture = "/assets/sltest/textures/entities/geisterspoor.png";
    }

//    public PoorGuy(Level level, double x, double y, double z) {
//        this(level);
//        System.out.println("yoooooooooooooooooooooooo");
//        setPosition(x, y, z);
//        field_1026 = true;
//    }

    @Override
    protected int method_914() {
        return Item.WHEAT.id;
    }

    @Getter
    private final Identifier handlerIdentifier = of(NAMESPACE, "gpoor");
}
