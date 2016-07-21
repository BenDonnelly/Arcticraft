package net.arcticraft.init;

import net.arcticraft.block.BlockAC;
import net.arcticraft.util.References;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class ACBlocks {
	
	public static final Block FROST_STONE = new BlockAC(References.FROST_STONE, Material.ROCK, SoundType.STONE, 1.5F, 10.0F);
	
	public static void register() {
		registerBlock(FROST_STONE);
		
		//Don't forget Ore Dictionary entries! Pay attention to the string format
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register((new ItemBlock(block)).setRegistryName(block.getRegistryName()));
	}
	
}
