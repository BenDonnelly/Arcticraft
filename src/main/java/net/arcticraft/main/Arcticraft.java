package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.util.VectorUtils;
import net.arcticraft.world.gen.WorldGenACTrees;
import net.arcticraft.world.gen.WorldGenIceberg;
import net.arcticraft.world.gen.dimension.TeleporterDim;
import net.minecraft.entity.player.EntityPlayerMP;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Arcticraft.MOD_ID, version = Arcticraft.VERSION, name = Arcticraft.NAME)
public class Arcticraft{

	public static final String MOD_ID = "ac";
	public static final String VERSION = "0.1";
	public static final String NAME = "Arcticraft";

	@SidedProxy(clientSide = "net.arcticraft.main.ClientProxy", serverSide = "net.arcticraft.main.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance(MOD_ID)
	public static Arcticraft arcticraftInstance;

	@EventHandler
	public static void preLoad(FMLPreInitializationEvent PreEvent)
	{
		VectorUtils.init();
		ACBlocks.loadBlocks();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		FMLCommonHandler.instance().bus().register(this);
		
		proxy.registerRenderThings();
		proxy.registerGeneral();
		
    	GameRegistry.registerWorldGenerator(new WorldGenACTrees(), 0);
    	GameRegistry.registerWorldGenerator(new WorldGenIceberg(), 0);
	}
	
	@SubscribeEvent
    public void tickPlayer(PlayerTickEvent event) 
    {
    	if(Keyboard.isKeyDown(Keyboard.KEY_L) && Keyboard.isKeyDown(Keyboard.KEY_K))
    	{
    		if ((event.player.ridingEntity == null) && (event.player.riddenByEntity == null) && ((event.player instanceof EntityPlayerMP)))
    		{
    			EntityPlayerMP thePlayer = (EntityPlayerMP)event.player;
    			if (thePlayer.timeUntilPortal > 0)
    			{
    				thePlayer.timeUntilPortal = 10;
    			}
    			else if (thePlayer.dimension != 3)
    			{
    				thePlayer.timeUntilPortal = 10;
    				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 3, new TeleporterDim(thePlayer.mcServer.worldServerForDimension(3)));
    			}
    			else {
    				thePlayer.timeUntilPortal = 10;
    				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterDim(thePlayer.mcServer.worldServerForDimension(3)));
    			}
    		}
    	}
    }
}
