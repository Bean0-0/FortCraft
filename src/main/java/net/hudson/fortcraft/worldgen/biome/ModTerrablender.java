package net.hudson.fortcraft.worldgen.biome;

import net.hudson.fortcraft.FortCraft;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerrablender {
    public static void registerBiomes() {
        Regions.register(new ModOverworldRegion(new ResourceLocation(FortCraft.MOD_ID, "overworld"), 5));
    }
}
