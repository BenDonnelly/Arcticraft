package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.contentPacks.CPackMain;
import net.arcticraft.crafting.ACRecipes;
import net.arcticraft.entities.ACEntities;
import net.arcticraft.gui.GuiACMainMenu;
import net.arcticraft.gui.GuiHandler;
import net.arcticraft.helpers.CommandChangeTemperature;
import net.arcticraft.helpers.ForgeEvents;
import net.arcticraft.helpers.TickEvent;
import net.arcticraft.item.ACItems;
import net.arcticraft.item.ACPotions;
import net.arcticraft.temperature.TemperatureHandler;
import net.arcticraft.temperature.handlers.LightvalueHandler;
import net.arcticraft.temperature.handlers.LocationHandler;
import net.arcticraft.temperature.handlers.MovementHandler;
import net.arcticraft.util.VectorUtils;
import net.arcticraft.world.gen.WorldGenACTrees;
import net.arcticraft.world.gen.WorldGenIceberg;
import net.arcticraft.world.gen.WorldGenMageTower;
import net.arcticraft.world.gen.dimension.ChunkProviderDim;
import net.arcticraft.world.gen.dimension.TeleporterDim;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.MinecraftForge;

import com.arcanumLudum.ALCore.ALCore;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = Arcticraft.MOD_ID, version = Arcticraft.VERSION, name = Arcticraft.NAME, dependencies = "after:alcore_api")
public class Arcticraft{

	public static final String MOD_ID = "ac";
	public static final String VERSION = "0.1";
	public static final String NAME = "Arcticraft";
	public static final boolean DEV_MODE = true;

	public TemperatureHandler tempHandler = null;
	public LightvalueHandler lightvalueHandler = null;
	public LocationHandler locationHandler = null;
	public MovementHandler movementHandler = null;
	public ChunkProviderDim chunkProvider = null;
	public TeleporterDim tper = null;
	public boolean initialized = false;
	
	protected static CPackMain cPackMain = new CPackMain();
	protected GuiHandler guiHandler = new GuiHandler();
	public static SimpleNetworkWrapper network;
	public static WeightedRandomChestContent[] acChestContent;
    public static ACChestGenHooks acChestGenHooks;
	
	@SidedProxy(clientSide = "net.arcticraft.main.ClientProxy", serverSide = "net.arcticraft.main.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance(MOD_ID)
	public static Arcticraft arcticraftInstance;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent PreEvent)
	{
		network = NetworkRegistry.INSTANCE.newSimpleChannel(MOD_ID);
		network.registerMessage(RopePositionPacketHandler.class, RopePositionPacket.class, 0, Side.SERVER);
		network.registerMessage(EskimoTradePacketHandler.class, EskimoTradePacket.class, 1, Side.SERVER);
		
		VectorUtils.init();
		ACBlocks.loadBlocks();
		ACItems.loadItems();
		ACPotions.loadPotions();
		ACRecipes.loadRecipes();
		
		cPackMain.preInit();
		
    	ALCore.instance.menuHandler.addMenu(1, "Arcticraft", new ResourceLocation("ac:textures/items/tools/misc/captain_sword.png"), new GuiACMainMenu());
    	ALCore.instance.menuHandler.getMenuBox(1).addSoundToList("ac", "records.frozen_feelings");
    	ALCore.instance.menuHandler.getMenuBox(1).addSoundToList("ac", "records.welcome_to_the_cold");
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new TickEvent());
		FMLCommonHandler.instance().bus().register(cPackMain);
		MinecraftForge.EVENT_BUS.register(new ForgeEvents());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, guiHandler);
		proxy.registerRenderThings();
		proxy.registerGeneral();
		
		ACEntities.loadEntities();
    	GameRegistry.registerWorldGenerator(new WorldGenACTrees(), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenIceberg(), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenMageTower(), 0);
    	
    	acChestContent = new WeightedRandomChestContent[] {new WeightedRandomChestContent(ACItems.hotWaterBottle, 0, 0, 1, 40), new WeightedRandomChestContent(ACItems.eriumGem, 0, 0, 1, 20), new WeightedRandomChestContent(ACItems.escariaSword, 0, 0, 1, 1), new WeightedRandomChestContent(ACItems.arcticPouch, 0, 0, 3, 10)};
    	acChestGenHooks = new ACChestGenHooks("acChestGen");
    	cPackMain.init();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		  MinecraftServer server = MinecraftServer.getServer();
		  ICommandManager command = server.getCommandManager();
		  ServerCommandManager manager = (ServerCommandManager) command;
		  manager.registerCommand(new CommandChangeTemperature());
	}
	
	public static void notifyOfGenertion(Object type, String x, String z)
	{
		if(DEV_MODE)
		{
			if(Minecraft.getMinecraft().thePlayer != null)
			{
				Minecraft.getMinecraft().thePlayer.sendChatMessage(type + " has been generated at, X= " + x + ", " + "Z= " + z);
			}
		}
	}
}
