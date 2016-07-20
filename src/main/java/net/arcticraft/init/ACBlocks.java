package net.arcticraft.init;

import net.arcticraft.block.BlockAC;
import net.arcticraft.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ACBlocks {
	
	public static final Block FROST_STONE = new BlockAC(References.FROST_STONE, Material.ROCK, SoundType.STONE, 1.5F, 10.0F);
	
	public static void register() {
		GameRegistry.register(FROST_STONE);
		
		//Don't forget Ore Dictionary entries! Pay attention to the string format
	}
	
}
