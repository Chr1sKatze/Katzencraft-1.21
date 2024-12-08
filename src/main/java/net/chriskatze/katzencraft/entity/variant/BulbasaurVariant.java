package net.chriskatze.katzencraft.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum BulbasaurVariant {
    MALE(0),
    FEMALE(1);

    private static final BulbasaurVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(
            BulbasaurVariant::getId)).toArray(BulbasaurVariant[]::new);
    private final int id;

    BulbasaurVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return  this.id;
    }

    public static BulbasaurVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}