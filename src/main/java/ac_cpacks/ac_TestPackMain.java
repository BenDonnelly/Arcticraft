package ac_cpacks;

import net.arcticraft.API.block.BlockBerryBush;
import net.arcticraft.API.block.creativetabs.ACCreativeTabs;

import com.arcanumLudum.ALCore.modules.IModule;
import com.arcanumLudum.ALCore.modules.MainSuper;
import com.arcanumLudum.ALCore.modules.ModuleConfig;
import com.arcanumLudum.ALCore.modules.loader.anno.Module.Module_;

import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ac_TestPackMain extends MainSuper {	
	private IModule module;   	
	private ModuleConfig config;

	@Module_(moduleID = "AC_TestPack", moduleAuthor = "adtdeveloping", moduleVersion = "0.1a", moduleEnabled = true)
	
	@Override
	public void initLoad()
	{
		module = new IModule("AC_TestPack");
		
		config = module.getSuggestedConfigFileForModule();
		
		config.loadConfig();
		config.saveConfig();
	}
	
	@Override
	public void registerObjects() 
	{
		
	}
	
	@Override
	public void playerTick(PlayerTickEvent event) 	
	{
		
	}
	
	@Override
	public void worldTick(WorldTickEvent event) 
	{
		
	}
	
	@Override
	public void renderTick(RenderTickEvent event) 
	{
		
	}
}
