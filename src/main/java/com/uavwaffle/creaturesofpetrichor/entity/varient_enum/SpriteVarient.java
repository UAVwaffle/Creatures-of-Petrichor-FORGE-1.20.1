package com.uavwaffle.creaturesofpetrichor.entity.varient_enum;

import java.util.Arrays;
import java.util.Comparator;

public enum SpriteVarient {
    GREEN(0),
    YELLOW(1),
    RED(2);

    private static final SpriteVarient[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(SpriteVarient::getId)).toArray(SpriteVarient[]::new);
    private final int id;

    SpriteVarient(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static SpriteVarient byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}