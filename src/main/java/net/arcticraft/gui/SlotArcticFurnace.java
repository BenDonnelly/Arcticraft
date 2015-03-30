package net.arcticraft.gui;

import net.arcticraft.crafting.ACFurnaceRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class SlotArcticFurnace extends Slot{

	/** The player that is using the GUI where this slot resides. */
	private EntityPlayer thePlayer;
	private int field_75228_b;

	public SlotArcticFurnace(EntityPlayer player, IInventory inv, int x, int y, int z){
		super(inv, x, y, z);
		this.thePlayer = player;
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	 */
	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
		return false;
	}

	/**
	 * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new stack.
	 */
	@Override
	public ItemStack decrStackSize(int slot)
	{
		if(this.getHasStack())
		{
			this.field_75228_b += Math.min(slot, this.getStack().stackSize);
		}
		return super.decrStackSize(slot);
	}

	@Override
	public void onPickupFromSlot(EntityPlayer player, ItemStack itemstack)
	{
		this.onCrafting(itemstack);
		super.onPickupFromSlot(player, itemstack);
	}

	/**
	 * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an internal count then calls onCrafting(item).
	 */
	@Override
	protected void onCrafting(ItemStack itemstack, int slot)
	{
		this.field_75228_b += slot;
		this.onCrafting(itemstack);
	}

	/**
	 * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
	 */
	@Override
	protected void onCrafting(ItemStack itemstack)
	{
		itemstack.onCrafting(this.thePlayer.worldObj, this.thePlayer, this.field_75228_b);
		if(!this.thePlayer.worldObj.isRemote)
		{
			int i = this.field_75228_b;
			float f = ACFurnaceRecipes.smelting().getExperience(itemstack);
			int j;
			if(f == 0.0F)
			{
				i = 0;
			}
			else if(f < 1.0F)
			{
				j = MathHelper.floor_float((float) i * f);
				if(j < MathHelper.ceiling_float_int((float) i * f) && (float) Math.random() < (float) i * f - (float) j)
				{
					++j;
				}
				i = j;
			}
			while(i > 0)
			{
				j = EntityXPOrb.getXPSplit(i);
				i -= j;
				this.thePlayer.worldObj.spawnEntityInWorld(new EntityXPOrb(this.thePlayer.worldObj, this.thePlayer.posX, this.thePlayer.posY + 0.5D, this.thePlayer.posZ + 0.5D, j));
			}
		}
		this.field_75228_b = 0;
		FMLCommonHandler.instance().firePlayerSmeltedEvent(thePlayer, itemstack);
		if(itemstack.getItem() == Items.iron_ingot)
		{
			this.thePlayer.addStat(AchievementList.acquireIron, 1);
		}
		if(itemstack.getItem() == Items.cooked_fished)
		{
			this.thePlayer.addStat(AchievementList.cookFish, 1);
		}
	}
}
