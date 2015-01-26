package net.arcticraft.main;

import net.arcticraft.entities.*;
import net.arcticraft.entities.passive.*;
import net.arcticraft.entities.renderer.*;
import net.arcticraft.entities.model.*;
import net.arcticraft.gui.GuiFreezedScreen;
import net.arcticraft.gui.GuiTemperatureBar;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderThings()
	{
		MinecraftForge.EVENT_BUS.register(new GuiTemperatureBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiFreezedScreen(Minecraft.getMinecraft()));

		RenderingRegistry.registerEntityRenderingHandler(EntitySled.class, new RenderSled());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(new ModelBoar(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new RenderPenguin(new ModelPenguin(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderIceMage(new ModelIceMage(), 0.6F));
	}

	@Override
	public void registerGeneral()
	{
		/** Adds generators to Dimension **/

		/** Register WorldProvider for Dimension **/
		DimensionManager.registerProviderType(3, WorldProviderDim.class, true);
		DimensionManager.registerDimension(3, 3);
	}

	@Override
	public int addArmor(String armour)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armour);
	}

}
