package net.arcticraft.world.gen;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkGenerator;

public class ChunkProviderArctic implements IChunkGenerator {

	private final int SIZE = 16; //Duh
	
	private World world;
	private boolean mapFeatures;
	private Random rand;
	
	private Biome[] biomes;
	//TODO instantiate noise and world generators (e.g. ores) here

	public ChunkProviderArctic(World worldIn, boolean features, long seed)
    {
        this.world = worldIn;
        this.mapFeatures = features;
        this.rand = new Random(seed);
    }
	
	@Override
	public Chunk provideChunk(int x, int z) {
		this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		this.biomes = this.world.getBiomeProvider().loadBlockGeneratorData(this.biomes, x * SIZE, z * SIZE, SIZE, SIZE);
		
		ChunkPrimer chunkprimer = new ChunkPrimer();
		Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
		byte[] biomeIDs = chunk.getBiomeArray();

        for (int i = 0; i < biomeIDs.length; ++i)
        {
        	biomeIDs[i] = (byte)Biome.getIdForBiome(this.biomes[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
	}

	@Override
	public void populate(int x, int z) {
		// TODO generators
		
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int x, int z) {
		// Unused?
		return false;
	}

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
		return this.world.getBiomeGenForCoords(pos).getSpawnableList(creatureType);
	}

	@Override
	public BlockPos getStrongholdGen(World worldIn, String structureName, BlockPos position) {
		return null;
	}

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		// TODO Auto-generated method stub
		
	}

}
