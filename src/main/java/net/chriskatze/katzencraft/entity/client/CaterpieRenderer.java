package net.chriskatze.katzencraft.entity.client;

import com.google.common.collect.Maps;
import net.chriskatze.katzencraft.KatzencraftMod;
import net.chriskatze.katzencraft.entity.custom.CaterpieEntity;
import net.chriskatze.katzencraft.entity.variant.CaterpieVariant;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class CaterpieRenderer extends MobEntityRenderer<CaterpieRenderer, CaterpieModel> {
    // USE THIS IF YOU HAVE VARIANTS
    //------------------------------------------------------------------------------------------------------------------
    private static final Map<CaterpieVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(CaterpieVariant.class), map -> {
                map.put(CaterpieVariant.MALE, Identifier.of(KatzencraftMod.MOD_ID, "textures/entity/caterpie/caterpie_m.png"));
                map.put(CaterpieVariant.FEMALE, Identifier.of(KatzencraftMod.MOD_ID, "textures/entity/caterpie/caterpie_f.png"));
            });
    //------------------------------------------------------------------------------------------------------------------
    public CaterpieRenderer(EntityRendererFactory.Context context) {
        super(context, new CaterpieModel(context.getPart(ModEntityModelLayers.CATERPIE)), 0.5f);
    }

    @Override
    public Identifier getTexture(CaterpieEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    // THIS IS THE SIZE OF THE CHILD
    @Override
    public void render(CaterpieEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.65f, 0.65f, 0.65f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}