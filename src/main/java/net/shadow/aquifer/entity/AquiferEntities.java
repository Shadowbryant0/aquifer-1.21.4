package net.shadow.aquifer.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.shadow.aquifer.Aquifer;
import net.shadow.aquifer.entity.projectile.DragonsTear;

public class AquiferEntities {
    private static final RegistryKey<EntityType<?>> ARROW_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Aquifer.MOD_ID, "tear"));
    public static final EntityType<DragonsTear> TEAR = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Aquifer.MOD_ID, "ocean"),
            EntityType.Builder.<DragonsTear>create(DragonsTear::new, SpawnGroup.MISC).dimensions(0.5f, 1.15f).build(ARROW_KEY)
    );
    public static void registerModEntities() {
        Aquifer.LOGGER.info("Registering Mod Entities for " + Aquifer.MOD_ID);
    }
}