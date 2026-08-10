package com.iwdad.init;

import com.iwdad.Diaodiao;


import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;


public class ModItems {
    //物品
    public static final Item TEST_ITEM_F = register(
            ModID.TEST_ITEM_F
    );
    public static final Item TEST_ITEM_TF = register(
            ModID.TEST_ITEM_TF
    );
    public static final Item SHIT = register(
            ModID.SHIT,
            Item::new,
            new Item.Properties().food(
                    new FoodProperties.Builder()
                            .alwaysEdible()
                            .build(),
                    Consumables.defaultFood()
                            .onConsume(new ApplyStatusEffectsConsumeEffect(
                                    new MobEffectInstance(MobEffects.POISON, 6 * 20, 1), 1.2f))
                            .build()
            )
    );


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~动感光波
    //gongju tool
    public static final ToolMaterial MYSTIC_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            4555,
            1111.0F,
            500F,
            225,
            ItemTags.PLANKS

    );
    public static final Item MYSTIC_SWORD = register(
            ModID.MYSTIC_SWORD,
            Item::new,
            new Item.Properties().sword(MYSTIC_TOOL_MATERIAL, 30f, 100f)
                    .fireResistant()
                    .rarity(Rarity.EPIC)

    );
    public static final Item MYSTIC_SWORD_F= register(
            ModID.MYSTIC_SWORD_F,
            Item::new,
            new Item.Properties().sword(MYSTIC_TOOL_MATERIAL, 30f, 100f)
                    .fireResistant()
                    .rarity(Rarity.EPIC)

    );
    //一个武器    上


//

    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));
        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
        return item;
    }
    public static Item register(ResourceKey<Item> itemKey){
        return register(itemKey, Item::new, new Item.Properties());
    }










    @Deprecated //这两个是根据26.1的docs写的”私有“
    private static Item registerItem(final String id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, id));
        Item item = itemFactory.apply(properties.setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }
    @Deprecated
    private static Item registerItem(final String id) {
        return registerItem(id, Item::new, new Item.Properties());
    }


    public static void initialize() {

    }





}

