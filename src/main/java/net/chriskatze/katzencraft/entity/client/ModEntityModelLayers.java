package net.chriskatze.katzencraft.entity.client;

import net.chriskatze.katzencraft.KatzencraftMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityModelLayers {
    public static final EntityModelLayer BULBASAUR =
            new EntityModelLayer(Identifier.of(KatzencraftMod.MOD_ID, "bulbasaur"), "main");
    public static final EntityModelLayer IVYSAUR =
            new EntityModelLayer(Identifier.of(KatzencraftMod.MOD_ID, "ivysaur"), "main");
    public static final EntityModelLayer CATERPIE =
            new EntityModelLayer(Identifier.of(KatzencraftMod.MOD_ID, "caterpie"), "main");
}
