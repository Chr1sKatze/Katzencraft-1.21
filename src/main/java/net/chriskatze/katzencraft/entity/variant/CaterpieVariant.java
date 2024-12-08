package net.chriskatze.katzencraft.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CaterpieVariant {
    MALE(0),
    FEMALE(1);

    private static final CaterpieVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(
            CaterpieVariant::getId)).toArray(CaterpieVariant[]::new);
    private final int id;

    CaterpieVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return  this.id;
    }

    public static CaterpieVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
