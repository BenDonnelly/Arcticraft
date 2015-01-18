package net.arcticraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

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
	}
	
	public static void registerBlocks()
	{
		GameRegistry.registerBlock(frostGrass, "frostGrass");
		GameRegistry.registerBlock(frostDirt, "frostDirt");
		GameRegistry.registerBlock(frostStone, "frostStone");
		GameRegistry.registerBlock(frostCobble, "frostCobble");
		GameRegistry.registerBlock(frostWaterBlock, "frostWaterBlock");
		GameRegistry.registerBlock(arcaneStone, "arcaneStone");
		
	}
}
