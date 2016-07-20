package net.arcticraft.world.gen.feature;

import java.util.Random;

import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenMageTower implements IWorldGenerator {

	// This should implement IWorldGenerator since it injects into vanilla (world) code
	
	public static void register() {
		GameRegistry.registerWorldGenerator(new WorldGenMageTower(), 5);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimensionType().equals(DimensionType.OVERWORLD)) {
			//TODO generate mage tower
		}
	}

}
