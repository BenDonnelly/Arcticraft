package net.arcticraft.entities;

import net.arcticraft.API.utils.ColourUtils;
import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.arcticraft.entities.hostile.EntityFrostZombie;
import net.arcticraft.entities.hostile.EntityPirate;
import net.arcticraft.entities.passive.EntityArcticGhost;
import net.arcticraft.entities.passive.EntityCaveman;
import net.arcticraft.entities.passive.EntityEskimo;
import net.arcticraft.entities.passive.EntityEskimoChef;
import net.arcticraft.entities.passive.EntityEskimoChief;
import net.arcticraft.entities.passive.EntityEskimoHunter;
import net.arcticraft.entities.passive.EntityEskimoTrader;
import net.arcticraft.entities.passive.EntityHusky;
import net.arcticraft.entities.passive.EntityIceMage;
import net.arcticraft.entities.passive.EntityPenguin;
import net.arcticraft.entities.passive.EntityPolarBear;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.world.gen.dimension.GenLayerBiomesDim;
import net.arcticraft.world.gen.dimension.biome.ACBiomeGenBase;
import net.minecraft.entity.EnumCreatureType;

import com.arcanumLudum.ALCore.entity.ALEntityRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ACEntities
{
	public static void loadEntities()
	{
		initEntities();
		registerEntities();
	}
	
	public static void initEntities()
	{
		
	}
	
	public static void registerEntities()
	{
		ALEntityRegistry.createEntity(EntityCannonball.class, "Cannonball", false, 0x00, 0x00, Arcticraft.arcticraftInstance);	
		ALEntityRegistry.createEntity(EntitySled.class, "EntitySled", false, 0x00, 0x00, Arcticraft.arcticraftInstance);
		ALEntityRegistry.createEntity(EntityCaptainHook.class, "CaptainHook", false, 0x00, 0x00, Arcticraft.arcticraftInstance);
		ALEntityRegistry.createEntity(EntityBomb.class, "Bomb", false, 0x00, 0x00, Arcticraft.arcticraftInstance);
		
		EntityRegistry.registerGlobalEntityID(EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.netherQuartzColour, ColourUtils.brownishColour);
		EntityRegistry.registerGlobalEntityID(EntityPenguin.class, "Penguin", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.blackColour, ColourUtils.whiteColour);
		EntityRegistry.registerGlobalEntityID(EntityIceMage.class, "IceMage", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.kindaBlueColour, ColourUtils.purpleBlueishColour);
		EntityRegistry.registerGlobalEntityID(EntityCaveman.class, "Caveman", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.lightBlueColour, ColourUtils.blueishIcyColour);
		EntityRegistry.registerGlobalEntityID(EntityFrostZombie.class, "FrostZombie", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.zombieBackGround, ColourUtils.zombieSpots);
		EntityRegistry.registerGlobalEntityID(EntityCaptain.class, "Captain", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.redishPinkishColour, ColourUtils.blackColour);
		EntityRegistry.registerGlobalEntityID(EntityPirate.class, "Pirate", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.blackColour, ColourUtils.redishPinkishColour);
		EntityRegistry.registerGlobalEntityID(EntityPolarBear.class, "PolarBear", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.whiteColour, ColourUtils.whiteColour);
		EntityRegistry.registerGlobalEntityID(EntityArcticGhost.class, "ArcticGhost", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.lightGrayColour, ColourUtils.grayColour);
		EntityRegistry.registerGlobalEntityID(EntityHusky.class, "Husky", EntityRegistry.findGlobalUniqueEntityId(), ColourUtils.grayColour, ColourUtils.lightGrayColour);

		/* Eskimo's */
		EntityRegistry.registerGlobalEntityID(EntityEskimoChief.class, "EntityEskimoChief", EntityRegistry.findGlobalUniqueEntityId(), 0x7BE6E8, 0x000000);
		EntityRegistry.registerGlobalEntityID(EntityEskimoChef.class, "EntityEskimoChef", EntityRegistry.findGlobalUniqueEntityId(), 0x7BE6E8, 0x000000);
		EntityRegistry.registerGlobalEntityID(EntityEskimoHunter.class, "EntityEskimoHunter", EntityRegistry.findGlobalUniqueEntityId(), 0x7BE6E8, 0x000000);
		EntityRegistry.registerGlobalEntityID(EntityEskimoTrader.class, "EntityEskimoTrader", EntityRegistry.findGlobalUniqueEntityId(), 0x7BE6E8, 0x000000);
		EntityRegistry.registerGlobalEntityID(EntityEskimo.class, "EntityEskimo", EntityRegistry.findGlobalUniqueEntityId(), 0x7BE6E8, 0x000000);

		for(ACBiomeGenBase tmp : GenLayerBiomesDim.allowedBiomes)
		{
			if(tmp != null)
			{
				EntityRegistry.addSpawn(EntityPenguin.class, 1, 1, 1, EnumCreatureType.ambient, tmp);
			}
		}
	}
}
