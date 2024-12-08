package net.chriskatze.katzencraft;

import net.chriskatze.katzencraft.block.ModBlocks;
import net.chriskatze.katzencraft.entity.ModEntities;
import net.chriskatze.katzencraft.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class KatzencraftModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        // TRANSPARENCY FOR TEXTURES -----------------------------------------------------------------------------------
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRAWBERRY_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GERSTEN_BOTTOM_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GERSTEN_TOP_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DAHLIA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_DAHLIA, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.BULBASAUR, BulbasaurModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BULBASAUR, BulbasaurRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.IVYSAUR, IvysaurModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.IVYSAUR, IvysaurRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModEntityModelLayers.CATERPIE, CaterpieModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CATERPIE, CaterpieRenderer::new);
    }
}