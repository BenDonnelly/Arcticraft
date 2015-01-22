package net.arcticraft.crafting;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACCraftingRecipes
{
	public static void loadRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 1, 0), new ItemStack(ACBlocks.acLogs, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 1, 1), new ItemStack(ACBlocks.acLogs, 1, 1));
		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcaneStone, 1), new Object[] {
			"##", "##", '#', ACItems.arcaneStoneDust
		});
	}
}
