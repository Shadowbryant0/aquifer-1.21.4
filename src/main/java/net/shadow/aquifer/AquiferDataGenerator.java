package net.shadow.aquifer;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.shadow.aquifer.datagen.AquiferEntityProvider;
import net.shadow.aquifer.datagen.AquiferItemTagProvider;
import net.shadow.aquifer.datagen.AquiferModelProvider;

public class AquiferDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
            FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();


        pack.addProvider(AquiferItemTagProvider::new);
        pack.addProvider(AquiferModelProvider::new);
        pack.addProvider(AquiferEntityProvider::new);
    }

}
