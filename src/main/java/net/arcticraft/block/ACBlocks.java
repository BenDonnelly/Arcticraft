package net.arcticraft.block;

import static net.arcticraft.main.Arcticraft.MOD_ID;

import java.util.Random;

import net.arcticraft.item.ItemLeafBlocks;
import net.arcticraft.item.ItemLogBlocks;
import net.arcticraft.item.ItemPlankBlocks;
import net.arcticraft.util.StringUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACBlocks
{
	public static void loadBlocks()
	{
		initBlocks();
		registerBlocks();
	}

	/* Core Dimension Blocks */
	public static Block frostGrass, frostDirt;
	public static Block frostStone, frostCobble;
	
	public static Fluid frostWater;
	public static Block frostWaterBlock;
	
	public static Block frostSnow;
	public static Block arcaneStone;

	/* Land Generation Blocks */
	public static Block acLogs, acLeaves, acPlanks;
	public static Block frostSapling, glacierSapling;
	public static Block frostWaterIce;

	public static void initBlocks()
	{
		/* Core Dimension Blocks */
		frostGrass = new BlockFrostGrass();
		frostDirt = new BlockAC(Material.ground).setBlockName(MOD_ID + "_frostDirt").setBlockTextureName(MOD_ID + ":frost_dirt")
			.setHardness(0.5F)
			.setStepSound(Block.soundTypeGravel);
		
		frostStone = new BlockAC(Material.rock)
		{
			@Override
			public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
		    {
		        return Item.getItemFromBlock(ACBlocks.frostCobble);
		    }
		}.setBlockName(MOD_ID + "_frostStone").setBlockTextureName(MOD_ID + ":frost_stone")
			.setHardness(1.5F).setResistance(10.0F)
			.setStepSound(Block.soundTypePiston);
		
		frostCobble = new BlockAC(Material.rock).setBlockName(MOD_ID + "_frostCobble").setBlockTextureName(MOD_ID + ":frost_cobble")
			.setHardness(2.0F).setResistance(10.0F)
			.setStepSound(Block.soundTypePiston);
		
		/* Need to register the fluid before initialising the block */
		frostWater = new Fluid("frostWater");
		FluidRegistry.registerFluid(frostWater);
		
		frostWaterBlock = new BlockFrostWater(frostWater);
		arcaneStone = new BlockArcaneStone();
		
		/* Land Generation Blocks */
		acLogs = new BlockACLog();
		acLeaves = new BlockACLeaves();
		acPlanks = new BlockACPlanks();
		
		frostWaterIce = new BlockFrostWaterIce();
		frostSnow = new BlockFrostSnow();
	}
	
	public static void registerBlocks()
	{
		Block[] blockList = {
			frostGrass, frostDirt, frostStone, frostCobble,
			frostWaterBlock, arcaneStone, frostWaterIce, frostSnow
		};
		
		/* Core Dimension Blocks */
		for(Block block : blockList)
		{
			GameRegistry.registerBlock(block, StringUtils.generateName(block));
		}
		
		/* Land Generation Blocks */
		GameRegistry.registerBlock(acLogs, ItemLogBlocks.class, acLogs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acLeaves, ItemLeafBlocks.class, acLeaves.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acPlanks, ItemPlankBlocks.class, acPlanks.getUnlocalizedName().substring(5));
	}
}
