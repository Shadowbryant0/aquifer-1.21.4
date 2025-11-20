package net.shadow.aquifer;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.shadow.aquifer.entity.AquiferEntities;
import net.shadow.aquifer.entity.ErrorzArrowRenderer;

public class AquiferClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(AquiferEntities.TEAR, ErrorzArrowRenderer::new);
    }
}
