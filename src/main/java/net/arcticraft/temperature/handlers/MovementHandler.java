package net.arcticraft.temperature.handlers;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MovementHandler implements ITempComponent
{
    @Override
	public float changeTemperature(EntityPlayer player, World world) {
    	if(player.isSprinting())
    	{
    		return 0.0130F;
    	}
    	
    	return 0F;
	}

	@Override
	public void handleTemperature(EntityPlayer player, World world) {
		if(Math.round(TemperatureHandler.getTemperature(player)) <= 20F)
		{
			player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(.05F);
		}
	}
}
