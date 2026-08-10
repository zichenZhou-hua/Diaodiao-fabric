package com.iwdad;


import com.iwdad.init.ModCreativeModeTab;
import com.iwdad.init.ModBlocks;
import com.iwdad.init.ModItems;
import com.iwdad.init.ModParticles;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diaodiao implements ModInitializer {
	public static final String MOD_ID = "diaodiao";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");

		LOGGER.info("物品加载");
		ModItems.initialize();

		LOGGER.info("方块加载");
		ModBlocks.initialize();
		
		LOGGER.info("粒子加载");
		ModParticles.initialize();

		LOGGER.info("创造标签加载");
		ModCreativeModeTab.initialize();


	}
		


}	