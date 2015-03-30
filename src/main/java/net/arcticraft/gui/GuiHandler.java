package net.arcticraft.gui;

import net.arcticraft.containers.ContainerArcticFurnace;
import net.arcticraft.containers.ContainerArcticPouch;
import net.arcticraft.item.ItemArcticPouchInventory;
import net.arcticraft.tileentity.TileEntityArcticFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		switch(id) {
		case 0:
			return new ContainerArcticPouch(player, player.inventory, new ItemArcticPouchInventory(player.getHeldItem()));
		case 1:
			return new ContainerArcticFurnace(player.inventory, (TileEntityArcticFurnace) tile_entity);
		}
		return true;
	}

	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tile_entity = world.getTileEntity(x, y, z);

		switch(id) {
		case 0:
			return new GuiArcticPouch(player, player.inventory, new ItemArcticPouchInventory(player.getHeldItem()));
		case 1:
			 return new GuiArcticFurnace(player.inventory, (TileEntityArcticFurnace) tile_entity);
		}
		return true;
	}
}
