package net.arcticraft.crafting;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACRecipes{

	public static void loadRecipes()
	{

		craftingRecipes();
		smeltingRecipes();
	}

	public static void craftingRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 1, 0), new ItemStack(ACBlocks.acLogs, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 1, 1), new ItemStack(ACBlocks.acLogs, 1, 1));
		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcaneStone, 1), new Object[] {"##", "##", '#', ACItems.arcaneStoneDust});
	}

	public static void smeltingRecipes()
	{
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.frostCobble, new ItemStack(ACBlocks.frostStone, 1), 0.1F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.frigusOre, new ItemStack(ACItems.frigus, 1), 0.2F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.tekkiteOre, new ItemStack(ACItems.tekkiteGem, 1), 1.0F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.escariaOre, new ItemStack(ACItems.escariaGem, 1), 0.8F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.rigentemOre, new ItemStack(ACItems.rigentemIngot, 1), 0.6F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.glacianOre, new ItemStack(ACItems.glacianIngot, 1), 0.4F);
	}
}
