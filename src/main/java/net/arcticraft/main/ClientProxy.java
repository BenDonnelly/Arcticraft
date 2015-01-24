package net.arcticraft.main;

import net.arcticraft.gui.GuiTemperatureBar;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderThings()
	{
		MinecraftForge.EVENT_BUS.register(new GuiTemperatureBar(Minecraft.getMinecraft()));
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
