package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.EntityCannonball;
import net.arcticraft.entities.EntitySled;
import net.arcticraft.entities.model.ModelBoar;
import net.arcticraft.entities.model.ModelCaveman;
import net.arcticraft.entities.model.ModelIceMage;
import net.arcticraft.entities.model.ModelPenguin;
import net.arcticraft.entities.passive.EntityBoar;
import net.arcticraft.entities.passive.EntityCaveman;
import net.arcticraft.entities.passive.EntityIceMage;
import net.arcticraft.entities.passive.EntityPenguin;
import net.arcticraft.entities.render.RenderBoar;
import net.arcticraft.entities.render.RenderCannonball;
import net.arcticraft.entities.render.RenderCaveman;
import net.arcticraft.entities.render.RenderIceMage;
import net.arcticraft.entities.render.RenderPenguin;
import net.arcticraft.entities.render.RenderSled;
import net.arcticraft.gui.GuiFrozenScreen;
import net.arcticraft.gui.GuiTemperatureBar;
import net.arcticraft.item.ACItems;
import net.arcticraft.item.render.ItemCampfireRender;
import net.arcticraft.item.render.ItemCannonRender;
import net.arcticraft.item.render.ItemCannonballRender;
import net.arcticraft.item.render.ItemCavemanRender;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.arcticraft.tileentity.TileEntityCannon;
import net.arcticraft.tileentity.TileEntityCaveman;
import net.arcticraft.tileentity.renderers.TileEntityCampfireRender;
import net.arcticraft.tileentity.renderers.TileEntityCannonRender;
import net.arcticraft.tileentity.renderers.TileEntityCavemanRender;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenderThings()
	{
		MinecraftForge.EVENT_BUS.register(new GuiTemperatureBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiFrozenScreen(Minecraft.getMinecraft()));

		RenderingRegistry.registerEntityRenderingHandler(EntitySled.class, new RenderSled());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(new ModelBoar(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new RenderPenguin(new ModelPenguin(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderIceMage(new ModelIceMage(), 0.6F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveman.class, new RenderCaveman(new ModelCaveman(), 0.7F));	
		RenderingRegistry.registerEntityRenderingHandler(EntityCannonball.class, new RenderCannonball(ACItems.cannonball));

		TileEntitySpecialRenderer render = new TileEntityCampfireRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new TileEntityCampfireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.campfire), new ItemCampfireRender(render));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, new TileEntityCannonRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.cannon), new ItemCannonRender());
	
		MinecraftForgeClient.registerItemRenderer(ACItems.cannonball, (IItemRenderer) new ItemCannonballRender());
		
		render = new TileEntityCavemanRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaveman.class, new TileEntityCavemanRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.caveman), new ItemCavemanRender(render));
		
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
