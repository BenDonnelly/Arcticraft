package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.block.renderer.BlockBerryBushRenderer;
import net.arcticraft.block.renderer.BlockIcestoneRenderer;
import net.arcticraft.entities.EntityBomb;
import net.arcticraft.entities.EntityCannonball;
import net.arcticraft.entities.EntityCaptainHook;
import net.arcticraft.entities.EntitySled;
import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.arcticraft.entities.hostile.EntityFrostZombie;
import net.arcticraft.entities.hostile.EntityPirate;
import net.arcticraft.entities.model.ModelArcticGhost;
import net.arcticraft.entities.model.ModelBoar;
import net.arcticraft.entities.model.ModelCaveman;
import net.arcticraft.entities.model.ModelChefEskimo;
import net.arcticraft.entities.model.ModelChiefEskimo;
import net.arcticraft.entities.model.ModelEskimo;
import net.arcticraft.entities.model.ModelHunterEskimo;
import net.arcticraft.entities.model.ModelHusky;
import net.arcticraft.entities.model.ModelIceMage;
import net.arcticraft.entities.model.ModelMammoth;
import net.arcticraft.entities.model.ModelPenguin;
import net.arcticraft.entities.model.ModelPolarBear;
import net.arcticraft.entities.model.ModelTraderEskimo;
import net.arcticraft.entities.passive.EntityArcticGhost;
import net.arcticraft.entities.passive.EntityCaveman;
import net.arcticraft.entities.passive.EntityEskimo;
import net.arcticraft.entities.passive.EntityEskimoChef;
import net.arcticraft.entities.passive.EntityEskimoChief;
import net.arcticraft.entities.passive.EntityEskimoHunter;
import net.arcticraft.entities.passive.EntityEskimoTrader;
import net.arcticraft.entities.passive.EntityHusky;
import net.arcticraft.entities.passive.EntityIceMage;
import net.arcticraft.entities.passive.EntityMammoth;
import net.arcticraft.entities.passive.EntityPenguin;
import net.arcticraft.entities.passive.EntityPolarBear;
import net.arcticraft.entities.render.RenderArcticGhost;
import net.arcticraft.entities.render.RenderBoar;
import net.arcticraft.entities.render.RenderBomb;
import net.arcticraft.entities.render.RenderCannonball;
import net.arcticraft.entities.render.RenderCaptain;
import net.arcticraft.entities.render.RenderCaptainHook;
import net.arcticraft.entities.render.RenderCaveman;
import net.arcticraft.entities.render.RenderEskimo;
import net.arcticraft.entities.render.RenderEskimoChef;
import net.arcticraft.entities.render.RenderEskimoChief;
import net.arcticraft.entities.render.RenderEskimoHunter;
import net.arcticraft.entities.render.RenderEskimoTrader;
import net.arcticraft.entities.render.RenderFrostZombie;
import net.arcticraft.entities.render.RenderHusky;
import net.arcticraft.entities.render.RenderIceMage;
import net.arcticraft.entities.render.RenderMammoth;
import net.arcticraft.entities.render.RenderPenguin;
import net.arcticraft.entities.render.RenderPirate;
import net.arcticraft.entities.render.RenderPolarBear;
import net.arcticraft.entities.render.RenderSled;
import net.arcticraft.gui.GuiBossBar;
import net.arcticraft.gui.GuiFrozenScreen;
import net.arcticraft.gui.GuiTemperatureBar;
import net.arcticraft.item.ACItems;
import net.arcticraft.item.render.ItemCampfireRender;
import net.arcticraft.item.render.ItemCannonRender;
import net.arcticraft.item.render.ItemCannonballRender;
import net.arcticraft.item.render.ItemCaptainStatueRender;
import net.arcticraft.item.render.ItemCaptainsHookRender;
import net.arcticraft.item.render.ItemCavemanRender;
import net.arcticraft.item.render.ItemIceChunkRender;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.arcticraft.tileentity.TileEntityCannon;
import net.arcticraft.tileentity.TileEntityCaptainStatue;
import net.arcticraft.tileentity.TileEntityCaveman;
import net.arcticraft.tileentity.TileEntityIcicle;
import net.arcticraft.tileentity.renderers.TileEntityCampfireRender;
import net.arcticraft.tileentity.renderers.TileEntityCannonRender;
import net.arcticraft.tileentity.renderers.TileEntityCaptainStatueRender;
import net.arcticraft.tileentity.renderers.TileEntityCavemanRender;
import net.arcticraft.tileentity.renderers.TileEntityIcicleRender;
import net.arcticraft.world.gen.dimension.WorldProviderDim;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
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
	public boolean isServerSide()
	{
		return false;
	}

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
		RenderingRegistry.registerEntityRenderingHandler(EntityPirate.class, new RenderPirate(new ModelBiped(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityPolarBear.class, new RenderPolarBear(new ModelPolarBear(), 1.4F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEskimo.class, new RenderEskimo(new ModelEskimo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEskimoHunter.class, new RenderEskimoHunter(new ModelHunterEskimo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEskimoChef.class, new RenderEskimoChef(new ModelChefEskimo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEskimoChief.class, new RenderEskimoChief(new ModelChiefEskimo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityEskimoTrader.class, new RenderEskimoTrader(new ModelTraderEskimo(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityArcticGhost.class, new RenderArcticGhost(new ModelArcticGhost(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHusky.class, new RenderHusky(new ModelHusky(), new ModelHusky(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityBomb.class, new RenderBomb(ACItems.bomb, 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityMammoth.class, new RenderMammoth(new ModelMammoth(), 2.5F));
		RenderingRegistry.registerBlockHandler(new BlockIcestoneRenderer()); // Or 'this' if your proxy happens to be the one that implements the block render interface.
		RenderingRegistry.registerBlockHandler(new BlockBerryBushRenderer()); // Or 'this' if your proxy happens to be the one that implements the block render interface.

		MinecraftForgeClient.registerItemRenderer(ACItems.captainsHook, (IItemRenderer) new ItemCaptainsHookRender());

		TileEntitySpecialRenderer render = new TileEntityCampfireRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCampfire.class, new TileEntityCampfireRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.campfire), new ItemCampfireRender(render));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCannon.class, new TileEntityCannonRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.cannon), new ItemCannonRender());

		MinecraftForgeClient.registerItemRenderer(ACItems.cannonball, (IItemRenderer) new ItemCannonballRender());
		MinecraftForgeClient.registerItemRenderer(ACItems.iceChunk, (IItemRenderer) new ItemIceChunkRender());

		render = new TileEntityCavemanRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaveman.class, new TileEntityCavemanRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.caveman), new ItemCavemanRender(render));

		render = new TileEntityIcicleRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIcicle.class, new TileEntityIcicleRender());

		render = new TileEntityCaptainStatueRender();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCaptainStatue.class, new TileEntityCaptainStatueRender());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ACBlocks.captainStatue), new ItemCaptainStatueRender(render));
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
