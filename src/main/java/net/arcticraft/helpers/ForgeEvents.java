package net.arcticraft.helpers;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
			System.out.println("call3");
			event.world.setBlock(event.x, event.y, event.z, ACBlocks.frostWaterIce);
		}
	}
}
