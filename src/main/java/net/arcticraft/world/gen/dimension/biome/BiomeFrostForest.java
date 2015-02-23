package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.hostile.EntityFrostZombie;
import net.arcticraft.entities.passive.EntityPenguin;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class BiomeFrostForest extends ACBiomeGenBase {

	public BiomeFrostForest(int par1) {
		super(par1);

		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.topBlock = ACBlocks.frostGrass;
		this.fillerBlock = ACBlocks.frostDirt;
		this.theBiomeDecorator.treesPerChunk = 10;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityFrostZombie.class, 6, 1, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityPenguin.class, 3, 2, 6));
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
	
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
	}
}