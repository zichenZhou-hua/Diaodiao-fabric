package com.iwdad.init;


import com.iwdad.Diaodiao;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;


public class ModID {
    public static final ResourceKey<Item> MYSTIC_SWORD = createitem("mystic_sword");
    public static final ResourceKey<Item> SHIT = createitem("shit");
    public static final ResourceKey<Item> TEST_ITEM_TF = createitem("test_item_tf");
    public static final ResourceKey<Item> TEST_ITEM_F = createitem("test_item_f");
    public static final ResourceKey<Item> MYSTIC_SWORD_F = createitem("mystic_sword_f");
    public static final BlockItemId CONDENSED_DIRT =createblockitem("condensed_dirt") ;
    public static final BlockItemId SQUAT_TOILET = createblockitem("squat_toilet");

    //物品 ID create方法
    public static ResourceKey<Item> createitem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, name));
    }
    //带物品方块的方块 ID create方法
    private static BlockItemId createblockitem(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, name);
        return BlockItemId.create(id, id);
    }
    //不带带物品方块的方块 ID create方法
    private static ResourceKey<Block> createblock(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, name);
        return ResourceKey.create(Registries.BLOCK, id);
    }

}
