package com.iwdad.init;

import java.util.function.Function;

import com.iwdad.Diaodiao;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockItemId;
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
			ModID.CONDENSED_DIRT,
			Block::new,
			BlockBehaviour.Properties.of().sound(SoundType.STONE),
			true
	);
	public static final Block SQUAT_TOILET= register(
			ModID.SQUAT_TOILET,
			Block::new,
			BlockBehaviour.Properties.of().sound(SoundType.STONE),
			true
	);




	private static Block register(
			BlockItemId id,
			Function<BlockBehaviour.Properties, Block> blockFactory,
			BlockBehaviour.Properties properties,
			boolean hasBlockItem)
		{
		Block block = blockFactory.apply(properties.setId(id.block()));
		Registry.register(BuiltInRegistries.BLOCK, id.block(), block);

		if (hasBlockItem) {
			BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
			Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);
		}

		return block;
	}
	@Deprecated
	private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		Block block = register(id.block(), blockFactory, properties);
		BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
		Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);
		return block;
	}
	@Deprecated
	private static Block register(ResourceKey<Block> id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
		Block block = blockFactory.apply(properties.setId(id));
		return Registry.register(BuiltInRegistries.BLOCK, id, block);
	}
    public static void initialize() {

	}

}