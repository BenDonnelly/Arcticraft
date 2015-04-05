package net.arcticraft.item;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ItemArcticPouchInventory extends InventoryBasic{

	private final ItemStack ap;
	protected String uniqueID;

	public ItemArcticPouchInventory(ItemStack itemstack){
		super("Arctic Pouch", true, 27);

		uniqueID = "";

		if(!itemstack.hasTagCompound())
		{
			itemstack.setTagCompound(new NBTTagCompound());
		}
		this.ap = itemstack;
		readFromNBT(itemstack.getTagCompound());
	}

	@Override
	public String getInventoryName()
	{
		return this.uniqueID;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return super.getStackInSlot(index);
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack)
	{
		if(itemstack.getItem() instanceof ItemArcticPouch || itemstack.getItem() == ACItems.arcticPouch)
		{
			return false;
		}
		
		return true;
	}

	@Override
	public void markDirty()
	{
		for(int i = 0; i < this.getSizeInventory(); ++i)
		{
			if(this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize == 0) this.setInventorySlotContents(i, null);
		}
	}

	public void readFromNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = tagcompound.getTagList("ApInventory", tagcompound.getId());

		for(int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			int i0 = nbttagcompound1.getInteger("Slot");

			if(i0 >= 0 && i0 < this.getSizeInventory() - 1)
			{
				this.setInventorySlotContents(i0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}
		}

	}

	public void writeToNBT(NBTTagCompound tagcompound)
	{
		NBTTagList nbttaglist = new NBTTagList();

		for(int i = 0; i < this.getSizeInventory() - 1; ++i)
		{
			if(this.getStackInSlot(i) != null)
			{
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setInteger("Slot", (int) i);
				this.getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		tagcompound.setTag("ApInventory", nbttaglist);
		tagcompound.setString("uniqueID", this.uniqueID);
	}
}
