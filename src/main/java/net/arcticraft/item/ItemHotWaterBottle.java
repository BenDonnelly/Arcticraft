package net.arcticraft.item;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.helpers.IExtendedPlayerProps;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemHotWaterBottle extends Item
{
	public ItemHotWaterBottle(){
		this.maxStackSize = 1;
		
		this.setMaxDamage(40);
	}
	
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
	@Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
		if(!world.isRemote)
		{
			if(itemstack.getItem().getDamage(itemstack) > 20)
			{
				//Arcticraft.arcticraftInstance.tempHandler.modifyTemperature(-10);
				
				float temp = Arcticraft.arcticraftInstance.tempHandler.getTemperature() + -itemstack.getItem().getDamage(itemstack);
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);
				
				IExtendedPlayerProps props = IExtendedPlayerProps.get(player);			
				NBTTagCompound compound = new NBTTagCompound();
				props.changeTemp(temp);
				props.saveNBTData(compound);
				
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
			}
			else if(itemstack.getItem().getDamage(itemstack) <= 20)
			{
				float temp = Arcticraft.arcticraftInstance.tempHandler.getTemperature() + (20 - itemstack.getItem().getDamage(itemstack));
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);
				
				IExtendedPlayerProps props = IExtendedPlayerProps.get(player);			
				NBTTagCompound compound = new NBTTagCompound();
				props.changeTemp(temp);
				props.saveNBTData(compound);
				
				Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
			}
		}
		
        return new ItemStack(itemstack.getItem(), 0);
    }
}
