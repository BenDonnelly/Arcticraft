package net.arcticraft.helpers;

import net.arcticraft.gui.GuiACMainMenu;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.temperature.TemperatureHandler;
import net.arcticraft.temperature.handlers.LightvalueHandler;
import net.arcticraft.temperature.handlers.LocationHandler;
import net.arcticraft.temperature.handlers.MovementHandler;
import net.arcticraft.world.gen.dimension.TeleporterDim;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayerMP;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TickEvent{
	@SubscribeEvent
	public void tickPlayer(PlayerTickEvent event)
	{
		if(!Arcticraft.arcticraftInstance.initialized)
		{	
			Arcticraft.arcticraftInstance.tempHandler = new TemperatureHandler();
			Arcticraft.arcticraftInstance.lightvalueHandler = new LightvalueHandler();
			Arcticraft.arcticraftInstance.locationHandler = new LocationHandler();
			Arcticraft.arcticraftInstance.movementHandler = new MovementHandler();	
			Arcticraft.arcticraftInstance.tempHandler.addComponent(Arcticraft.arcticraftInstance.chunkProvider);
			Arcticraft.arcticraftInstance.tempHandler.addComponent(Arcticraft.arcticraftInstance.locationHandler);
			Arcticraft.arcticraftInstance.tempHandler.addComponent(Arcticraft.arcticraftInstance.movementHandler);
			Arcticraft.arcticraftInstance.tempHandler.addComponent(Arcticraft.arcticraftInstance.lightvalueHandler);
			//Arcticraft.arcticraftInstance.tempHandler.addComponent(Arcticraft.arcticraftInstance.itemTempHandler);
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

    	if(event.player.dimension == 3)
		{
    		if(event.player.isDead)
    		{
    			event.player.setPosition(Arcticraft.arcticraftInstance.tper.portalX + 0.5D, Arcticraft.arcticraftInstance.tper.portalY + 3D, Arcticraft.arcticraftInstance.tper.portalZ + 0.5D);    			
    		}
    		
    		if(!event.player.capabilities.isCreativeMode)
    		{
    			Arcticraft.arcticraftInstance.tempHandler.tick(event.player, event.player.worldObj);
    		}
		}
	}
	
	@SubscribeEvent
	public void tickClient(ClientTickEvent event){
		
		if(Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu)
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiACMainMenu());
		}
			
	}
	
}
