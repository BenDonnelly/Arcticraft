package net.arcticraft.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ForgeEvents{

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if(event.entity instanceof EntityPlayer && IExtendedPlayerProps.get((EntityPlayer) event.entity) == null)
			IExtendedPlayerProps.register((EntityPlayer) event.entity);
	}
}
