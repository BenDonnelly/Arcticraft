package net.arcticraft.helpers;

import net.arcticraft.main.Arcticraft;
import net.arcticraft.world.gen.dimension.TeleporterDim;
import net.minecraft.entity.player.EntityPlayerMP;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickPlayerEvent{

	@SubscribeEvent
	public void tickPlayer(PlayerTickEvent event)
	{

		if(Keyboard.isKeyDown(Keyboard.KEY_L) && Keyboard.isKeyDown(Keyboard.KEY_K) && Arcticraft.DEV_MODE)
		{
			if((event.player.ridingEntity == null) && (event.player.riddenByEntity == null) && ((event.player instanceof EntityPlayerMP)))
			{
				EntityPlayerMP thePlayer = (EntityPlayerMP) event.player;
				if(thePlayer.timeUntilPortal > 0)
				{
					thePlayer.timeUntilPortal = 10;
				}
				else if(thePlayer.dimension != 3)
				{
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 3, new TeleporterDim(thePlayer.mcServer.worldServerForDimension(3)));
				}
				else
				{
					thePlayer.timeUntilPortal = 10;
					thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterDim(thePlayer.mcServer.worldServerForDimension(3)));
				}
			}
		}
		
	}

}
