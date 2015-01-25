package net.arcticraft.temperature;

import java.util.ArrayList;

import net.arcticraft.helpers.IExtendedPlayerProps;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TemperatureHandler {
	private EntityPlayer player = null;
	private float temperature = 100F;
	
	private ArrayList<ITempComponent> components = new ArrayList<ITempComponent>();
	
	public TemperatureHandler()
	{
		
	}
	
	public EntityPlayer getPlayer()
	{
		return this.player;
	}
	
	public void setTemperature(float temperature)
	{
		if(temperature >= 100F)
		{
			this.temperature = 100F;
		}
		else if(temperature <= 0F)
		{
			this.temperature = 0F;
		}
		else
		{
			this.temperature = temperature;
		}
	}
	
	public float getTemperature()
	{
		IExtendedPlayerProps props = IExtendedPlayerProps.get(player);
		
		return props.getCurrentTemp();
	}
	
	public void modifyTemperature(float temperature)
	{
		this.setTemperature(this.getTemperature() + temperature);
	}
	
	public void tick(EntityPlayer player, World world)
	{
		this.player = player;		
		this.temperature = 0;
		
		for(ITempComponent tmp : components)
		{
			this.modifyTemperature(tmp.changeTemperature(player, world));			
			
			IExtendedPlayerProps props = IExtendedPlayerProps.get(player);
			props.changeTemp(this.temperature);
		}
	}
	
	public void addComponent(ITempComponent component)
	{
		components.add(component);
	}
}
