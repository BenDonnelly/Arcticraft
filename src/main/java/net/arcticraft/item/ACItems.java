package net.arcticraft.item;

import static net.arcticraft.main.Arcticraft.MOD_ID;
import cpw.mods.fml.common.registry.GameRegistry;
import net.arcticraft.block.creativetabs.ACCreativeTabs;
import net.arcticraft.util.StringUtils;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ACItems
{
	public static void loadItems()
	{
		initItems();
		registerItems();
	}
	
	public static Item arcaneStoneDust;
	
	public static void initItems()
	{
		arcaneStoneDust = new Item()
			.setUnlocalizedName(MOD_ID + "_arcaneStoneDust")
			.setTextureName(MOD_ID + ":arcane_stone_dust")
			.setCreativeTab(ACCreativeTabs.acTabMaterials);
	}
	
	public static void registerItems()
	{
		Item[] itemList = {
			arcaneStoneDust
		};
		
		/* Core Dimension Blocks */
		for(Item item : itemList)
		{
			GameRegistry.registerItem(item, StringUtils.generateName(item));
		}
	}
}
