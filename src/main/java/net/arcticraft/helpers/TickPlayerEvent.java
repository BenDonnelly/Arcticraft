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
		if(!Arcticraft.arcticraftInstance.initialized)
		{		
			Arcticraft.arcticraftInstance.initialized = true;
		}
		
    	if(Keyboard.isKeyDown(Keyboard.KEY_L) && Keyboard.isKeyDown(Keyboard.KEY_K) && Arcticraft.DEV_MODE)
    	{
    		if ((event.player.ridingEntity == null) && (event.player.riddenByEntity == null) && ((event.player instanceof EntityPlayerMP)))
    		{    	
    			EntityPlayerMP thePlayer = (EntityPlayerMP)event.player;
    			
    			Arcticraft.arcticraftInstance.tper = new TeleporterDim(thePlayer.mcServer.worldServerForDimension(3));	
    			Arcticraft.arcticraftInstance.tper.teleportEntity(thePlayer, 3);
    		}
    	}

		if(event.player.isDead)
		{
			if(event.player.dimension == 3)
			{
				event.player.setPosition(Arcticraft.arcticraftInstance.tper.portalX + 0.5D, Arcticraft.arcticraftInstance.tper.portalY + 3D, Arcticraft.arcticraftInstance.tper.portalZ + 0.5D);
			}
		}
	}
}
