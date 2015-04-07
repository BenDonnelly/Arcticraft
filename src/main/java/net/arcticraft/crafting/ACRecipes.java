package net.arcticraft.crafting;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACRecipes {
	public static void loadRecipes() 
	{
		craftingRecipes();
		smeltingRecipes();
		tools();
		misc();
		frostWood();
		food();
	}

	public static void craftingRecipes() 
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 1, 0),
				new ItemStack(ACBlocks.acLogs, 1, 0));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 1, 1),
				new ItemStack(ACBlocks.acLogs, 1, 1));
		
		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcaneStone, 1),
				new Object[] { "##", "##", '#', ACItems.arcaneStoneDust });
	}

	public static void smeltingRecipes() 
	{
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.frostCobble,
				new ItemStack(ACBlocks.frostStone, 1), 0.1F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.frigusOre,
				new ItemStack(ACItems.frigus, 1), 0.2F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.tekkiteOre,
				new ItemStack(ACItems.tekkiteGem, 1), 1.0F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.escariaOre,
				new ItemStack(ACItems.escariaGem, 1), 0.8F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.rigentemOre,
				new ItemStack(ACItems.rigentemIngot, 1), 0.6F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.glacianOre,
				new ItemStack(ACItems.glacianIngot, 1), 0.4F);
	}

	public static void food() 
	{
		ACItems.bucketFrostWater.setContainerItem(ACItems.bucketEmpty);
	}

	public static void frostWood() 
	{
		GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table),
				new Object[] { "XX", "XX", 'X', ACBlocks.acPlanks });

		GameRegistry.addRecipe(new ItemStack(Items.arrow, 4), new Object[] {
				" Z ", " Y ", " X ", Character.valueOf('X'),
				ACItems.penguinFeather, Character.valueOf('Y'), Items.stick,
				Character.valueOf('Z'), Items.flint });
		
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {
				"X", "X", Character.valueOf('X'), ACBlocks.acPlanks });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.frostStairs, 4),
				new Object[] { "X  ", "XX ", "XXX", Character.valueOf('X'),
						ACBlocks.acPlanks });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.acSlab, 6), new Object[] {
				"XXX", Character.valueOf('X'), ACBlocks.acPlanks });
	}

	public static void tools() 
	{
		GameRegistry.addRecipe(new ItemStack(ACItems.escariaPickaxe, 1),
				new Object[] { "%%%", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, '%', ACItems.escariaGem });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.escariaSpade, 1),
						new Object[] { " % ", " ? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.escariaGem });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.escariaHoe, 1),
						new Object[] { " %%", " ? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.escariaGem });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.escariaAxe, 1),
						new Object[] { "%% ", "%? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.escariaGem });

		GameRegistry
				.addRecipe(new ItemStack(ACItems.escariaSword, 1),
						new Object[] { "%", "%", "?", Character.valueOf('?'),
								Items.stick, Character.valueOf('%'),
								ACItems.escariaGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaHelmet, 1),
				new Object[] { "%%%", "% %", Character.valueOf('%'),
						ACItems.escariaGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaChest, 1),
				new Object[] { "* *", "***", "***", Character.valueOf('*'),
						ACItems.escariaGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaLegs, 1),
				new Object[] { "%%%", "% %", "% %", Character.valueOf('%'),
						ACItems.escariaGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaBoots, 1),
				new Object[] { "X X", "X X", Character.valueOf('X'),
						ACItems.escariaGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianPickaxe, 1),
				new Object[] { "%%%", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, '%', ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianSpade, 1),
				new Object[] { " % ", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianHoe, 1),
				new Object[] { " %%", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianAxe, 1),
				new Object[] { "%% ", "%? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianSword, 1),
				new Object[] { "%", "%", "?", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianHelmet, 1),
				new Object[] { "%%%", "% %", Character.valueOf('%'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianChest, 1),
				new Object[] { "* *", "***", "***", Character.valueOf('*'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianLegs, 1),
				new Object[] { "%%%", "% %", "% %", Character.valueOf('%'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianBoots, 1),
				new Object[] { "X X", "X X", Character.valueOf('X'),
						ACItems.glacianIngot });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.tekkitePickaxe, 1),
						new Object[] { "%%%", " ? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.tekkiteGem });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.tekkiteSpade, 1),
						new Object[] { " % ", " ? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.tekkiteGem });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.tekkiteHoe, 1),
						new Object[] { " %%", " ? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.tekkiteGem });

		GameRegistry
				.addRecipe(
						new ItemStack(ACItems.tekkiteAxe, 1),
						new Object[] { "%% ", "%? ", " ? ",
								Character.valueOf('?'), Items.stick,
								Character.valueOf('%'), ACItems.tekkiteGem });

		GameRegistry
				.addRecipe(new ItemStack(ACItems.tekkiteSword, 1),
						new Object[] { "%", "%", "?", Character.valueOf('?'),
								Items.stick, Character.valueOf('%'),
								ACItems.tekkiteGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteHelmet, 1),
				new Object[] { "%%%", "% %", Character.valueOf('%'),
						ACItems.tekkiteGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteChest, 1),
				new Object[] { "* *", "***", "***", Character.valueOf('*'),
						ACItems.tekkiteGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteLegs, 1),
				new Object[] { "%%%", "% %", "% %", Character.valueOf('%'),
						ACItems.tekkiteGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteBoots, 1),
				new Object[] { "X X", "X X", Character.valueOf('X'),
						ACItems.tekkiteGem });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemPickaxe, 1),
				new Object[] { "%%%", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemSpade, 1),
				new Object[] { " % ", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemHoe, 1),
				new Object[] { " %%", " ? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemAxe, 1),
				new Object[] { "%% ", "%? ", " ? ", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemSword, 1),
				new Object[] { "%", "%", "?", Character.valueOf('?'),
						Items.stick, Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemHelmet, 1),
				new Object[] { "%%%", "% %", Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemChest, 1),
				new Object[] { "* *", "***", "***", Character.valueOf('*'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemLegs, 1),
				new Object[] { "%%%", "% %", "% %", Character.valueOf('%'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemBoots, 1),
				new Object[] { "X X", "X X", Character.valueOf('X'),
						ACItems.rigentemIngot });
	}

	public static void misc() 
	{
		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcticFurnaceIdle),
				new Object[] { "XXX", "X X", "XXX", Character.valueOf('X'),
						ACBlocks.frostCobble });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcaneStone),
				new Object[] { "XX", "XX", Character.valueOf('X'),
						ACItems.arcaneStoneDust });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.mysticalSnow, 8),
				new Object[] { "GDG", "GSG", "GDG", Character.valueOf('G'),
						Items.gold_ingot, Character.valueOf('S'), Blocks.snow,
						Character.valueOf('D'), Items.diamond });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.campfire),
				new Object[] { " Y ", "XXX", Character.valueOf('X'),
						Items.stick, Character.valueOf('Y'), ACItems.frigus });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.glacianBlock),
				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
						ACItems.glacianIngot });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.tekkiteBlock),
				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
						ACItems.tekkiteGem });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.escariaBlock),
				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
						ACItems.escariaGem });

		GameRegistry.addRecipe(new ItemStack(ACBlocks.rigentemBlock),
				new Object[] { "XXX", "XXX", "XXX", Character.valueOf('X'),
						ACItems.rigentemIngot });

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianIngot, 9),
				new Object[] { "X", Character.valueOf('X'),
						ACBlocks.glacianBlock });

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteGem, 9),
				new Object[] { "X", Character.valueOf('X'),
						ACBlocks.tekkiteBlock });

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemIngot, 9),
				new Object[] { "X", Character.valueOf('X'),
						ACBlocks.rigentemBlock });

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaGem, 9),
				new Object[] { "X", Character.valueOf('X'),
						ACBlocks.escariaBlock });
	}
}
