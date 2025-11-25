package com.uavwaffle.creaturesofpetrichor.entity.varient_enum;

import java.util.Arrays;
import java.util.Comparator;

public enum WillOWispVarient {
    BLUE(0),
    GREEN(1),
    ORANGE(2);

    private static final WillOWispVarient[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(WillOWispVarient::getId)).toArray(WillOWispVarient[]::new);
    private final int id;

    WillOWispVarient(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static WillOWispVarient byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}