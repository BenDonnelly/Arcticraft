package net.arcticraft.entities;

import net.arcticraft.entities.passive.EntityBoar;
import net.arcticraft.entities.passive.EntityCaveman;
import net.arcticraft.entities.passive.EntityIceMage;
import net.arcticraft.entities.passive.EntityPenguin;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.world.gen.dimension.GenLayerBiomesDim;
import net.arcticraft.world.gen.dimension.biome.ACBiomeGenBase;
import net.minecraft.entity.EnumCreatureType;
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
		ACEntityRegistry.createEntity(EntityCannonball.class, "Cannonball", false, 0x00, 0x00, Arcticraft.arcticraftInstance);	
		ACEntityRegistry.createEntity(EntitySled.class, "EntitySled", false, 0x00, 0x00, Arcticraft.arcticraftInstance);
		EntityRegistry.registerGlobalEntityID(EntityBoar.class, "Boar", EntityRegistry.findGlobalUniqueEntityId(), netherQuartzColour, netherQuartzColour);
		EntityRegistry.registerGlobalEntityID(EntityPenguin.class, "Penguin", EntityRegistry.findGlobalUniqueEntityId(), blackColour, whiteColour);
		EntityRegistry.registerGlobalEntityID(EntityIceMage.class, "IceMage", EntityRegistry.findGlobalUniqueEntityId(), kindaBlueColour, purpleBlueishColour);
		EntityRegistry.registerGlobalEntityID(EntityCaveman.class, "Caveman", EntityRegistry.findGlobalUniqueEntityId(), lightBlueColour, blueishIcyColour);

		for(ACBiomeGenBase tmp : GenLayerBiomesDim.allowedBiomes)
		{
			if(tmp != null)
			{
				EntityRegistry.addSpawn(EntityPenguin.class, 1, 1, 1, EnumCreatureType.ambient, tmp);
			}
		}
	}
}
