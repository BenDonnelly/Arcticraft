package net.arcticraft.block;

import static net.arcticraft.main.Arcticraft.MOD_ID;

import java.util.Random;

import net.arcticraft.item.ItemLeafBlocks;
import net.arcticraft.item.ItemLogBlocks;
import net.arcticraft.item.ItemPlankBlocks;
import net.arcticraft.item.ItemSlabBlocks;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.arcticraft.tileentity.TileEntityCannon;
import net.arcticraft.util.StringUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
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

	/* Decorative Blocks */
	public static Block  acSlab, acDoubleSlab;
	public static Block frostStairs, glacierStairs;
	public static Block frostDoor;
	public static Block frostLadder;
	
	/* Ores - Ordered in rarity*/
	public static Block tekkiteOre;
	public static Block escariaOre;
	public static Block glacianOre;
	public static Block rigentemOre;
	public static Block frigusOre;

	/* Tile Entity Blocks */
	public static Block campfire;
	public static Block cannon;
	
	/* Miscellaneous */
	public static Block mysticalSnow;
	
	public static void initBlocks()
	{
		/* Core Dimension Blocks */
		frostGrass = new BlockFrostGrass();
		frostDirt = new BlockAC(Material.ground).setBlockName(MOD_ID + "_frostDirt").setBlockTextureName(MOD_ID + ":dirt_frost").setHardness(0.5F).setStepSound(Block.soundTypeGravel);

		frostStone = new BlockAC(Material.rock){
			@Override
			public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
			{
				return Item.getItemFromBlock(ACBlocks.frostCobble);
			}
		}.setBlockName(MOD_ID + "_frostStone").setBlockTextureName(MOD_ID + ":stone_frost").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypePiston);

		frostCobble = new BlockAC(Material.rock).setBlockName(MOD_ID + "_frostCobble").setBlockTextureName(MOD_ID + ":cobble_frost").setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston);

		/* Need to register the fluid before initialising the block */
		frostWater = new Fluid("frostWater");
		FluidRegistry.registerFluid(frostWater);

		frostWaterBlock = new BlockFrostWater(frostWater);
		arcaneStone = new BlockArcaneStone();

		/* Land Generation Blocks */
		acLogs = new BlockACLog(Material.wood);
		acLeaves = new BlockACLeaves(Material.leaves);
		acPlanks = new BlockACPlanks(Material.wood);
		frostWaterIce = new BlockFrostWaterIce(Material.ice);
		frostSnow = new BlockFrostSnow();
		
		/* Ores */
		tekkiteOre = new BlockACOres().setBlockName(MOD_ID + "_tekkiteOre").setBlockTextureName(MOD_ID + ":ore_tekkite");
	 	escariaOre = new BlockACOres().setBlockName(MOD_ID + "_escariaOre").setBlockTextureName(MOD_ID + ":ore_escaria");
		glacianOre = new BlockACOres().setBlockName(MOD_ID + "_glacianOre").setBlockTextureName(MOD_ID + ":ore_glacian");
		rigentemOre = new BlockACOres().setBlockName(MOD_ID + "_rigentemOre").setBlockTextureName(MOD_ID + ":ore_rigentem");
		frigusOre = new BlockACOres().setBlockName(MOD_ID + "_frigusOre").setBlockTextureName(MOD_ID + ":ore_frigus");
		
		/* Decorative Blocks */
		acSlab = new BlockACSlab(false);
		acDoubleSlab = new BlockACSlab(true);
		frostStairs = new BlockACStairs(ACBlocks.acPlanks, 0, Material.wood);
		glacierStairs = new BlockACStairs(ACBlocks.acPlanks, 1, Material.wood);
		frostLadder = new BlockFrostLadder(Material.circuits);
		frostDoor = new BlockFrostDoor(Material.wood);
		
		/* Miscellaneous */
		mysticalSnow = new BlockMysticalSnow(Material.snow);
		campfire = new BlockCampfire(Material.wood);
		cannon = new BlockCannon(Material.iron);
	}

	public static void registerBlocks()
	{
		Block[] blockList = {frostGrass, frostDirt, frostStone, frostCobble, frostWaterBlock, arcaneStone, frostWaterIce, frostSnow, tekkiteOre, escariaOre, glacianOre, rigentemOre, frigusOre
				,mysticalSnow, campfire, cannon, frostLadder, frostDoor};

		for(Block block : blockList)
		{
			GameRegistry.registerBlock(block, StringUtils.generateName(block));
		}
		
		/*Multi blocks*/
		GameRegistry.registerBlock(acLogs, ItemLogBlocks.class, acLogs.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acLeaves, ItemLeafBlocks.class, acLeaves.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acPlanks, ItemPlankBlocks.class, acPlanks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(acSlab, ItemSlabBlocks.class, acSlab.getUnlocalizedName().substring(5), acSlab, acDoubleSlab, false);
		GameRegistry.registerBlock(acDoubleSlab, ItemSlabBlocks.class, acDoubleSlab.getUnlocalizedName().substring(5) + "_double", acSlab, acDoubleSlab, true);
		GameRegistry.registerBlock(frostStairs, acPlanks.getUnlocalizedName().substring(5) + "_frost");
		GameRegistry.registerBlock(glacierStairs, acPlanks.getUnlocalizedName().substring(5) + "_glacier");
		
	
		GameRegistry.registerTileEntity(TileEntityCampfire.class, "tileEntityCampfire");
		GameRegistry.registerTileEntity(TileEntityCannon.class, "tileEntityCannon");
	}
}
