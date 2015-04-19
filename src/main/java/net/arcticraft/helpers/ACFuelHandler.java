package net.arcticraft.helpers;

import net.arcticraft.item.ACItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class ACFuelHandler implements IFuelHandler{

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		Item item = fuel.getItem();

		if(item == ACItems.frigus)
		{
			return 1600;
		}
		else
		{
			return 0;
		}
	}

}
