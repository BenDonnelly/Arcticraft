package net.arcticraft.item;

import net.arcticraft.gui.GuiCaptainsLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCaptainsLog extends Item{

	public ItemCaptainsLog(){
		this.setMaxStackSize(1);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
	{
		FMLClientHandler.instance().displayGuiScreen(player, new GuiCaptainsLog());
		return itemstack;
	}

}
