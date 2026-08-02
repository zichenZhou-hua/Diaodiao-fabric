package com.iwdad.init;


import com.iwdad.Diaodiao;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModIdmap {


    public static final ResourceKey<Item> MYSTIC_SWORD = createitemkey("mystic_sword");
    public static final ResourceKey<Item> SHIT = createitemkey("shit");
    public static final ResourceKey<Item> TEST_ITEM_TF = createitemkey("test_item_tf");
    public static final ResourceKey<Item> TEST_ITEM_F = createitemkey("test_item_f");

    public static final ResourceKey<Block> SQUAT_TOILET = createblockkey("squat_toilet");
    public static final ResourceKey<Block> CONDENSED_DIRT = createblockkey("condensed_dirt");

    public static ResourceKey<Item> createitemkey(String itemkey) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, itemkey));
    }

    public static ResourceKey<Block> createblockkey(String blockkey) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, blockkey));
    }
}
