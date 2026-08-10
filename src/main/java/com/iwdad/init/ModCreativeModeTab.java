package com.iwdad.init;

import com.iwdad.Diaodiao;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemLore;

import java.util.List;

public class ModCreativeModeTab {
    public static final ResourceKey<CreativeModeTab> CUSTOM_CREATIVE_TAB_KEY = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(), Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, "diaodiao_tab")
    );
    public static final CreativeModeTab CUSTOM_CREATIVE_TAB = FabricCreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.TEST_ITEM_F))
            .title(Component.translatable("creativeTab.diaodiao"))
            .displayItems((params, init) -> {
                init.accept(ModItems.SHIT);
                ItemStack mystic_sword = new ItemStack(ModItems.MYSTIC_SWORD);
                mystic_sword.set(DataComponents.ITEM_NAME, Component.literal("超级无敌捣屎棍"));
                mystic_sword.set(DataComponents.LORE, new ItemLore(List.of(Component.literal("物品栏限定版").withStyle(ChatFormatting.WHITE))));
                init.accept(mystic_sword);
                
                init.accept(ModBlocks.CONDENSED_DIRT);
                init.accept(ModItems.TEST_ITEM_F);
                init.accept(ModItems.TEST_ITEM_TF);
                init.accept(ModBlocks.SQUAT_TOILET);
            })
            .build();
    public static void initialize() {

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, CUSTOM_CREATIVE_TAB_KEY, CUSTOM_CREATIVE_TAB);
    }
}
