package net.arcticraft.world.gen.dimension.biome;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.passive.EntityPenguin;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;

public class BiomeIceHills extends ACBiomeGenBase {
	public BiomeIceHills(int par1) {
		super(par1);
		
		this.theBiomeDecorator = new ACBiomeDecorator(this);
		this.topBlock = ACBlocks.frostWaterIce;
		this.fillerBlock = ACBlocks.frostWaterIce;	
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.theBiomeDecorator.bigMushroomsPerChunk = 0;
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.temperature = 0.1F;
		
		this.setTemperatureRainfall(0.1F, 0.9F);
		this.setDisableRain();
		this.setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
		this.setColor(16777215);
	}
}