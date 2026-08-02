package com.iwdad.init;

import java.util.function.Function;

import com.iwdad.Diaodiao;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;


public class ModBlocks {
	
    public static final Block CONDENSED_DIRT = register(
		    ModIdmap.CONDENSED_DIRT,
		    Block::new,
		    BlockBehaviour.Properties.of().sound(SoundType.GRASS)
    );
	public static final Block SQUAT_TOILET  = register(ModIdmap.SQUAT_TOILET,

			Block::new,
			BlockBehaviour.Properties.of().sound(SoundType.GRASS)
	);


	private static Block register(ResourceKey<Block> blockkey, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		// Create the block instance
		Block block = blockFactory.apply(properties.setId(blockkey));

		return Registry.register(BuiltInRegistries.BLOCK, blockkey, block);
	}






	@Deprecated
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
		ResourceKey<Block> blockKey = keyOfBlock(name);
		Block block = blockFactory.apply(settings.setId(blockKey));
		if (shouldRegisterItem) {
			ResourceKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}
	@Deprecated
	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, name));
	}
	@Deprecated
	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, name));
	}

    public static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((creativeTab) -> {
			creativeTab.accept(ModBlocks.CONDENSED_DIRT.asItem());
		});


	}

}