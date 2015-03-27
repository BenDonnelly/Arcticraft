package net.arcticraft.item;

import java.util.List;

import net.arcticraft.containers.ContainerArcticPouch;
import net.arcticraft.main.Arcticraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcticPouch extends Item
{

	public static final String[] colours = {"blue" , "brown" , "cyan" , "magenta" , "orange" , "pink" , "purple" , "red" , "light_gray" , "yellow" , "black" , "gray" , "green" , "lime" , "Leather", "light_blue"};
	public static final String[] names = {"Blue" , "Brown" , "Cyan" , "Magenta" , "Orange" , "Pink" , "Purple" , "Red" , "Light Gray" , "Yellow" , "Black" , "Gray" , "Green" , "Lime" , "Leather", "Light Blue"};

	public ItemArcticPouch()
	{
		super();
		this.setHasSubtypes(true);
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		return names[stack.getItemDamage()] + " Arctic Pouch";
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int colour)
	{
		switch(stack.getItemDamage())
		{
		case 0:
			return 0x1536ED;
		case 1:
			return 0x8A3F0A;
		case 2:
			return 0x008080;
		case 3:
			return 0xC93AC5;
		case 4:
			return 0xff8c00;
		case 5:
			return 0xffc0cb;
		case 6:
			return 0x870968;
		case 7:
			return 0xE82315;
		case 8:
			return 0xD1D0C9;
		case 9:
			return 0xEBC909;
		case 10:
			return 0x0A0901;
		case 11:
			return 0x636360;
		case 12:
			return 0x266E19;
		case 13:
			return 0x2AFC05;
		case 14:
			return 0xcd853f;
		case 15:
			return 0x00ffff;
		}

		return colour;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if(! player.isSneaking())
		{
			player.openGui(Arcticraft.arcticraftInstance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		return stack;
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean isCurrentItem)
	{
		if(! world.isRemote)
		{
			EntityPlayer player = (EntityPlayer) entity;

			if(player.openContainer != null && player.openContainer instanceof ContainerArcticPouch && ((ContainerArcticPouch) player.openContainer).needsUpdate)
			{
				((ContainerArcticPouch) player.openContainer).writeToNBT(player.getHeldItem());
				((ContainerArcticPouch) player.openContainer).needsUpdate = false;
			}
		}
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for(int i = 0; i < 16; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

}
