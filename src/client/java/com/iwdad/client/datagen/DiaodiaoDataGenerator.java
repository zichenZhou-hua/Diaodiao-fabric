package com.iwdad.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DiaodiaoDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {


		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(DiaodiaoModEnglishLangProvider::new);
		pack.addProvider(DiaodiaoModSChineseLangProvider::new);
	}
}
