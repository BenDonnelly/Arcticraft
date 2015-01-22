package net.arcticraft.util;

import static net.arcticraft.main.Arcticraft.MOD_ID;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class StringUtils
{
	public static String generateName(Block block)
	{
		String s = block.getUnlocalizedName().replace("tile." + MOD_ID + "_", "");
		String newString = "";
		for(char c : s.toCharArray())
		{
			newString += (Character.isUpperCase(c) ? "_" : "") + c;
		}
		return newString.toLowerCase();
	}

	public static String generateName(Item item)
	{
		String s = item.getUnlocalizedName().replace("item." + MOD_ID + "_", "");
		String newString = "";
		for(char c : s.toCharArray())
		{
			newString += (Character.isUpperCase(c) ? "_" : "") + c;
		}
		return newString.toLowerCase();
	}
}
