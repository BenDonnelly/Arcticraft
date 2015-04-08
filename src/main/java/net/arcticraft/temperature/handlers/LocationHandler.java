package net.arcticraft.temperature.handlers;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LocationHandler implements ITempComponent
{
    @Override
	public float changeTemperature(EntityPlayer player, World world) {
    	if(player.isInWater())
    	{
    		return -0.065F;
    	}
    	else if(world.isRaining())
    	{
    		return -0.0130F;
    	}
    	
    	return 0;
	}

	@Override
	public void handleTemperature(EntityPlayer player, World world) {
		
	}
}
