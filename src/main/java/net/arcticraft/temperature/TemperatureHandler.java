package net.arcticraft.temperature;

import java.util.ArrayList;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.helpers.IExtendedPlayerProps;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.temperature.handlers.LightvalueHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TemperatureHandler {
	private EntityPlayer player = null;
	private float temperature = 100F;
	
	private int tickCounter = 0;
	
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
		this.tickCounter++;
		this.player = player;		
		this.temperature = 0;
		
		for(ITempComponent tmp : components)
		{
			this.setTemperature(this.getTemperature() + tmp.changeTemperature(player, world, this));	
			tmp.handleTemperature(player, world, this);
			
			IExtendedPlayerProps props = IExtendedPlayerProps.get(player);			
			NBTTagCompound compound = new NBTTagCompound();
			props.changeTemp(this.temperature);
			props.saveNBTData(compound);
		}
		
		if(this.getTemperature() == 0)
		{			
			if(this.tickCounter >= 80)
			{
				player.setHealth(player.getHealth() - 0.5F);
				
				this.tickCounter = 0;
			}
		}
	}
	
	public void addComponent(ITempComponent component)
	{
		components.add(component);
	}
}
