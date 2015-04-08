package net.arcticraft.helpers;

import net.arcticraft.main.CommonProxy;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class IExtendedPlayerProps implements IExtendedEntityProperties {
	public static final String EXT_PROP_NAME = "AC_ExtendedPlayerProps";
	public static final int CURRENT_TEMP_WATCHER = 24;

	private final float maxTemp = 100.0F;
	private EntityPlayer player;
	private int tempTimer;
	private int frostBiteTimer;
	//If you need more player timers, feel free to make an array of all timers with their (static final) IDs

	/**
	 * Used to register these extended properties for the player during
	 * EntityConstructing event
	 */
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(IExtendedPlayerProps.EXT_PROP_NAME, new IExtendedPlayerProps());
	}

	/**
	 * Do not use this method to do stuff regarding temperature modification. Use the TemperatureHandler.
	 * @return ExtendedPlayer properties for player
	 */
	public static final IExtendedPlayerProps get(EntityPlayer player) {
		return (IExtendedPlayerProps) player.getExtendedProperties(EXT_PROP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setFloat("CurrentTemp", this.getCurrentTemp());
		properties.setInteger("TempTimer", this.tempTimer);
		properties.setInteger("FrostBiteTimer", this.frostBiteTimer);
		compound.setTag(EXT_PROP_NAME, properties);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.setCurrentTemp(properties.getFloat("CurrentTemp"));
		this.tempTimer = properties.getInteger("TempTimer");
		this.frostBiteTimer = properties.getInteger("FrostBiteTimer");
	}

	@Override
	public void init(Entity entity, World world) {
		this.player = (EntityPlayer) entity;
		this.tempTimer = 0;
		this.frostBiteTimer = 0;
		this.player.getDataWatcher().addObject(CURRENT_TEMP_WATCHER, this.maxTemp);
	}

	/**
	 * Sets the current temperature to be clamped within 0 and maxTemp. DO NOT call this, use TemperatureHandler.setTemperature()
	 * 
	 * @param temp The new temperature value
	 */
	public void setCurrentTemp(float temp) {
		this.player.getDataWatcher().updateObject(CURRENT_TEMP_WATCHER, MathHelper.clamp_float(temp, 0.0F, this.maxTemp));
	}

	public float getCurrentTemp() {
		return this.player.getDataWatcher().getWatchableObjectFloat(CURRENT_TEMP_WATCHER);
	}

	public float getMaxTemp() {
		return this.maxTemp;
	}

	public int getTempTimer() {
		return this.tempTimer;
	}
	
	public int getFrostBiteTimer() {
		return this.frostBiteTimer;
	}
	
	/**
	 * Increments the timer that counts down when to inflict damage on a player when he has frostbite
	 * 
	 * @param timer The new timer value
	 */
	public void incrementFrostBiteTimer() {
		this.frostBiteTimer++;
	}
	
	/**
	 * Resets the frostbite timer back to 0
	 */
	public void resetFrostBiteTimer() {
		this.frostBiteTimer = 0;
	}

	/**
	 * Increments the timer that counts down when to inflict damage on a player when he is on 0 temperature
	 * 
	 * @param timer The new timer value
	 */
	public void incrementTempTimer() {
		this.tempTimer++;
	}
	
	/**
	 * Resets the temperature timer back to 0
	 */
	public void resetTempTimer() {
		this.tempTimer = 0;
	}
}
