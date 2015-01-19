package net.arcticraft.entities;

import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.world.World;


public class EntityGreenSparkle extends EntitySpellParticleFX{

	public EntityGreenSparkle(World world, double d, double d1, double d2, double d3, double d4, double d5)
	{
	super(world, d, d1, d2, d3, d4, d5);
	particleRed = 0.5F;
	particleGreen = 0.7F;
	particleBlue = 0.5F;
	}
	
}
