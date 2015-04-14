package net.arcticraft.helpers;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;

public class ForgeEvents{

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		if(event.entity instanceof EntityPlayer && IExtendedPlayerProps.get((EntityPlayer) event.entity) == null) IExtendedPlayerProps.register((EntityPlayer) event.entity);
	}

	@SubscribeEvent
	public void fillBucket(FillBucketEvent event)
	{
		if(event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ) == ACBlocks.frostWaterBlock)
		{
			System.out.println("no vanilla buckets allowed init");
			event.setCanceled(true);
		}

	}

	@SubscribeEvent
	public void replaceVanillaWater(PlaceEvent event)
	{
		if(event.player.dimension == 3 && event.placedBlock == Blocks.flowing_water || event.placedBlock == Blocks.water)
		{
			event.world.setBlock(event.x, event.y, event.z, ACBlocks.frostWaterIce);
		}
	}

	@SubscribeEvent
	public void playerInteract(PlayerInteractEvent event)
	{
		ItemStack hand = event.entityPlayer.inventory.getCurrentItem();
		if(!event.world.isRemote && event.entityPlayer != null && hand != null)
		{
			if(event.entityPlayer.dimension == 3 && hand.getItem() == Items.water_bucket)
			{
				if(event.action == event.action.RIGHT_CLICK_AIR)
				{
					event.setCanceled(true);
					event.entityPlayer.addChatMessage(new ChatComponentText("The air is too cold for the water to be poured here."));
				}
			}
		}
	}

	/*
	 * @SubscribeEvent public void pourBucket(PlayerUseItemEvent.Tick event) { MovingObjectPosition position = Minecraft.getMinecraft().objectMouseOver; // Block block = event.entityPlayer.worldObj.getBlock(position.blockX, position.blockY,
	 * position.blockZ); System.out.println("call"); if(event.entityPlayer.dimension == 3 && event.item.getItem() == Items.water_bucket) { event.entityPlayer.worldObj.setBlock(position.blockX, position.blockY, position.blockZ,
	 * ACBlocks.frostWaterIce); } }
	 */
}
