package net.arcticraft.item;

import static net.arcticraft.main.Arcticraft.MOD_ID;
import net.arcticraft.API.block.creativetabs.ACCreativeTabs;
import net.arcticraft.API.item.ItemACArmour;
import net.arcticraft.API.item.ItemACAxe;
import net.arcticraft.API.item.ItemACFruits;
import net.arcticraft.API.item.ItemACHoe;
import net.arcticraft.API.item.ItemACPickaxe;
import net.arcticraft.API.item.ItemACRecord;
import net.arcticraft.API.item.ItemACSeeds;
import net.arcticraft.API.item.ItemACSpade;
import net.arcticraft.API.item.ItemACSword;
import net.arcticraft.block.ACBlocks;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.util.StringUtils;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fluids.FluidContainerRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ACItems {
	public static void loadItems() {
		initItems();
		registerItems();
	}

	/* Block drops */
	public static Item arcaneStoneDust;
	public static Item tekkiteGem;
	public static Item escariaGem;
	public static Item glacianIngot;
	public static Item rigentemIngot;
	public static Item frigus;
	public static Item eriumGem;
	
	/* Mob Drops */
	public static Item penguinMeat;
	public static Item penguinMeatCooked;
	public static Item penguinFeather;
	public static Item woodenClub;
	public static Item boarMeat;
	public static Item boarMeatCooked;
	
	/* Plants */
	public static Item berry;
	
	/* Captain Stuff */
	public static Item captainsLog;
	public static Item captainSword;
	public static Item captainsHook;
	
	/* Miscellaneous */
	public static Item itemSled;
	public static Item mystFruit;
	public static Item glacierFruit;
	public static Item cannonball;
	public static Item frostDoor;
	public static Item bucketEmpty;
	public static Item bucketFrostWater;
	public static Item arcticPouch;
	public static Item hotWaterBottle;
	public static Item recordFrozenFeelings;
	public static Item recordWelcomeToTheCold;
	public static Item frostStick;
	public static Item iceChunk;
	
	/* Icestone */
	public static Item icestoneDust;
	
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
	
	/* Helmets */
	public static Item tekkiteHelmet;
	public static Item escariaHelmet;
	public static Item glacianHelmet;
	public static Item rigentemHelmet;
	
	/* Chestplates */
	public static Item tekkiteChest;
	public static Item escariaChest;
	public static Item glacianChest;
	public static Item rigentemChest;
	
	/* Leggings */
	public static Item tekkiteLegs;
	public static Item escariaLegs;
	public static Item glacianLegs;
	public static Item rigentemLegs;
	
	/* Boots */
	public static Item tekkiteBoots;
	public static Item escariaBoots;
	public static Item glacianBoots;
	public static Item rigentemBoots;
	
	/* Miscellaneous */
	public static Item bomb;
	public static Item emptyCup;
	public static Item teaDrinks;
	
	public static void initItems()
	{
		/* Block drops */
		arcaneStoneDust = new Item().setUnlocalizedName(MOD_ID + "_arcaneStoneDust").setTextureName(MOD_ID + ":arcane_stone_dust").setCreativeTab(ACCreativeTabs.acTabMaterials);
		tekkiteGem = new Item().setUnlocalizedName(MOD_ID + "_tekkiteGem").setTextureName(MOD_ID + ":gem_tekkite").setCreativeTab(ACCreativeTabs.acTabMaterials);
		escariaGem = new Item().setUnlocalizedName(MOD_ID + "_escariaGem").setTextureName(MOD_ID + ":gem_escaria").setCreativeTab(ACCreativeTabs.acTabMaterials);
		glacianIngot = new Item().setUnlocalizedName(MOD_ID + "_glacianIngot").setTextureName(MOD_ID + ":ingot_glacian").setCreativeTab(ACCreativeTabs.acTabMaterials);
		rigentemIngot = new Item().setUnlocalizedName(MOD_ID + "_rigentemIngot").setTextureName(MOD_ID + ":ingot_rigentem").setCreativeTab(ACCreativeTabs.acTabMaterials);
		frigus = new Item().setUnlocalizedName(MOD_ID + "_frigus").setTextureName(MOD_ID + ":frigus").setCreativeTab(ACCreativeTabs.acTabMaterials);
		eriumGem = new Item().setUnlocalizedName(MOD_ID + "_eriumGem").setTextureName(MOD_ID + ":gem_erium").setCreativeTab(ACCreativeTabs.acTabMaterials);

		/* Mob Drops*/
		penguinMeat = new ItemFood(4, true).setPotionEffect(Potion.hunger.id, 30, 0, 1.0F).setUnlocalizedName(MOD_ID + "_penguinMeat").setTextureName(MOD_ID + ":food/penguin/penguin_meat").setCreativeTab(ACCreativeTabs.acTabFood);
		penguinMeatCooked = new ItemFood(8, true).setUnlocalizedName(MOD_ID + "_penguinMeatCooked").setTextureName(MOD_ID + ":food/penguin/penguin_meat_cooked").setCreativeTab(ACCreativeTabs.acTabFood);
		penguinFeather = new Item().setUnlocalizedName(MOD_ID + "_penguinFeather").setTextureName(MOD_ID + ":penguin_feather").setCreativeTab(ACCreativeTabs.acTabMaterials);
		woodenClub = new ItemACSword(ToolMaterial.WOOD).setUnlocalizedName(MOD_ID + "_woodenClub").setTextureName(MOD_ID + ":club_wooden").setCreativeTab(ACCreativeTabs.acTabCombat);
		boarMeat = new ItemFood(3, true).setPotionEffect(Potion.hunger.id, 30, 0, 1.0F).setUnlocalizedName(MOD_ID + "_boarMeat").setTextureName(MOD_ID + ":food/boar/boar_meat").setCreativeTab(ACCreativeTabs.acTabFood);
		boarMeatCooked = new ItemFood(8, true).setUnlocalizedName(MOD_ID + "_boarMeatCooked").setTextureName(MOD_ID + ":food/boar/boar_meat_cooked").setCreativeTab(ACCreativeTabs.acTabFood);
		
		/* Captain Stuff */
		captainsLog = new ItemCaptainsLog().setUnlocalizedName(MOD_ID + "_captainsLog").setTextureName(MOD_ID + ":captains_log").setCreativeTab(ACCreativeTabs.acTabMisc);
		captainSword = new ItemCaptainSword(ToolMaterial.EMERALD).setUnlocalizedName(MOD_ID + "_captainSword").setTextureName(MOD_ID + ":tools/misc/captain_sword").setCreativeTab(ACCreativeTabs.acTabCombat);
		captainsHook = new Item().setFull3D().setUnlocalizedName(MOD_ID + "_captainHook").setTextureName(MOD_ID + ":captains_hook");
		
		/* Miscellaneous */
		itemSled = new ItemSled().setUnlocalizedName(MOD_ID + "_sled").setTextureName(MOD_ID + ":sled_icon").setCreativeTab(ACCreativeTabs.acTabMisc);
		mystFruit = new ItemACFruits().setUnlocalizedName(MOD_ID + "_mystFruit").setTextureName(MOD_ID + ":food/fruits/myst_fruit").setCreativeTab(ACCreativeTabs.acTabFood);
		glacierFruit = new ItemACFruits().setUnlocalizedName(MOD_ID + "_glacierFruit").setTextureName(MOD_ID + ":food/fruits/glacier_fruit").setCreativeTab(ACCreativeTabs.acTabFood);
		cannonball = new Item().setFull3D().setUnlocalizedName(MOD_ID + "_cannonball").setTextureName(MOD_ID + ":cannonball").setCreativeTab(ACCreativeTabs.acTabCombat);
		frostDoor = new ItemFrostDoor(Material.wood).setUnlocalizedName(MOD_ID + "_frostDoorItem").setTextureName(MOD_ID + ":door_frost").setCreativeTab(ACCreativeTabs.acTabBlock);
		bucketEmpty = new ItemACBucket(Blocks.air).setUnlocalizedName(MOD_ID + "_bucketEmpty").setTextureName(MOD_ID + ":bucket_empty").setMaxStackSize(16).setCreativeTab(ACCreativeTabs.acTabMisc);
		bucketFrostWater = new ItemACBucket(ACBlocks.frostWaterBlock).setUnlocalizedName(MOD_ID + "_bucketFrostWater").setTextureName(MOD_ID + ":bucket_frost_Water").setMaxStackSize(1).setContainerItem(bucketEmpty).setCreativeTab(ACCreativeTabs.acTabMisc);
		arcticPouch = new ItemArcticPouch().setUnlocalizedName(MOD_ID + "_arcticPouch").setTextureName(MOD_ID + ":arctic_pouch").setMaxStackSize(1).setCreativeTab(ACCreativeTabs.acTabMisc);
		hotWaterBottle = new ItemHotWaterBottle().setUnlocalizedName(MOD_ID + "_hotWaterBottle").setTextureName(MOD_ID + ":hot_water_bottle").setMaxStackSize(4).setCreativeTab(ACCreativeTabs.acTabMisc);
		recordFrozenFeelings = new ItemACRecord("frozen_feelings", "ac").setUnlocalizedName("recordFrozenFeelings").setTextureName(MOD_ID + ":records/record_frozenFeelings").setMaxStackSize(1).setCreativeTab(ACCreativeTabs.acTabMisc);
		recordWelcomeToTheCold = new ItemACRecord("welcome_to_the_cold", "ac").setUnlocalizedName("recordWelcomeToTheCold").setTextureName(MOD_ID + ":records/record_welcomeToTheCold").setMaxStackSize(1).setCreativeTab(ACCreativeTabs.acTabMisc);
		emptyCup = new Item().setMaxStackSize(16).setUnlocalizedName(MOD_ID + "_emptyCup").setTextureName(MOD_ID + ":cup_empty").setCreativeTab(ACCreativeTabs.acTabMaterials);
		teaDrinks = new ItemTeaDrinks(4, false).setAlwaysEdible().setMaxStackSize(8).setUnlocalizedName(MOD_ID + "_teaDrinks").setCreativeTab(ACCreativeTabs.acTabFood);
		frostStick = new Item().setUnlocalizedName(MOD_ID + "_frostStick").setTextureName(MOD_ID + ":frost_stick").setCreativeTab(ACCreativeTabs.acTabMaterials);
		iceChunk = new Item().setFull3D().setUnlocalizedName(MOD_ID + "_iceChunk").setCreativeTab(ACCreativeTabs.acTabMaterials);
		/* Icestone */
		icestoneDust = new ItemIcestoneDust().setUnlocalizedName(MOD_ID + "_icestoneDust").setTextureName(MOD_ID + ":icestone/icestone_dust");
		
		/**** START OF TOOLS + ARMOUR ****/
		/* Pickxaes */
		tekkitePickaxe = new ItemACPickaxe(ACToolMaterial.TekkiteTool).setUnlocalizedName("tekkitePickaxe").setTextureName(MOD_ID + ":tools/tekkite/pickaxe_tekkite");
		escariaPickaxe = new ItemACPickaxe(ACToolMaterial.EscariaTool).setUnlocalizedName("escariaPickaxe").setTextureName(MOD_ID + ":tools/escaria/pickaxe_escaria");
		glacianPickaxe = new ItemACPickaxe(ACToolMaterial.GlacianTool).setUnlocalizedName("glacianPickaxe").setTextureName(MOD_ID + ":tools/glacian/pickaxe_glacian");
		rigentemPickaxe = new ItemACPickaxe(ACToolMaterial.RigentemTool).setUnlocalizedName("rigentemPickaxe").setTextureName(MOD_ID + ":tools/rigentem/pickaxe_rigentem");
		frostStonePickaxe = new ItemACPickaxe(ToolMaterial.STONE).setUnlocalizedName("frostStonePickaxe").setTextureName(MOD_ID + ":tools/frost_stone/pickaxe_frost_stone");
		frostWoodPickaxe = new ItemACPickaxe(ToolMaterial.WOOD).setUnlocalizedName("frostWoodPickaxe").setTextureName(MOD_ID + ":tools/frost_wood/pickaxe_frost_wood");

		/* Axes */
		tekkiteAxe = new ItemACAxe(ACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteAxe").setTextureName(MOD_ID + ":tools/tekkite/axe_tekkite");
		escariaAxe = new ItemACAxe(ACToolMaterial.EscariaTool).setUnlocalizedName("escariaAxe").setTextureName(MOD_ID + ":tools/escaria/axe_escaria");
		glacianAxe = new ItemACAxe(ACToolMaterial.GlacianTool).setUnlocalizedName("glacianAxe").setTextureName(MOD_ID + ":tools/glacian/axe_glacian");
		rigentemAxe = new ItemACAxe(ACToolMaterial.RigentemTool).setUnlocalizedName("rigentemAxe").setTextureName(MOD_ID + ":tools/rigentem/axe_rigentem");
		frostStoneAxe = new ItemACAxe(ToolMaterial.STONE).setUnlocalizedName("frostStoneAxe").setTextureName(MOD_ID + ":tools/frost_stone/axe_frost_stone");
		frostWoodAxe = new ItemACAxe(ToolMaterial.WOOD).setUnlocalizedName("frostWoodAxe").setTextureName(MOD_ID + ":tools/frost_wood/axe_frost_wood");

		/* Swords */
		tekkiteSword = new ItemACSword(ACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteSword").setTextureName(MOD_ID + ":tools/tekkite/sword_tekkite");
		escariaSword = new ItemACSword(ACToolMaterial.EscariaTool).setUnlocalizedName("escariaSword").setTextureName(MOD_ID + ":tools/escaria/sword_escaria");
		glacianSword = new ItemACSword(ACToolMaterial.GlacianTool).setUnlocalizedName("glacianSword").setTextureName(MOD_ID + ":tools/glacian/sword_glacian");
		rigentemSword = new ItemACSword(ACToolMaterial.RigentemTool).setUnlocalizedName("rigentemSword").setTextureName(MOD_ID + ":tools/rigentem/sword_rigentem");
		frostStoneSword = new ItemACSword(ToolMaterial.STONE).setUnlocalizedName("frostStoneSword").setTextureName(MOD_ID + ":tools/frost_stone/sword_frost_stone");
		frostWoodSword = new ItemACSword(ToolMaterial.WOOD).setUnlocalizedName("frostWoodSword").setTextureName(MOD_ID + ":tools/frost_wood/sword_frost_wood");
		
		/* Spades */
		tekkiteSpade = new ItemACSpade(ACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteSpade").setTextureName(MOD_ID + ":tools/tekkite/spade_tekkite");
		escariaSpade = new ItemACSpade(ACToolMaterial.EscariaTool).setUnlocalizedName("escariaSpade").setTextureName(MOD_ID + ":tools/escaria/spade_escaria");
		glacianSpade = new ItemACSpade(ACToolMaterial.GlacianTool).setUnlocalizedName("glacianSpade").setTextureName(MOD_ID + ":tools/glacian/spade_glacian");
		rigentemSpade = new ItemACSpade(ACToolMaterial.RigentemTool).setUnlocalizedName("rigentemSpade").setTextureName(MOD_ID + ":tools/rigentem/spade_rigentem");
		frostStoneSpade = new ItemACSpade(ToolMaterial.STONE).setUnlocalizedName("frostStoneSpade").setTextureName(MOD_ID + ":tools/frost_stone/spade_frost_stone");
		frostWoodSpade = new ItemACSpade(ToolMaterial.WOOD).setUnlocalizedName("frostWoodSpade").setTextureName(MOD_ID + ":tools/frost_wood/spade_frost_wood");
		
		/* Hoes */
		tekkiteHoe = new ItemACHoe(ACToolMaterial.TekkiteTool).setUnlocalizedName("tekkiteHoe").setTextureName(MOD_ID + ":tools/tekkite/hoe_tekkite");
		escariaHoe = new ItemACHoe(ACToolMaterial.EscariaTool).setUnlocalizedName("escariaHoe").setTextureName(MOD_ID + ":tools/escaria/hoe_escaria");
		glacianHoe = new ItemACHoe(ACToolMaterial.GlacianTool).setUnlocalizedName("glacianHoe").setTextureName(MOD_ID + ":tools/glacian/hoe_glacian");
		rigentemHoe = new ItemACHoe(ACToolMaterial.RigentemTool).setUnlocalizedName("rigentemHoe").setTextureName(MOD_ID + ":tools/rigentem/hoe_rigentem");
		frostStoneHoe = new ItemACHoe(ToolMaterial.STONE).setUnlocalizedName("frostStoneHoe").setTextureName(MOD_ID + ":tools/frost_stone/hoe_frost_stone");
		frostWoodHoe = new ItemACHoe(ToolMaterial.WOOD).setUnlocalizedName("frostWoodHoe").setTextureName(MOD_ID + ":tools/frost_wood/hoe_frost_wood");

		/* Helmets */
		tekkiteHelmet = new ItemACArmour(ACArmourMaterial.TekkiteArmour, Arcticraft.proxy.addArmor("Tekkite"), 0).setUnlocalizedName("tekkiteHelmet").setTextureName(MOD_ID + ":armour/tekkite/helm_tekkite");
		escariaHelmet = new ItemACArmour(ACArmourMaterial.EscariaArmour, Arcticraft.proxy.addArmor("Escaria"), 0).setUnlocalizedName("escariaHelmet").setTextureName(MOD_ID + ":armour/escaria/helm_escaria");
		glacianHelmet = new ItemACArmour(ACArmourMaterial.GlacianArmour, Arcticraft.proxy.addArmor("Glacian"), 0).setUnlocalizedName("glacianHelmet").setTextureName(MOD_ID + ":armour/glacian/helm_glacian");
		rigentemHelmet = new ItemACArmour(ACArmourMaterial.RigentemArmour, Arcticraft.proxy.addArmor("Rigentem"), 0).setUnlocalizedName("rigentemHelmet").setTextureName(MOD_ID + ":armour/rigentem/helm_rigentem");
		
		/* Chestplates */
		tekkiteChest = new ItemACArmour(ACArmourMaterial.TekkiteArmour, Arcticraft.proxy.addArmor("Tekkite"), 1).setUnlocalizedName("tekkiteChest").setTextureName(MOD_ID + ":armour/tekkite/plate_tekkite");
		escariaChest = new ItemACArmour(ACArmourMaterial.EscariaArmour, Arcticraft.proxy.addArmor("Escaria"), 1).setUnlocalizedName("escariaChest").setTextureName(MOD_ID + ":armour/escaria/plate_escaria");
		glacianChest = new ItemACArmour(ACArmourMaterial.GlacianArmour, Arcticraft.proxy.addArmor("Glacian"), 1).setUnlocalizedName("glacianChest").setTextureName(MOD_ID + ":armour/glacian/plate_glacian");
		rigentemChest = new ItemACArmour(ACArmourMaterial.RigentemArmour, Arcticraft.proxy.addArmor("Rigentem"), 1).setUnlocalizedName("rigentemChest").setTextureName(MOD_ID + ":armour/rigentem/plate_rigentem");
		
		/* Legs */
		tekkiteLegs = new ItemACArmour(ACArmourMaterial.TekkiteArmour, Arcticraft.proxy.addArmor("Tekkite"), 2).setUnlocalizedName("tekkiteLegs").setTextureName(MOD_ID + ":armour/tekkite/legs_tekkite");
		escariaLegs = new ItemACArmour(ACArmourMaterial.EscariaArmour, Arcticraft.proxy.addArmor("Escaria"), 2).setUnlocalizedName("escariaLegs").setTextureName(MOD_ID + ":armour/escaria/legs_escaria");
		glacianLegs = new ItemACArmour(ACArmourMaterial.GlacianArmour, Arcticraft.proxy.addArmor("Glacian"), 2).setUnlocalizedName("glacianLegs").setTextureName(MOD_ID + ":armour/glacian/legs_glacian");
		rigentemLegs= new ItemACArmour(ACArmourMaterial.RigentemArmour, Arcticraft.proxy.addArmor("Rigentem"), 2).setUnlocalizedName("rigentemLegs").setTextureName(MOD_ID + ":armour/rigentem/legs_rigentem");
		
		/* Boots */
		tekkiteBoots = new ItemACArmour(ACArmourMaterial.TekkiteArmour, Arcticraft.proxy.addArmor("Tekkite"), 3).setUnlocalizedName("tekkiteBoots").setTextureName(MOD_ID + ":armour/tekkite/boots_tekkite");
		escariaBoots = new ItemACArmour(ACArmourMaterial.EscariaArmour, Arcticraft.proxy.addArmor("Escaria"), 3).setUnlocalizedName("escariaBoots").setTextureName(MOD_ID + ":armour/escaria/boots_escaria");
		glacianBoots = new ItemACArmour(ACArmourMaterial.GlacianArmour, Arcticraft.proxy.addArmor("Glacian"), 3).setUnlocalizedName("glacianBoots").setTextureName(MOD_ID + ":armour/glacian/boots_glacian");
		rigentemBoots = new ItemACArmour(ACArmourMaterial.RigentemArmour, Arcticraft.proxy.addArmor("Rigentem"), 3).setUnlocalizedName("rigentemBoots").setTextureName(MOD_ID + ":armour/rigentem/boots_rigentem");
		
		/* Miscellaneous Tools */
		bomb = new ItemBomb().setUnlocalizedName("bomb").setTextureName("ac:bomb").setCreativeTab(ACCreativeTabs.acTabTools);
		
		/* Plants */
		berry = new ItemFood(6, false).setCreativeTab(ACCreativeTabs.acTabFood).setUnlocalizedName("berry").setTextureName("ac:whiteberry");
	}

	public static void registerItems() {
		Item[] itemList = { arcaneStoneDust, tekkiteGem, escariaGem, frigus, glacianIngot, rigentemIngot,
				tekkitePickaxe, escariaPickaxe, rigentemPickaxe, glacianPickaxe, frostStonePickaxe, frostWoodPickaxe,
				tekkiteAxe, escariaAxe, rigentemAxe, glacianAxe, frostStoneAxe, frostWoodAxe,
				tekkiteSword, escariaSword, rigentemSword, glacianSword, frostStoneSword, frostWoodSword,
				tekkiteSpade, escariaSpade, rigentemSpade, glacianSpade, frostStoneSpade, frostWoodSpade,
				tekkiteHoe, escariaHoe, rigentemHoe, glacianHoe, frostStoneHoe, frostWoodHoe, itemSled, 
				tekkiteHelmet, escariaHelmet, glacianHelmet, rigentemHelmet,
				tekkiteChest, escariaChest, glacianChest, rigentemChest,
				tekkiteLegs, escariaLegs, glacianLegs, rigentemLegs,
				tekkiteBoots, escariaBoots, glacianBoots, rigentemBoots, penguinMeat, penguinMeatCooked, penguinFeather,
				mystFruit, glacierFruit, cannonball, frostDoor, woodenClub, boarMeat, boarMeatCooked, eriumGem, captainsLog,
				captainSword, bucketFrostWater, bucketEmpty, arcticPouch, captainsHook, hotWaterBottle, recordFrozenFeelings, 
				recordWelcomeToTheCold, icestoneDust, bomb, frostStick, iceChunk};

		for (Item item : itemList) {
			GameRegistry.registerItem(item, StringUtils.generateName(item));
		}
	
		FluidContainerRegistry.registerFluidContainer(ACBlocks.frostWater, new ItemStack(bucketFrostWater), new ItemStack(bucketEmpty));
	}
}
