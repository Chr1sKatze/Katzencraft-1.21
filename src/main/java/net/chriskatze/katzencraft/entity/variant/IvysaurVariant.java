package net.chriskatze.katzencraft.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum IvysaurVariant {
    MALE(0),
    FEMALE(1);

    private static final IvysaurVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.comparingInt(
            IvysaurVariant::getId)).toArray(IvysaurVariant[]::new);
    private final int id;

    IvysaurVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return  this.id;
    }

    public static IvysaurVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}