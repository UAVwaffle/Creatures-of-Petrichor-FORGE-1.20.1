package com.uavwaffle.creaturesofpetrichor.entity.varient_enum;

import java.util.Arrays;
import java.util.Comparator;

public enum ShroominVarient {
    RED(0),
    BROWN(1);

    private static final ShroominVarient[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ShroominVarient::getId)).toArray(ShroominVarient[]::new);
    private final int id;

    ShroominVarient(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ShroominVarient byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}