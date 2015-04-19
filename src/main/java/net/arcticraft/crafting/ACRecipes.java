package net.arcticraft.crafting;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACRecipes{

	public static void loadRecipes()
	{
		smeltingRecipes();
		tools();
		misc();
		frostWood();
		food();
		pouches();
		iceShit();
		vanillaSmeltingRecipes();
	}

	public static void smeltingRecipes()
	{
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.frostCobble, new ItemStack(ACBlocks.frostStone, 1), 0.1F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.frigusOre, new ItemStack(ACItems.frigus, 1), 0.2F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.tekkiteOre, new ItemStack(ACItems.tekkiteGem, 1), 1.0F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.escariaOre, new ItemStack(ACItems.escariaGem, 1), 0.8F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.rigentemOre, new ItemStack(ACItems.rigentemIngot, 1), 0.6F);
		ACFurnaceRecipes.smelting().addSmeltingBlock(ACBlocks.glacianOre, new ItemStack(ACItems.glacianIngot, 1), 0.4F);
		ACFurnaceRecipes.smelting().addSmeltingItem(ACItems.hotWaterBottle, new ItemStack(ACItems.hotWaterBottle, 1), 0.2F);
	}

	public static void vanillaSmeltingRecipes(){

		GameRegistry.addSmelting(ACBlocks.frostCobble, new ItemStack(ACBlocks.frostStone, 1), 0.1F);
		GameRegistry.addSmelting(ACBlocks.frigusOre, new ItemStack(ACItems.frigus, 1), 0.2F);
		GameRegistry.addSmelting(ACBlocks.tekkiteOre, new ItemStack(ACItems.tekkiteGem, 1), 1.0F);
		GameRegistry.addSmelting(ACBlocks.escariaOre, new ItemStack(ACItems.escariaGem, 1), 0.8F);
		GameRegistry.addSmelting(ACBlocks.rigentemOre, new ItemStack(ACItems.rigentemIngot, 1), 0.6F);
		GameRegistry.addSmelting(ACBlocks.glacianOre, new ItemStack(ACItems.glacianIngot, 1), 0.4F);
		GameRegistry.addSmelting(ACItems.hotWaterBottle, new ItemStack(ACItems.hotWaterBottle, 1), 0.2F);
	}
	
	public static void iceShit(){
		GameRegistry.addRecipe(new ItemStack(ACBlocks.frostWaterIce, 1), new Object[] {"III", "III", "III", Character.valueOf('I'), ACItems.iceChunk});
		GameRegistry.addShapelessRecipe(new ItemStack(ACItems.iceChunk, 9), new ItemStack(ACBlocks.frostWaterIce, 1));
		GameRegistry.addRecipe(new ItemStack(ACItems.hotWaterBottle, 1, 80), new Object[]{"III", "ILI", "III", Character.valueOf('I'), ACBlocks.frostWaterIce, Character.valueOf('L'), Items.leather});
	}	
	
	
	public static void food()
	{
		ACItems.bucketFrostWater.setContainerItem(ACItems.bucketEmpty);
	}

	public static void frostWood()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 4, 0), new ItemStack(ACBlocks.acLogs, 1, 0));

		GameRegistry.addShapelessRecipe(new ItemStack(ACBlocks.acPlanks, 4, 1), new ItemStack(ACBlocks.acLogs, 1, 1));

		GameRegistry.addRecipe(new ItemStack(Blocks.crafting_table), new Object[] {"XX", "XX", 'X', ACBlocks.acPlanks});

		GameRegistry.addRecipe(new ItemStack(Items.arrow, 4), new Object[] {" Z ", " Y ", " X ", Character.valueOf('X'), ACItems.penguinFeather, Character.valueOf('Y'), ACItems.frostStick, Character.valueOf('Z'), Items.flint});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostStick, 4), new Object[] {"X", "X", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(Items.stick, 4), new Object[] {"X", "X", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 1)});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.frostStairs, 4, 0), new Object[] {"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.glacierStairs, 4, 1), new Object[] {"X  ", "XX ", "XXX", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 1)});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.acSlab, 6, 0), new Object[] {"XXX", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.acSlab, 6, 1), new Object[] {"XXX", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 1)});

	}

	public static void tools()
	{
		GameRegistry.addRecipe(new ItemStack(ACItems.escariaPickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, '%', ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaSpade, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaHoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaAxe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaSword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaHelmet, 1), new Object[] {"%%%", "% %", Character.valueOf('%'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaChest, 1), new Object[] {"* *", "***", "***", Character.valueOf('*'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaLegs, 1), new Object[] {"%%%", "% %", "% %", Character.valueOf('%'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaBoots, 1), new Object[] {"X X", "X X", Character.valueOf('X'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianPickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, '%', ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianSpade, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianHoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianAxe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianSword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianHelmet, 1), new Object[] {"%%%", "% %", Character.valueOf('%'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianChest, 1), new Object[] {"* *", "***", "***", Character.valueOf('*'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianLegs, 1), new Object[] {"%%%", "% %", "% %", Character.valueOf('%'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianBoots, 1), new Object[] {"X X", "X X", Character.valueOf('X'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkitePickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteSpade, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteHoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteAxe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteSword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteHelmet, 1), new Object[] {"%%%", "% %", Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteChest, 1), new Object[] {"* *", "***", "***", Character.valueOf('*'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteLegs, 1), new Object[] {"%%%", "% %", "% %", Character.valueOf('%'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteBoots, 1), new Object[] {"X X", "X X", Character.valueOf('X'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemPickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemSpade, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemHoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemAxe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemSword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemHelmet, 1), new Object[] {"%%%", "% %", Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemChest, 1), new Object[] {"* *", "***", "***", Character.valueOf('*'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemLegs, 1), new Object[] {"%%%", "% %", "% %", Character.valueOf('%'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemBoots, 1), new Object[] {"X X", "X X", Character.valueOf('X'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostStonePickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, '%', ACBlocks.frostCobble});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostStoneSpade, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACBlocks.frostCobble});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostStoneHoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACBlocks.frostCobble});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostStoneAxe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACBlocks.frostCobble});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostStoneSword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), ACBlocks.frostCobble});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostWoodPickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, '%', new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostWoodSpade, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostWoodHoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostWoodAxe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(ACItems.frostWoodSword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 0)});

		GameRegistry.addRecipe(new ItemStack(Items.wooden_pickaxe, 1), new Object[] {"%%%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, '%', new ItemStack(ACBlocks.acPlanks, 1, 1)});

		GameRegistry.addRecipe(new ItemStack(Items.wooden_shovel, 1), new Object[] {" % ", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 1)});

		GameRegistry.addRecipe(new ItemStack(Items.wooden_hoe, 1), new Object[] {" %%", " ? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 1)});

		GameRegistry.addRecipe(new ItemStack(Items.wooden_axe, 1), new Object[] {"%% ", "%? ", " ? ", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 1)});

		GameRegistry.addRecipe(new ItemStack(Items.wooden_sword, 1), new Object[] {"%", "%", "?", Character.valueOf('?'), ACItems.frostStick, Character.valueOf('%'), new ItemStack(ACBlocks.acPlanks, 1, 1)});
	}

	public static void misc()
	{
		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcaneStone, 1), new Object[] {"##", "##", '#', ACItems.arcaneStoneDust});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.arcticFurnaceIdle), new Object[] {"XXX", "X X", "XXX", Character.valueOf('X'), ACBlocks.frostCobble});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.mysticalSnow, 8), new Object[] {"GDG", "GSG", "GDG", Character.valueOf('G'), Items.gold_ingot, Character.valueOf('S'), Blocks.snow, Character.valueOf('D'), Items.diamond});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.campfire), new Object[] {" Y ", "XXX", Character.valueOf('X'), ACItems.frostStick, Character.valueOf('Y'), ACItems.frigus});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.glacianBlock), new Object[] {"XXX", "XXX", "XXX", Character.valueOf('X'), ACItems.glacianIngot});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.tekkiteBlock), new Object[] {"XXX", "XXX", "XXX", Character.valueOf('X'), ACItems.tekkiteGem});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.escariaBlock), new Object[] {"XXX", "XXX", "XXX", Character.valueOf('X'), ACItems.escariaGem});

		GameRegistry.addRecipe(new ItemStack(ACBlocks.rigentemBlock), new Object[] {"XXX", "XXX", "XXX", Character.valueOf('X'), ACItems.rigentemIngot});

		GameRegistry.addRecipe(new ItemStack(ACItems.glacianIngot, 9), new Object[] {"X", Character.valueOf('X'), ACBlocks.glacianBlock});

		GameRegistry.addRecipe(new ItemStack(ACItems.tekkiteGem, 9), new Object[] {"X", Character.valueOf('X'), ACBlocks.tekkiteBlock});

		GameRegistry.addRecipe(new ItemStack(ACItems.rigentemIngot, 9), new Object[] {"X", Character.valueOf('X'), ACBlocks.rigentemBlock});

		GameRegistry.addRecipe(new ItemStack(ACItems.escariaGem, 9), new Object[] {"X", Character.valueOf('X'), ACBlocks.escariaBlock});

		GameRegistry.addRecipe(new ItemStack(ACItems.itemSled), new Object[] {"  X", "XXX", "Y Y", Character.valueOf('X'), new ItemStack(ACBlocks.acPlanks, 1, 1), Character.valueOf('Y'), ACItems.frostStick});
	
		GameRegistry.addRecipe(new ItemStack(ACBlocks.lantern, 4), new Object[] {" S " , "SFS" , " S " , Character.valueOf('S') , ACItems.frostStick, Character.valueOf('F') , ACItems.frigus});
	
		GameRegistry.addRecipe(new ItemStack(ACBlocks.frostLadder, 3), new Object[] {"I I" , "III" , "I I" , Character.valueOf('I') , ACBlocks.frostWaterIce});
		GameRegistry.addRecipe(new ItemStack(ACBlocks.frostLadder, 3), new Object[] {"I I" , "III" , "I I" , Character.valueOf('I') , Blocks.ice});
		
	}
	
	public static void pouches()
	{
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  0), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 4)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  1), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 3)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  2), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 6)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  3), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 13)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  4), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 14)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  5), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 9)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  6), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 5)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  7), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 1)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  8), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 7)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  9), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 11)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  10), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 0)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  11), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 8)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  12), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 2)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  13), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 10)});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  14), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), Items.leather});
		GameRegistry.addRecipe(new ItemStack(ACItems.arcticPouch, 1,  15), new Object[] {"S S", "LDL", "LLL", Character.valueOf('S'), Items.string, Character.valueOf('L'), ACItems.polarBearHide, Character.valueOf('D'), new ItemStack(Items.dye, 1, 12)});

	}

}
