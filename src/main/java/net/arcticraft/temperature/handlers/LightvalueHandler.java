package net.arcticraft.temperature.handlers;

import net.arcticraft.temperature.ITempComponent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class LightvalueHandler implements ITempComponent
{
    @Override
	public float changeTemperature(EntityPlayer player, World world) {
    	return 1.0F / (15.0F / world.getLightBrightness((int)player.posX, (int)player.posY - 1, (int)player.posZ));
	}
}
