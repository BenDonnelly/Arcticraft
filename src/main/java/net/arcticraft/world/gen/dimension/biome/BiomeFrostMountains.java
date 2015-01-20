package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeFrostMountains extends ACBiomeGenBase
{

	public BiomeFrostMountains(int par1)
	{
		super(par1);
		
		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.topBlock =  ACBlocks.frostGrass;
		this.fillerBlock = ACBlocks.frostDirt;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.bigMushroomsPerChunk = 0;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		
		this.setEnableSnow();
		this.setHeight(new BiomeGenBase.Height(0.2F, 2.3F));
		this.setTemperatureRainfall(0.0F, 1.0F);
	}

	@Override
	public WorldGenAbstractTree func_150567_a(Random par1Random)
	{
		return this.genFrostTrees;
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
	}
}