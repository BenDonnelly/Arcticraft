package net.arcticraft.entities;

import net.arcticraft.main.Arcticraft;
import net.minecraft.world.World;

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
		ACEntityRegistry.createEntity(EntitySled.class, "EntitySled", false, 0x00, 0x00, Arcticraft.arcticraftInstance);			
		
	}
}
