package net.arcticraft.main;

import net.arcticraft.block.ACBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Arcticraft.MOD_ID, version = Arcticraft.VERSION, name = Arcticraft.NAME)
public class Arcticraft {

	public static final String MOD_ID = "ac";
	public static final String VERSION = "0.1";
	public static final String NAME = "Arcticraft";
	
	@SidedProxy(clientSide = "net.arcticraft.main.ClientProxy", serverSide = "net.arcticraft.main.CommonProxy")
	public static CommonProxy proxy;

	@Mod.Instance(Arcticraft.MOD_ID)
	public static Arcticraft arcticraftInstance;
	
	
	@EventHandler
	public static void PreLoad(FMLPreInitializationEvent PreEvent) {
		ACBlocks.loadBlocks();
		
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.registerRenderThings();
	}
}
