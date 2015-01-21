package net.arcticraft.block.creativetabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.arcticraft.block.ACBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ACCreativeTabs {
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
			return Item.getItemFromBlock(ACBlocks.arcaneStone); // TODO Replace this with a decorative block
		}
	};
	
	public static final CreativeTabs acTabMaterials = new CreativeTabs("ac_tabMaterials")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLogs); // TODO Replace this with a crafting material
		}
	};
	
	public static final CreativeTabs acTabFood = new CreativeTabs("ac_tabFood")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLogs); // TODO Replace this with a crafting material
		}
	};
	
	public static final CreativeTabs acTabTools = new CreativeTabs("ac_tabTools")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLogs); // TODO Replace this with a tool
		}
	};
	
	public static final CreativeTabs acTabCombat = new CreativeTabs("ac_tabCombat")
	{
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(ACBlocks.acLogs); // TODO Replace this with a tool
		}
	};
}