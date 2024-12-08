package net.chriskatze.katzencraft.entity.client;

import com.google.common.collect.Maps;
import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.entity.custom.BulbasaurEntity;
import net.chriskatze.katzencraft.entity.variant.BulbasaurVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class BulbasaurRenderer extends MobEntityRenderer<BulbasaurEntity, BulbasaurModel> {
    // USE THIS IF YOU HAVE VARIANTS
    //------------------------------------------------------------------------------------------------------------------
    private static final Map<BulbasaurVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BulbasaurVariant.class), map -> {
                map.put(BulbasaurVariant.MALE, Identifier.of(KatzencraftMod.MOD_ID, "textures/entity/bulbasaur/bulbasaur_m.png"));
                map.put(BulbasaurVariant.FEMALE, Identifier.of(KatzencraftMod.MOD_ID, "textures/entity/bulbasaur/bulbasaur_f.png"));
            });
    //------------------------------------------------------------------------------------------------------------------
    public BulbasaurRenderer(EntityRendererFactory.Context context) {
        super(context, new BulbasaurModel(context.getPart(ModEntityModelLayers.BULBASAUR)), 0.5f);
    }

    @Override
    public Identifier getTexture(BulbasaurEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
        // USE THIS IF YOU HAVE NO VARIANTS
        // Identifier.of(KatzencraftMod.MOD_ID, "textures/entity/bulbasaur/bulbasaur_m.png");
    }

    // THIS IS THE SIZE OF THE CHILD
    @Override
    public void render(BulbasaurEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.65f, 0.65f, 0.65f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}