package net.arcticraft.item;

import static net.arcticraft.main.Arcticraft.MOD_ID;
import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.enums.EnumACToolMaterial;
import net.arcticraft.util.StringUtils;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemAxe;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACItems{

	public static void loadItems()
	{
		initItems();
		registerItems();
	}

	/* Block drops */
	public static Item arcaneStoneDust;
	public static Item tekkiteGem;
	public static Item escariaGem;
	public static Item frigus;

	/* Pickaxes */
	public static Item tekkitePickaxe;
	public static Item escariaPickaxe;
	public static Item glacianPickaxe;
	public static Item rigentemPickaxe;
	public static Item frostStonePickaxe;
	public static Item frostWoodPickaxe;

	/* Axes */
	public static Item tekkiteAxe;
	public static Item escariaAxe;
	public static Item glacianAxe;
	public static Item rigentemAxe;
	public static Item frostStoneAxe;
	public static Item frostWoodAxe;

	/* Swords */
	public static Item tekkiteSword;
	public static Item escariaSword;
	public static Item glacianSword;
	public static Item rigentemSword;
	public static Item frostStoneSword;
	public static Item frostWoodSword;
	
	/* Spades */
	public static Item tekkiteSpade;
	public static Item escariaSpade;
	public static Item glacianSpade;
	public static Item rigentemSpade;
	public static Item frostStoneSpade;
	public static Item frostWoodSpade;
	
	/* Hoes */
	public static Item tekkiteHoe;
	public static Item escariaHoe;
	public static Item glacianHoe;
	public static Item rigentemHoe;
	public static Item frostStoneHoe;
	public static Item frostWoodHoe;
	
	public static void initItems()
	{
		/* Block drops */
		arcaneStoneDust = new Item().setUnlocalizedName(MOD_ID + "_arcaneStoneDust").setTextureName(MOD_ID + ":arcane_stone_dust").setCreativeTab(ACCreativeTabs.acTabMaterials);
		tekkiteGem = new Item().setUnlocalizedName(MOD_ID + "_tekkiteGem").setTextureName(MOD_ID + ":gem_tekkite").setCreativeTab(ACCreativeTabs.acTabMaterials);
		escariaGem = new Item().setUnlocalizedName(MOD_ID + "_escariaGem").setTextureName(MOD_ID + ":gem_escaria").setCreativeTab(ACCreativeTabs.acTabMaterials);
		frigus = new Item().setUnlocalizedName(MOD_ID + "_frigus").setTextureName(MOD_ID + ":frigus").setCreativeTab(ACCreativeTabs.acTabMaterials);

		/* Pickxaes */
		tekkitePickaxe = new ItemACPickaxe(EnumACToolMaterial.TekkiteTool).setUnlocalizedName("tekkitePickaxe").setTextureName(MOD_ID + ":pickaxe_tekkite");
		escariaPickaxe = new ItemACPickaxe(EnumACToolMaterial.EscariaTool).setUnlocalizedName("escariaPickaxe").setTextureName(MOD_ID + ":pickaxe_escaria");
		glacianPickaxe = new ItemACPickaxe(EnumACToolMaterial.GlacianTool).setUnlocalizedName("glacianPickaxe").setTextureName(MOD_ID + ":pickaxe_glacian");
		rigentemPickaxe = new ItemACPickaxe(EnumACToolMaterial.RigentemTool).setUnlocalizedName("rigentemPickaxe").setTextureName(MOD_ID + ":pickaxe_rigentem");
		frostStonePickaxe = new ItemACPickaxe(ToolMaterial.STONE).setUnlocalizedName("frostStonePickaxe").setTextureName(MOD_ID + ":pickaxe_frost_stone");
		frostWoodPickaxe = new ItemACPickaxe(ToolMaterial.WOOD).setUnlocalizedName("frostWoodPickaxe").setTextureName(MOD_ID + ":pickaxe_frost_wood");

		/* Axes */
		tekkiteAxe = new ItemACAxe(EnumACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteAxe").setTextureName(MOD_ID + ":axe_tekkite");
		escariaAxe = new ItemACAxe(EnumACToolMaterial.EscariaTool).setUnlocalizedName("escariaAxe").setTextureName(MOD_ID + ":axe_escaria");
		glacianAxe = new ItemACAxe(EnumACToolMaterial.GlacianTool).setUnlocalizedName("glacianAxe").setTextureName(MOD_ID + ":axe_glacian");
		rigentemAxe = new ItemACAxe(EnumACToolMaterial.RigentemTool).setUnlocalizedName("rigentemAxe").setTextureName(MOD_ID + ":axe_rigentem");
		frostStoneAxe = new ItemACAxe(ToolMaterial.STONE).setUnlocalizedName("frostStoneAxe").setTextureName(MOD_ID + ":axe_frost_stone");
		frostWoodAxe = new ItemACAxe(ToolMaterial.WOOD).setUnlocalizedName("frostWoodAxe").setTextureName(MOD_ID + ":axe_frost_wood");

		/* Swords */
		tekkiteSword = new ItemACSword(EnumACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteSword").setTextureName(MOD_ID + ":sword_tekkite");
		escariaSword = new ItemACSword(EnumACToolMaterial.EscariaTool).setUnlocalizedName("escariaSword").setTextureName(MOD_ID + ":sword_escaria");
		glacianSword = new ItemACSword(EnumACToolMaterial.GlacianTool).setUnlocalizedName("glacianSword").setTextureName(MOD_ID + ":sword_glacian");
		rigentemSword = new ItemACSword(EnumACToolMaterial.RigentemTool).setUnlocalizedName("rigentemSword").setTextureName(MOD_ID + ":sword_rigentem");
		frostStoneSword = new ItemACSword(ToolMaterial.STONE).setUnlocalizedName("frostStoneSword").setTextureName(MOD_ID + ":sword_frost_stone");
		frostWoodSword = new ItemACSword(ToolMaterial.WOOD).setUnlocalizedName("frostWoodSword").setTextureName(MOD_ID + ":sword_frost_wood");
		
		/* Spades */
		tekkiteSpade = new ItemACSpade(EnumACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteSpade").setTextureName(MOD_ID + ":spade_tekkite");
		escariaSpade = new ItemACSpade(EnumACToolMaterial.EscariaTool).setUnlocalizedName("escariaSpade").setTextureName(MOD_ID + ":spade_escaria");
		glacianSpade = new ItemACSpade(EnumACToolMaterial.GlacianTool).setUnlocalizedName("glacianSpade").setTextureName(MOD_ID + ":spade_glacian");
		rigentemSpade = new ItemACSpade(EnumACToolMaterial.RigentemTool).setUnlocalizedName("rigentemSpade").setTextureName(MOD_ID + ":spade_rigentem");
		frostStoneSpade = new ItemACSpade(ToolMaterial.STONE).setUnlocalizedName("frostStoneSpade").setTextureName(MOD_ID + ":spade_frost_stone");
		frostWoodSpade = new ItemACSpade(ToolMaterial.WOOD).setUnlocalizedName("frostWoodSpade").setTextureName(MOD_ID + ":spade_frost_wood");
		
		/* Hoes */
		tekkiteHoe = new ItemACHoe(EnumACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteHoe").setTextureName(MOD_ID + ":hoe_tekkite");
		escariaHoe = new ItemACHoe(EnumACToolMaterial.EscariaTool).setUnlocalizedName("escariaHoe").setTextureName(MOD_ID + ":hoe_escaria");
		glacianHoe = new ItemACHoe(EnumACToolMaterial.GlacianTool).setUnlocalizedName("glacianHoe").setTextureName(MOD_ID + ":hoe_glacian");
		rigentemHoe = new ItemACHoe(EnumACToolMaterial.RigentemTool).setUnlocalizedName("rigentemHoe").setTextureName(MOD_ID + ":hoe_rigentem");
		frostStoneHoe = new ItemACHoe(ToolMaterial.STONE).setUnlocalizedName("frostStoneHoe").setTextureName(MOD_ID + ":hoe_frost_stone");
		frostWoodHoe = new ItemACHoe(ToolMaterial.WOOD).setUnlocalizedName("frostWoodHoe").setTextureName(MOD_ID + ":hoe_frost_wood");
	}

	public static void registerItems()
	{
		Item[] itemList = {arcaneStoneDust, tekkiteGem, escariaGem, frigus,
				tekkitePickaxe, escariaPickaxe, rigentemPickaxe, glacianPickaxe, frostStonePickaxe, frostWoodPickaxe,
				tekkiteAxe, escariaAxe, rigentemAxe, glacianAxe, frostStoneAxe, frostWoodAxe,
				tekkiteSword, escariaSword, rigentemSword, glacianSword, frostStoneSword, frostWoodSword,
				tekkiteSpade, escariaSpade, rigentemSpade, glacianSpade, frostStoneSpade, frostWoodSpade,
				tekkiteHoe, escariaHoe, rigentemHoe, glacianHoe, frostStoneHoe, frostWoodHoe};

		/* Core Dimension Blocks */
		for(Item item : itemList)
		{
			GameRegistry.registerItem(item, StringUtils.generateName(item));
		}
	}
}
