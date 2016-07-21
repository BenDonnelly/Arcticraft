package net.arcticraft.world.biome;

import java.util.Random;

import net.arcticraft.init.ACBiomes;
import net.arcticraft.init.ACBlocks;
import net.arcticraft.util.References;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BiomeSnowPlains extends BiomeAC {

	public BiomeSnowPlains() {
		super(References.SNOW_PLAINS_ID, ACBiomes.SNOW_PLAINS_PROPERTIES);
		this.topBlock = Blocks.GRASS.getDefaultState();
		this.fillerBlock = ACBlocks.FROST_STONE.getDefaultState();
		this.theBiomeDecorator.treesPerChunk = -999;
	}
	
	@Override
	public void decorate(World worldIn, Random rand, BlockPos pos) {
		//TODO custom generators
		
		super.decorate(worldIn, rand, pos);
	}

}
