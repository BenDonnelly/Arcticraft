package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.crafting.ACCraftingRecipes;
import net.arcticraft.helpers.CommandChangeTemperature;
import net.arcticraft.helpers.ForgeEvents;
import net.arcticraft.helpers.TickPlayerEvent;
import net.arcticraft.item.ACItems;
import net.arcticraft.util.VectorUtils;
import net.arcticraft.world.gen.WorldGenACTrees;
import net.arcticraft.world.gen.WorldGenIceberg;
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
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Arcticraft.MOD_ID, version = Arcticraft.VERSION, name = Arcticraft.NAME)
public class Arcticraft{

	public static final String MOD_ID = "ac";
	public static final String VERSION = "0.1";
	public static final String NAME = "Arcticraft";
	
	public static final boolean DEV_MODE = true;
	
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

		proxy.registerRenderThings();
		proxy.registerGeneral();
		MinecraftForge.EVENT_BUS.register(new ForgeEvents());

		GameRegistry.registerWorldGenerator(new WorldGenACTrees(), 0);
		GameRegistry.registerWorldGenerator(new WorldGenIceberg(), 0);
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		  MinecraftServer server = MinecraftServer.getServer();
		  ICommandManager command = server.getCommandManager();
		  ServerCommandManager manager = (ServerCommandManager) command;
		  manager.registerCommand(new CommandChangeTemperature());
	}

}
