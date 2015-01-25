package net.arcticraft.temperature;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface ITempComponent {
	/**
	 * Changes the temperature by the returned value.
	 * Returning negative will decrease the temperature, returning positive will increase it.
	 * Returning '0' keeps it the same.
	 */
	public float changeTemperature(EntityPlayer player, World world);
}
