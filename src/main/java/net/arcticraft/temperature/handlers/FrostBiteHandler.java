package net.arcticraft.temperature.handlers;

import net.arcticraft.API.temp.ITempComponent;
import net.arcticraft.helpers.IExtendedPlayerProps;
import net.arcticraft.item.ACPotions;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class FrostBiteHandler implements ITempComponent {

	private static void incrementFrostBiteTimer(EntityPlayer player) {
		IExtendedPlayerProps.get(player).incrementFrostBiteTimer();;
	}
	
	private static int getFrostBiteTimer(EntityPlayer player) {
		return IExtendedPlayerProps.get(player).getFrostBiteTimer();
	}
	
	private static void resetFrostBiteTimer(EntityPlayer player) {
		IExtendedPlayerProps.get(player).resetFrostBiteTimer();
	}
	
	@Override
	public float changeTemperature(EntityPlayer player, World world) {
		if (player.isPotionActive(ACPotions.frostbitePotion)) {
			incrementFrostBiteTimer(player);
			
			if (getFrostBiteTimer(player) >= 40) {
				resetFrostBiteTimer(player);
				return -1.0F;
			}
			else {
				return 0;
			}
		}
		else {
			return 0;
		}
	}

	@Override
	public void handleTemperature(EntityPlayer player, World world) {
		
	}

}
