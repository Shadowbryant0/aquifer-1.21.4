package net.shadow.aquifer.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.shadow.aquifer.entity.AquiferEntities;
import net.shadow.aquifer.items.AquiferItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class AquiferItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public AquiferItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE)
                .add(AquiferItems.DRAGONS_BREATH);
    }
}
