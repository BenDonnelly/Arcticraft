package net.arcticraft.helpers;

import java.util.Random;

import net.arcticraft.gui.GuiACMainMenu;
import net.arcticraft.item.ACPotions;
import net.arcticraft.item.ItemHotWaterBottle;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.temperature.TemperatureHandler;
import net.arcticraft.temperature.handlers.LightvalueHandler;
import net.arcticraft.temperature.handlers.LocationHandler;
import net.arcticraft.temperature.handlers.MovementHandler;
import net.arcticraft.world.gen.dimension.TeleporterDim;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;

public class TickEvent{

	int pTickCounter = 0;
	int potionTick = 0;

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
			// Arcticraft.arcticraftInstance.tempHandler.addComponent(Arcticraft.arcticraftInstance.itemTempHandler);
			Arcticraft.arcticraftInstance.initialized = true;
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_L) && Keyboard.isKeyDown(Keyboard.KEY_K) && Arcticraft.DEV_MODE)
		{
			if((event.player.ridingEntity == null) && (event.player.riddenByEntity == null) && ((event.player instanceof EntityPlayerMP)))
			{
				EntityPlayerMP thePlayer = (EntityPlayerMP) event.player;

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

			if(!event.player.capabilities.isCreativeMode)
			{
				InventoryPlayer inv = event.player.inventory;

				for(ItemStack tmp : inv.mainInventory)
				{
					if(tmp != null && tmp.getItem() instanceof ItemHotWaterBottle)
					{
						int r = new Random().nextInt(500 - 0) + 0;

						if(r == 10)
						{
							if(event.player.worldObj.getBlockLightValue((int) event.player.posX, (int) event.player.posY - 1, (int) event.player.posZ) < 0.4f)
							{
								tmp.setItemDamage(tmp.getItemDamage() + 2);
							}
						}
					}
				}
			}
			if(event.player.isPotionActive(ACPotions.frostbitePotion))
			{
				potionTick++;
				// System.out.println(potionTick);
				if(potionTick >= 40)
				{
					float temp = Arcticraft.arcticraftInstance.tempHandler.getTemperature() + -1.0F;
					Arcticraft.arcticraftInstance.tempHandler.setTemperature(temp);

					IExtendedPlayerProps props = IExtendedPlayerProps.get(event.player);
					NBTTagCompound compound = new NBTTagCompound();
					props.changeTemp(temp);
					props.saveNBTData(compound);

					Arcticraft.arcticraftInstance.tempHandler.setTemperature(props.getCurrentTemp());
					potionTick = 0;
					System.out.println(Arcticraft.arcticraftInstance.tempHandler.getTemperature());
				}
			}
		}
	}

	@SubscribeEvent
	public void tickRender(RenderTickEvent event)
	{
		if(Minecraft.getMinecraft().currentScreen instanceof GuiMainMenu)
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiACMainMenu());
		}
	}
}
