package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.crafting.ACCraftingRecipes;
import net.arcticraft.entities.ACEntities;
import net.arcticraft.helpers.CommandChangeTemperature;
import net.arcticraft.helpers.ForgeEvents;
import net.arcticraft.helpers.TickPlayerEvent;
import net.arcticraft.item.ACItems;
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
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Arcticraft.MOD_ID, version = Arcticraft.VERSION, name = Arcticraft.NAME)
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
	
	@SidedProxy(clientSide = "net.arcticraft.main.ClientProxy", serverSide = "net.arcticraft.main.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance(MOD_ID)
	public static Arcticraft arcticraftInstance;

	@EventHandler
	public static void preLoad(FMLPreInitializationEvent PreEvent)
	{
		VectorUtils.init();
		ACBlocks.loadBlocks();
		ACItems.loadItems();
		ACCraftingRecipes.loadRecipes();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(new TickPlayerEvent());
		MinecraftForge.EVENT_BUS.register(new ForgeEvents());
		
		proxy.registerRenderThings();
		proxy.registerGeneral();
		
		ACEntities.loadEntities();
    	GameRegistry.registerWorldGenerator(new WorldGenACTrees(), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenIceberg(), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenMageTower(), 0);
	}
	
	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		  MinecraftServer server = MinecraftServer.getServer();
		  ICommandManager command = server.getCommandManager();
		  ServerCommandManager manager = (ServerCommandManager) command;
		  manager.registerCommand(new CommandChangeTemperature());
	}
	
	@SubscribeEvent
	public void tickWorld(WorldTickEvent event)
	{
		
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
