package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.*;
import net.arcticraft.entities.model.*;
import net.arcticraft.entities.passive.*;
import net.arcticraft.entities.hostile.*;
import net.arcticraft.entities.render.*;
import net.arcticraft.gui.*;
import net.arcticraft.item.ACItems;
import net.arcticraft.item.render.*;
import net.arcticraft.tileentity.*;
import net.arcticraft.tileentity.renderers.*;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelZombie;
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
		MinecraftForge.EVENT_BUS.register(new GuiBossBar(Minecraft.getMinecraft()));

		RenderingRegistry.registerEntityRenderingHandler(EntitySled.class, new RenderSled());
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, new RenderBoar(new ModelBoar(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPenguin.class, new RenderPenguin(new ModelPenguin(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceMage.class, new RenderIceMage(new ModelIceMage(), 0.6F));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaveman.class, new RenderCaveman(new ModelCaveman(), 0.6F));	
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostZombie.class, new RenderFrostZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntityCannonball.class, new RenderCannonball(ACItems.cannonball));
		RenderingRegistry.registerEntityRenderingHandler(EntityCaptain.class, new RenderCaptain());
		RenderingRegistry.registerEntityRenderingHandler(EntityCaptainHook.class, new RenderCaptainHook());


		MinecraftForgeClient.registerItemRenderer(ACItems.captainsHook, (IItemRenderer) new ItemCaptainsHookRender());

		TileEntitySpecialRenderer render = new TileEntityCampfireRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new TileEntityCampfireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.campfire), new ItemCampfireRender(render));
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, new TileEntityCannonRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.cannon), new ItemCannonRender());
	
		MinecraftForgeClient.registerItemRenderer(ACItems.cannonball, (IItemRenderer) new ItemCannonballRender());
		
		render = new TileEntityCavemanRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaveman.class, new TileEntityCavemanRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.caveman), new ItemCavemanRender(render));
		
		render = new TileEntityIcicleRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIcicle.class, new TileEntityIcicleRender());
		
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
