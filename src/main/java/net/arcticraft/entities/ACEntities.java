package net.arcticraft.entities;

import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.arcticraft.entities.hostile.EntityFrostZombie;
import net.arcticraft.entities.hostile.EntityPirate;
import net.arcticraft.entities.passive.EntityCaveman;
import net.arcticraft.entities.passive.EntityEskimo;
import net.arcticraft.entities.passive.EntityEskimoChef;
import net.arcticraft.entities.passive.EntityEskimoChief;
import net.arcticraft.entities.passive.EntityEskimoHunter;
import net.arcticraft.entities.passive.EntityEskimoTrader;
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
	static int zombieBackGround = 0x00AFAF;
	static int zombieSpots = 0x5FA88E;
	static int whiteColour = 0xffffff;
	static int blackColour = 0x000000;
	static int grayColour = 0x424242;
	static int lightGrayColour = 0xEEEEEE;
	static int lightBlueColour = 0xAFF5FF;
	static int blueishIcyColour = 0x3EA6CF;
	static int kindaBlueColour = 0x337BC7;
	static int purpleBlueishColour = 0x6419F0;
	static int redishPinkishColour = 0xEB0E58;
	static int greenishColour = 0x99FF66;
	static int yellowishColour = 0xFFFF33;
	static int brownishColour = 0x63560A;
	static int purpleishColour = 0x6B13AD;
	static int grayishIronishColour = 0x949191;
	static int enderColour = 0xCA75EF;
	static int goldishColour = 0xF7DB5E;
	static int netherQuartzColour = 0xCACDDB;
	static int lapisishColour = 0x536CE0;
	static int redishColour = 0xDE2644;
	static int muckyGreenColour = 0x354f30;
	
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
		
		EntityRegistry.registerGlobalEntityID(EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId(), netherQuartzColour, brownishColour);
		EntityRegistry.registerGlobalEntityID(EntityPenguin.class, "Penguin", EntityRegistry.findGlobalUniqueEntityId(), blackColour, whiteColour);
		EntityRegistry.registerGlobalEntityID(EntityIceMage.class, "IceMage", EntityRegistry.findGlobalUniqueEntityId(), kindaBlueColour, purpleBlueishColour);
		EntityRegistry.registerGlobalEntityID(EntityCaveman.class, "Caveman", EntityRegistry.findGlobalUniqueEntityId(), lightBlueColour, blueishIcyColour);
		EntityRegistry.registerGlobalEntityID(EntityFrostZombie.class, "FrostZombie", EntityRegistry.findGlobalUniqueEntityId(), zombieBackGround, zombieSpots);
		EntityRegistry.registerGlobalEntityID(EntityCaptain.class, "Captain", EntityRegistry.findGlobalUniqueEntityId(), redishPinkishColour, blackColour);
		EntityRegistry.registerGlobalEntityID(EntityPirate.class, "Pirate", EntityRegistry.findGlobalUniqueEntityId(), blackColour, redishPinkishColour);
		EntityRegistry.registerGlobalEntityID(EntityPolarBear.class, "PolarBear", EntityRegistry.findGlobalUniqueEntityId(), whiteColour, whiteColour);
		
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
