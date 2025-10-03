package com.floofyplasma.stationapi.api.client.render.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import com.floofyplasma.stationapi.api.util.math.Direction;
import com.floofyplasma.stationapi.api.util.math.Vec3f;

@Environment(EnvType.CLIENT)
public record ModelRotation(Vec3f origin, Direction.Axis axis, float angle, boolean rescale) { }
