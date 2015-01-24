package net.arcticraft.helpers;

import net.arcticraft.main.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class IExtendedPlayerProps implements IExtendedEntityProperties{

	/*DONT uncomment out the commented old code; its the code without datawatchers which i might need to revert if i find a bug in datawatchers or something, not done testing yet ~ ben*/
	
	public final static String EXT_PROP_NAME = "ExtendedPlayerProps";

	private final EntityPlayer player;

	// private int currentTemp, maxTemp;

	private int maxTemp;
	public static final int CURRENT_TEMP_WATCHER = 24;
	
	public IExtendedPlayerProps(EntityPlayer player){
		this.player = player;
		// starting temp for each player
		// this.currentTemp = this.maxTemp = 100;
		this.maxTemp = 100;
		this.player.getDataWatcher().addObject(CURRENT_TEMP_WATCHER, this.maxTemp);
	}

	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 */
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(IExtendedPlayerProps.EXT_PROP_NAME, new IExtendedPlayerProps(player));
	}

	/**
	 * Returns ExtendedPlayer properties for player
	 */
	public static final IExtendedPlayerProps get(EntityPlayer player)
	{
		return (IExtendedPlayerProps) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = new NBTTagCompound();

		properties.setInteger("CurrentTemp", this.player.getDataWatcher().getWatchableObjectInt(CURRENT_TEMP_WATCHER));
		//properties.setInteger("CurrentTemp", this.currentTemp);
		properties.setInteger("MaxTemp", this.maxTemp);

		compound.setTag(EXT_PROP_NAME, properties);
		//System.out.println("Saving Temp to NBT: " + this.currentTemp + "/" + this.maxTemp);
		System.out.println("Saving Temp to NBT: " + this.player.getDataWatcher().getWatchableObjectInt(CURRENT_TEMP_WATCHER) + "/" + this.maxTemp);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		//this.currentTemp = properties.getInteger("CurrentTemp");
		this.player.getDataWatcher().updateObject(CURRENT_TEMP_WATCHER, properties.getInteger("CurrentTemp"));
		this.maxTemp = properties.getInteger("MaxTemp");
		//System.out.println("Temp from NBT: " + this.currentTemp + "/" + this.maxTemp);
		System.out.println("Temp from NBT: " + this.player.getDataWatcher().getWatchableObjectInt(CURRENT_TEMP_WATCHER) + "/" + this.maxTemp);

	}

	@Override
	public void init(Entity entity, World world) {}

	public int getCurrentTemp()
	{
		int temp = this.player.getDataWatcher().getWatchableObjectInt(CURRENT_TEMP_WATCHER);
		return temp;
		//return currentTemp;
	}

	public int getMaxTemp()
	{
		return maxTemp;
	}

	public void printCurrentTemp()
	{
		//System.out.println(this.currentTemp + "/" + this.maxTemp);
		System.out.println(this.player.getDataWatcher().getWatchableObjectInt(CURRENT_TEMP_WATCHER) + "/" + this.maxTemp);
	}

	public void changeTemp(int newTemp)
	{ 
		this.player.getDataWatcher().updateObject(CURRENT_TEMP_WATCHER, (newTemp < this.maxTemp ? newTemp : this.maxTemp));
	}
}
