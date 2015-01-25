package net.arcticraft.main;

import net.arcticraft.entities.EntitySled;
import net.arcticraft.entities.renderer.RenderSled;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public void registerRenderThings()
	{
		
	}
	
	public void registerGeneral()
	{
		/** Adds generators to Dimension **/
		
		
		/** Register WorldProvider for Dimension **/
		DimensionManager.registerProviderType(3, WorldProviderDim.class, true);
		DimensionManager.registerDimension(3, 3);
	}
}
