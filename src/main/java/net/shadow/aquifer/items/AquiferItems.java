package net.shadow.aquifer.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.shadow.aquifer.Aquifer;
import net.shadow.aquifer.items.weapons.DragonsEye;

import java.util.function.Function;

public class AquiferItems {
    public static final Item DRAGONS_BREATH = registerItem("dragons_eye", setting -> new DragonsEye(setting.fireproof().maxCount(1).rarity(Rarity.EPIC)));



    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Aquifer.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Aquifer.MOD_ID, name)))));
    }

    public static void registerAquiferItems() {
        Aquifer.LOGGER.info("Filtering the files for" + Aquifer.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {entries.add(DRAGONS_BREATH);
        });
    }
}
