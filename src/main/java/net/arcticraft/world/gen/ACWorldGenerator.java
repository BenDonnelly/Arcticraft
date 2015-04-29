package net.arcticraft.world.gen;

import java.util.Random;

import net.arcticraft.world.gen.dimension.biome.BiomeSnowPlains;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class ACWorldGenerator implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId) {
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);

		case 3:
			//generateArctic(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateArctic(World world, Random random, int BlockX, int BlockZ)
	{
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(BlockX, BlockZ);
		if((biome instanceof BiomeSnowPlains))
		{
			{
				for(int k = 0; k < 2; k++)
				{
					int RandPosX = BlockX + random.nextInt(16);
					int RandPosY = random.nextInt(128);
					int RandPosZ = BlockZ + random.nextInt(16);
					(new WorldGenEskimoVillage()).generate(world, random, RandPosX, RandPosY, RandPosZ);
				}
			}
		}
	}

	public void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		int x = chunkX * 16 + rand.nextInt(16);
		int y = 256;
		int z = chunkZ * 16 + rand.nextInt(16);
		
		if(world.provider.dimensionId == 0 && (world.getBiomeGenForCoords(x, z) == BiomeGenBase.iceMountains || world.getBiomeGenForCoords(x, z) == BiomeGenBase.icePlains))
		{
			for (int i = 0; i < 1; i++)
			{
				int max = 750;
				int min = 0;
				int r = new Random().nextInt(max - min) + min;
				
				if(r == 5)
				{
					while(y > 0 && world.getBlock(x, y - 1, z) != Blocks.grass) y--;

					if(world.getBlock(x, y - 1, z) != Blocks.grass)
					{
						return;
					}

					(new WorldGenMageTower()).generate(world, rand, x, y, z);
				}
			}
		}
	}

	public void generateNether(World world, Random ran, int baseX, int baseZ)
	{

	}

	public void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{

	}

}
