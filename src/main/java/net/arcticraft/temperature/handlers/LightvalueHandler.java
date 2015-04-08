package net.arcticraft.temperature.handlers;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LightvalueHandler implements ITempComponent
{
    @Override
	public float changeTemperature(EntityPlayer player, World world) {
    	return (1.0f / (15.f / world.getLightBrightness((int)player.posX, (int)player.posY - 1, (int)player.posZ)));
	}

	@Override
	public void handleTemperature(EntityPlayer player, World world) {
		
	}
}
