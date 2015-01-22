package net.arcticraft.main;

import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraftforge.common.DimensionManager;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderThings()
	{

	}

	@Override
	public void registerGeneral()
	{
		/** Adds generators to Dimension **/

		/** Register WorldProvider for Dimension **/
		DimensionManager.registerProviderType(3, WorldProviderDim.class, true);
		DimensionManager.registerDimension(3, 3);
	}
}
