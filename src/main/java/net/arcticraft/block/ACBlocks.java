package net.arcticraft.block;

import net.arcticraft.items.ItemLeafBlocks;
import net.arcticraft.items.ItemLogBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
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
	public static Block frostSnow;
	public static Block arcaneStone;

	/* Land Generation Blocks */
	public static Block acLogs;
	public static Block acLeaves;
	public static Block frostSapling;
	public static Block glacierSapling;
	public static Block frostWaterIce;

	public static void initBlocks()
	{
		/* Core Dimension Blocks */
		frostGrass = new BlockFrostGrass();
		frostDirt = new BlockFrostDirt();
		frostStone = new BlockFrostStone();
		frostCobble = new BlockFrostCobble();
		frostWater = new Fluid("frostWater");
		/* Need to register the fluid before initialising the block */
		FluidRegistry.registerFluid(frostWater);
		frostWaterBlock = new BlockFrostWater(frostWater);
		arcaneStone = new BlockArcaneStone();
		
		/* Land Generation Blocks */
		acLogs = new BlockACLog(Material.wood);
		acLeaves = new BlockACLeaves(Material.leaves);
		frostWaterIce = new BlockFrostWaterIce();
		frostSnow = new BlockFrostSnow();
	}
	
	public static void registerBlocks()
	{
		/* Core Dimension Blocks */
		GameRegistry.registerBlock(frostGrass, "frostGrass");
		GameRegistry.registerBlock(frostDirt, "frostDirt");
		GameRegistry.registerBlock(frostStone, "frostStone");
		GameRegistry.registerBlock(frostCobble, "frostCobble");
		GameRegistry.registerBlock(frostWaterBlock, "frostWaterBlock");
		GameRegistry.registerBlock(arcaneStone, "arcaneStone");
		
		/* Land Generation Blocks */
		GameRegistry.registerBlock(acLogs, ItemLogBlocks.class, acLogs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acLeaves, ItemLeafBlocks.class, acLeaves.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(frostWaterIce, "frostWaterIce");	
		GameRegistry.registerBlock(frostSnow, "frostSnow");	
	}
}
