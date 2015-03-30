package net.arcticraft.containers;

import net.arcticraft.crafting.ACFurnaceRecipes;
import net.arcticraft.gui.SlotArcticFurnace;
import net.arcticraft.tileentity.TileEntityArcticFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerArcticFurnace extends Container{

	private TileEntityArcticFurnace furnace;
	private int lastCookTime = 0;
	private int lastBurnTime = 0;
	private int lastItemBurnTime = 0;

	public ContainerArcticFurnace(InventoryPlayer playerInv, TileEntityArcticFurnace tileEntityACFurnace){
		this.furnace = tileEntityACFurnace;
		this.addSlotToContainer(new Slot(tileEntityACFurnace, 0, 56, 17));
		this.addSlotToContainer(new Slot(tileEntityACFurnace, 1, 56, 53));
		this.addSlotToContainer(new SlotArcticFurnace(playerInv.player, tileEntityACFurnace, 2, 116, 35));
		int i;
		for(i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		for(i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(playerInv, i, 8 + i * 18, 142));
		}
	}

	@Override
	public void addCraftingToCrafters(ICrafting crafting)
	{
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
		crafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
		crafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); ++i)
		{
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			if(this.lastCookTime != this.furnace.furnaceCookTime)
			{
				icrafting.sendProgressBarUpdate(this, 0, this.furnace.furnaceCookTime);
			}
			if(this.lastBurnTime != this.furnace.furnaceBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 1, this.furnace.furnaceBurnTime);
			}
			if(this.lastItemBurnTime != this.furnace.currentItemBurnTime)
			{
				icrafting.sendProgressBarUpdate(this, 2, this.furnace.currentItemBurnTime);
			}
		}
		this.lastCookTime = this.furnace.furnaceCookTime;
		this.lastBurnTime = this.furnace.furnaceBurnTime;
		this.lastItemBurnTime = this.furnace.currentItemBurnTime;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int par1, int par2)
	{
		if(par1 == 0)
		{
			this.furnace.furnaceCookTime = par2;
		}
		if(par1 == 1)
		{
			this.furnace.furnaceBurnTime = par2;
		}
		if(par1 == 2)
		{
			this.furnace.currentItemBurnTime = par2;
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return this.furnace.isUseableByPlayer(player);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	{
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);
		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if(par2 == 2)
			{
				if(!this.mergeItemStack(itemstack1, 3, 39, true))
				{
					return null;
				}
				slot.onSlotChange(itemstack1, itemstack);
			}
			else if(par2 != 1 && par2 != 0)
			{
				if(ACFurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
				{
					if(!this.mergeItemStack(itemstack1, 0, 1, false))
					{
						return null;
					}
				}
				else if(TileEntityArcticFurnace.isItemFuel(itemstack1))
				{
					if(!this.mergeItemStack(itemstack1, 1, 2, false))
					{
						return null;
					}
				}
				else if(par2 >= 3 && par2 < 30)
				{
					if(!this.mergeItemStack(itemstack1, 30, 39, false))
					{
						return null;
					}
				}
				else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
				{
					return null;
				}
			}
			else if(!this.mergeItemStack(itemstack1, 3, 39, false))
			{
				return null;
			}
			if(itemstack1.stackSize == 0)
			{
				slot.putStack((ItemStack) null);
			}
			else
			{
				slot.onSlotChanged();
			}
			if(itemstack1.stackSize == itemstack.stackSize)
			{
				return null;
			}
			slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
		}
		return itemstack;
	}
}
