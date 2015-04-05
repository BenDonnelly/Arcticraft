package net.arcticraft.API.block.creativetabs;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ACCreativeTabs
{
	public static final CreativeTabs acTabBlock = new CreativeTabs("ac_tabBlock")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.frostStone);
		}
	};
	
	public static final CreativeTabs acTabDecoration = new CreativeTabs("ac_tabDecoration")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLeaves);
		}
	};
	
	public static final CreativeTabs acTabMaterials = new CreativeTabs("ac_tabMaterials")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ACItems.arcaneStoneDust;
		}
	};
	
	public static final CreativeTabs acTabFood = new CreativeTabs("ac_tabFood")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ACItems.penguinMeatCooked;
		}
	};
	
	public static final CreativeTabs acTabTools = new CreativeTabs("ac_tabTools")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ACItems.tekkitePickaxe; 
		}
	};
	
	public static final CreativeTabs acTabCombat = new CreativeTabs("ac_tabCombat")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ACItems.tekkiteHelmet;
		}
	};
	
	public static final CreativeTabs acTabMisc = new CreativeTabs("ac_tabMisc")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ACItems.itemSled; 
		}
	};
	
	public static final CreativeTabs acTabTechnical = new CreativeTabs("ac_tabTechnical")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return ACItems.arcaneStoneDust; 
		}
	};
}
