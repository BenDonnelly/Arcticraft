package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.entities.passive.EntityHusky;
import net.arcticraft.entities.passive.EntityMammoth;
import net.arcticraft.entities.passive.EntityPolarBear;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSnowPlains extends ACBiomeGenBase {
	public BiomeSnowPlains(int par1) {
		super(par1);
		
		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.bigMushroomsPerChunk = 0;
		this.spawnableMonsterList.add(new SpawnListEntry(EntityMammoth.class, 1, 1,1 ));
		this.spawnableCreatureList.add(new SpawnListEntry(EntityHusky.class, 1, 1, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityPolarBear.class, 1, 1, 2));
		this.spawnableMonsterList.add(new SpawnListEntry(EntityBoar.class, 1, 1, 3));
		this.temperature = 0.1F;
		
		this.setColor(16777215);
		this.setHeight(new BiomeGenBase.Height(0.1F, 0.1F));
		this.setTemperatureRainfall(0.1F, 0.9F);
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
	}
}