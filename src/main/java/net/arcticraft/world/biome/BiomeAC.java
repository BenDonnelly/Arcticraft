package net.arcticraft.world.biome;

import net.arcticraft.util.References;
import net.minecraft.world.biome.Biome;

public class BiomeAC extends Biome {

	public BiomeAC(String name, BiomeProperties properties) {
		super(properties.setSnowEnabled());
		this.setRegistryName(References.MOD_ID, name);
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
	}

}
