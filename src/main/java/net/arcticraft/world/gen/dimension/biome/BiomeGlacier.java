package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.passive.EntityArcticGhost;
import net.arcticraft.entities.passive.EntityPolarBear;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGlacier extends ACBiomeGenBase {
	public BiomeGlacier(int par1) {
		super(par1);
		
		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.topBlock = Blocks.snow;
		this.fillerBlock = ACBlocks.frostWaterIce;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.bigMushroomsPerChunk = 0;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableMonsterList.add(new SpawnListEntry(EntityPolarBear.class, 5, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityArcticGhost.class, 1, 1, 1));
		//this.spawnableCreatureList.add(new SpawnListEntry(EntityPenguin.class, 8, 2, 6));
		this.temperature = 0.1F;
		
		this.setTemperatureRainfall(0.1F, 0.9F);
		this.setHeight(new BiomeGenBase.Height(0.2F, 2.1F));
	}
	
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
	}
}