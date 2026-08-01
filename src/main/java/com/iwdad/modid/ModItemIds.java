package com.iwdad.modid;


import com.iwdad.Diaodiao;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;


public class ModItemIds {


    public static final ResourceKey<Item> MYSTIC_SWORD = createAkey("mystic_sword");
    public static final ResourceKey<Item> SHIT = createAkey("shit");
    public static final ResourceKey<Item> TEST_ITEM_TF = createAkey("test_item_tf");
    public static final ResourceKey<Item> TEST_ITEM_F = createAkey("test_item_f");



    public static ResourceKey<Item> createAkey(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, name));
    }
}
