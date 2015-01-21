package net.arcticraft.world.gen.dimension.biome;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeSnowPlains extends ACBiomeGenBase {
	public BiomeSnowPlains(int par1) {
		super(par1);
		
		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.theBiomeDecorator.treesPerChunk = -999;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.bigMushroomsPerChunk = 0;
		this.temperature = 0.1F;
		
		this.setColor(16777215);
		this.setHeight(new BiomeGenBase.Height(0.1F, 0.1F));
		this.setTemperatureRainfall(0.0F, 0.5F);
	}
	
	@Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);
	}
}