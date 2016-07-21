package net.arcticraft.init;

import net.arcticraft.util.References;
import net.arcticraft.world.biome.BiomeSnowPlains;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.BiomeProperties;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ACBiomes {
	
	public static final BiomeProperties SNOW_PLAINS_PROPERTIES = (new Biome.BiomeProperties(References.SNOW_PLAINS_NAME)).setTemperature(0.1F).setRainfall(0.9F).setWaterColor(0xFFFFFF);
	
	public static final Biome SNOW_PLAINS = new BiomeSnowPlains();
	
	public static void register() {
		GameRegistry.register(SNOW_PLAINS);
		
		BiomeDictionary.registerBiomeType(SNOW_PLAINS, Type.PLAINS, Type.COLD, Type.SPARSE);
	}
}
