package net.arcticraft.world.gen.dimension;

import net.arcticraft.world.gen.dimension.biome.ACBiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomesDim extends GenLayer {

	protected BiomeGenBase[] allowedBiomes = {ACBiomeGenBase.frostForest, ACBiomeGenBase.glacier, ACBiomeGenBase.snowPlains, ACBiomeGenBase.frostOcean, ACBiomeGenBase.frostMountains};

	public GenLayerBiomesDim(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	public GenLayerBiomesDim(long seed) {
		super(seed);
	}

	@Override
	public int[] getInts(int x, int z, int width, int depth)
	{
		int[] dest = IntCache.getIntCache(width*depth);

		for (int dz=0; dz<depth; dz++)
		{
			for (int dx=0; dx<width; dx++)
			{
				this.initChunkSeed(dx+x, dz+z);
				dest[(dx+dz*width)] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
		}
		return dest;
	}
}