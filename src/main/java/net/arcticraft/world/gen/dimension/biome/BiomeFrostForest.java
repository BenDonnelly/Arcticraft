package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.hostile.EntityFrostZombie;
import net.arcticraft.world.gen.WorldGenCaveman;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeFrostForest extends ACBiomeGenBase{

	public BiomeFrostForest(int par1){
		super(par1);

		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.topBlock = ACBlocks.frostGrass;
		this.fillerBlock = ACBlocks.frostDirt;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostZombie.class, 1, 1, 3));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityWolf.class, 1, 1, 4));
		// this.spawnableCreatureList.add(new SpawnListEntry(EntityPenguin.class, 3, 2, 6));
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.bigMushroomsPerChunk = 0;
		this.temperature = 0.1F;

		this.setTemperatureRainfall(0.1F, 0.9F);
		this.setColor(16777215);
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random par1Random)
	{
		return this.genFrostTrees;
	}

	public void decorate(World world, Random rand, int x, int z)
	{
		super.decorate(world, rand, x, z);
		if(rand.nextInt(600) == 1)
		{
			int k = x + rand.nextInt(16) + 8;
			int l = z + rand.nextInt(16) + 8;
			WorldGenCaveman caveman = new WorldGenCaveman();
			caveman.generate(world, rand, k, world.getHeightValue(k, l) + 1, l);
		}
	}
}
