package net.arcticraft.creativetab;

import net.arcticraft.init.ACBlocks;
import net.arcticraft.util.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ACCreativeTabs
{
	public static final CreativeTabs BLOCKS = new CreativeTabs(References.TAB_BLOCKS)
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.FROST_STONE);
		}
	};
	/*
	public static final CreativeTabs acTabDecoration = new CreativeTabs("ac_tabDecoration")
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLeaves);
		}
	};
	
	public static final CreativeTabs acTabMaterials = new CreativeTabs("ac_tabMaterials")
	{
		@Override
		public Item getTabIconItem()
		{
			return ACItems.arcaneStoneDust;
		}
	};
	
	public static final CreativeTabs acTabFood = new CreativeTabs("ac_tabFood")
	{
		@Override
		public Item getTabIconItem()
		{
			return ACItems.penguinMeatCooked;
		}
	};
	
	public static final CreativeTabs acTabTools = new CreativeTabs("ac_tabTools")
	{
		@Override
		public Item getTabIconItem()
		{
			return ACItems.tekkitePickaxe; 
		}
	};
	
	public static final CreativeTabs acTabCombat = new CreativeTabs("ac_tabCombat")
	{
		@Override
		public Item getTabIconItem()
		{
			return ACItems.tekkiteHelmet;
		}
	};
	
	public static final CreativeTabs acTabMisc = new CreativeTabs("ac_tabMisc")
	{
		@Override
		public Item getTabIconItem()
		{
			return ACItems.itemSled; 
		}
	};
	
	public static final CreativeTabs acTabTechnical = new CreativeTabs("ac_tabTechnical")
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.arcticFurnaceIdle); 
		}
	};
	
	public static final CreativeTabs acTabPlants = new CreativeTabs("ac_tabPlants")
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLeaves); 
		}
	};
	*/
}

