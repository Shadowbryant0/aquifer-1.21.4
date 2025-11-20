package net.shadow.aquifer.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.shadow.aquifer.entity.AquiferEntities;

import java.util.concurrent.CompletableFuture;

public class AquiferEntityProvider extends FabricTagProvider.EntityTypeTagProvider{
    public AquiferEntityProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(EntityTypeTags.ARROWS)
                .add(AquiferEntities.TEAR);
    }
}
