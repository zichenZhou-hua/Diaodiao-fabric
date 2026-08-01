package com.iwdad.items;

import com.iwdad.Diaodiao;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;


public class ModParticles  {
    public static final SimpleParticleType SPARKLE_PARTICLE = FabricParticleTypes.simple();

    public static void initialize() {
        Registry.register(BuiltInRegistries.PARTICLE_TYPE, Identifier.fromNamespaceAndPath(Diaodiao.MOD_ID, "sparkle_particle"), SPARKLE_PARTICLE);
    }
}
