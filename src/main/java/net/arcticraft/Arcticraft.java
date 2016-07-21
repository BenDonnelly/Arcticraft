package net.arcticraft;

import net.arcticraft.init.ACBiomes;
import net.arcticraft.init.ACBlocks;
import net.arcticraft.proxy.CommonProxy;
import net.arcticraft.util.References;
import net.arcticraft.world.WorldProviderArctic;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, name = References.NAME)
public class Arcticraft {

	@Instance(value = References.MOD_ID)
	public Arcticraft instance;
	
	@SidedProxy(modId = References.MOD_ID, clientSide = References.CLIENT_PROXY, serverSide = References.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		DimensionManager.registerDimension(References.DIM_ID, WorldProviderArctic.ARCTIC);
		
		ACBlocks.register();
		ACBiomes.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//WorldGenMageTower.register();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}
