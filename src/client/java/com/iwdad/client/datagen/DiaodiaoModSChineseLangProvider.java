package com.iwdad.client.datagen;

import java.util.concurrent.CompletableFuture;

import com.iwdad.init.ModItems;
import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class DiaodiaoModSChineseLangProvider extends FabricLanguageProvider {
    protected DiaodiaoModSChineseLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        // Specifying en_us is optional, as it's the default language code
        super(dataOutput, "zh_cn", registryLookup);
    }
    public void generateTranslations(HolderLookup.Provider holderLookup, TranslationBuilder translationBuilder) {


        translationBuilder.add(ModItems.TEST_ITEM_TF, "语言生成测试物品tf");
    }

}
