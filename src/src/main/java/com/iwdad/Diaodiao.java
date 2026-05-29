package com.iwdad;


import com.iwdad.block.ModBlocks;
import com.iwdad.items.ModItems;

import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.CreativeModeTabs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diaodiao implements ModInitializer {
	public static final String MOD_ID = "diaodiao";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");


		ModItems.initialize();
		
		LOGGER.info("物品加载");
		ModBlocks.initialize();
		LOGGER.info("方块加载");
	}
		


}	