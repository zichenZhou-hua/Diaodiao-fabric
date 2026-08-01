package com.iwdad.client;

import com.iwdad.Diaodiao;
import com.iwdad.items.ModParticles;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.EndRodParticle;

public class DiaodiaoClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ParticleProviderRegistry.getInstance().register(ModParticles.SPARKLE_PARTICLE, EndRodParticle.Provider::new);
	}
}