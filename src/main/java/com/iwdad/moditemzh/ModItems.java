package com.iwdad.moditemzh;


import java.util.function.Function;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.tags.BlockTags;

public class ModItems {
    public static final Item TEST_ITEM_F = registerItem("test_item_f");
    /*public static final Item TEST_ITEM_F = registerItem("test_item_f");
    public static final Item TEST_ITEM_F = registerItem("test_item_f");
    public static final Item TEST_ITEM_F = registerItem("test_item_f");*/

    //public static final ToolMaterial GUIDITE_TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL,455,5.0F,1.5F,22,GuiditeArmorMaterial.REPAIRS_GUIDITE_ARMOR);


    private static Item registerItem(final String id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("diaodiao", id));
	    Item item = (Item)itemFactory.apply(properties.setId(key));
	    if (item instanceof BlockItem blockItem) {
	        blockItem.registerBlocks(Item.BY_BLOCK, item);
	    }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }


	private static Item registerItem(final String id) {
		return registerItem(id, Item::new, new Item.Properties());
	}
    




    private static void register() {}// 物品注册,空
    


    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
		.register((creativeTab) -> creativeTab.accept(TEST_ITEM_F));
    }
}
