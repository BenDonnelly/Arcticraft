package net.arcticraft.temperature;

import java.util.ArrayList;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.helpers.IExtendedPlayerProps;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class TemperatureHandler {

	private static ArrayList<ITempComponent> components = new ArrayList<ITempComponent>();

	public static void setTemperature(EntityPlayer player, float temperature) {
		IExtendedPlayerProps.get(player).setCurrentTemp(temperature);
	}

	public static float getTemperature(EntityPlayer player) {
		return IExtendedPlayerProps.get(player).getCurrentTemp();
	}

	public static float getMaxTemperature(EntityPlayer player) {
		return IExtendedPlayerProps.get(player).getMaxTemp();
	}

	/**
	 * Modifies the player's temperature by the amount specified: this can be positive, negative or 0 (no change)
	 * @param player The player
	 * @param temperature The amount that should modify the current temperature
	 */
	public static void modifyTemperature(EntityPlayer player, float temperature) {
		setTemperature(player, getTemperature(player) + temperature);
	}

	private static void incrementTempTimer(EntityPlayer player) {
		IExtendedPlayerProps.get(player).incrementTempTimer();
	}
	
	private static int getTempTimer(EntityPlayer player) {
		return IExtendedPlayerProps.get(player).getTempTimer();
	}
	
	private static void resetTempTimer(EntityPlayer player) {
		IExtendedPlayerProps.get(player).resetTempTimer();
	}

	public static void tick(EntityPlayer player, World world) {
		if(!world.isRemote) {
			for (ITempComponent tmp : components) {
				modifyTemperature(player, tmp.changeTemperature(player, world));
				tmp.handleTemperature(player, world);
			}

			if (getTemperature(player) == 0) {
				incrementTempTimer(player);

				if (getTempTimer(player) >= 40) {
					player.attackEntityFrom(DamageSource.starve, 1.0F);

					resetTempTimer(player);
				}
			}
		}
	}

	public static void addComponent(ITempComponent component) {
		components.add(component);
	}
}
