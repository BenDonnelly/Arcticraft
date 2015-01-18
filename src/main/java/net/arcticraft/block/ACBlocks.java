package net.arcticraft.block;

import net.arcticraft.items.ItemLeafBlocks;
import net.arcticraft.items.ItemLogBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACBlocks{

	public static void loadBlocks()
	{
		initBlocks();
		registerBlocks();
	}

	/* Core Dimension Blocks */
	public static Block frostGrass;
	public static Block frostDirt;
	public static Block frostStone;
	public static Block frostCobble;
	public static Fluid frostWater;
	public static Block frostWaterBlock;
	public static Block thickSnow;//Need to create the dimension first. Might not add it since snow can stack on top of each other now anyway.
	public static Block arcaneStone;

	/* Land Generation Blocks */
	public static Block acLogs;
	public static Block acLeaves;
	public static Block frostSapling;
	public static Block glacierSapling;
	public static Block frostWaterIce;

	
	public static void initBlocks()
	{
		frostGrass = new BlockFrostGrass();
		frostDirt = new BlockFrostDirt();
		frostStone = new BlockFrostStone();
		frostCobble = new BlockFrostCobble();
		frostWater = new Fluid("frostWater");
		/* Need to register the fluid before initialising the block */
		FluidRegistry.registerFluid(frostWater);
		frostWaterBlock = new BlockFrostWater(frostWater);
		arcaneStone = new BlockArcaneStone();
		
		acLogs = new BlockACLog(Material.wood);
		acLeaves = new BlockACLeaves(Material.leaves);
		
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(frostGrass, "frostGrass");
		GameRegistry.registerBlock(frostDirt, "frostDirt");
		GameRegistry.registerBlock(frostStone, "frostStone");
		GameRegistry.registerBlock(frostCobble, "frostCobble");
		GameRegistry.registerBlock(frostWaterBlock, "frostWaterBlock");
		GameRegistry.registerBlock(arcaneStone, "arcaneStone");
		
		GameRegistry.registerBlock(acLogs, ItemLogBlocks.class, acLogs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acLeaves, ItemLeafBlocks.class, acLeaves.getUnlocalizedName().substring(5));
		
	}
}
