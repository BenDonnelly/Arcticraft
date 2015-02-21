package net.arcticraft.contentPacks;

import java.io.File;
import java.io.IOException;
import java.util.List;

import net.minecraft.client.Minecraft;
import scala.Console;

import com.arcanumLudum.ALCore.ALCore;
import com.arcanumLudum.ALCore.Reader;
import com.arcanumLudum.ALCore.lua.LuaManager;
import com.arcanumLudum.ALCore.modules.loader.ListFiles;
import com.arcanumLudum.ALCore.modules.loader.MainLoader;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.RenderTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;

public class CPackMain {
	public static final String inEclipse = System.getenv("inEclipse");
	private MainLoader mLoader;
	private ListFiles lLoader;	
	
	public void preInit()
	{
		File dir;

		if ((inEclipse == null) || (!inEclipse.equals("true"))) {
			try {
				dir = new File(
						Minecraft.getMinecraft().mcDataDir.getCanonicalPath()
								+ "/ac_cpacks/");

				if (!dir.exists()) {
					Console.out()
							.println(
									"[Arcticraft] No 'AC_CPacks' folder found, created one!");
					dir.mkdir();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			mLoader = new MainLoader();
			try {
				mLoader.loadModules(Minecraft.getMinecraft(), "ac_cpacks", "ac_cpacks", "ac", "Arcticraft");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			}
		} else {
			String path = "";

			try {
				path = Minecraft.getMinecraft().mcDataDir.getCanonicalPath()
						.replaceFirst("eclipse", "bin");

				dir = new File(path + "/ac_cpacks/");

				if (!dir.exists()) {
					Console.out()
							.println(
									"[Arcticraft] No 'AC_CPacks' folder found, created one!");

					dir.mkdir();
				} else {
					Console.out().println(
							"[Arcticraft] Searching 'AC_CPacks' for content pack!");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			lLoader = new ListFiles();
			lLoader.listf(path + "/ac_cpacks/", "ac_cpacks", "ac", "Arcticraft");
		}
	}
	
	public void init()
	{
		if ((inEclipse == null) || (!inEclipse.equals("true"))) {
			Console.out().println(
					"[Arcticraft] Loaded " + mLoader.moduleCount + " content pack(s)!");
		} else {
			Console.out().println(
					"[Arcticraft] Loaded " + lLoader.moduleCount + " content pack(s)!");
		}
	}
	
	@SubscribeEvent
	public void tickWorld(WorldTickEvent event) {
		if ((inEclipse == null) || (!inEclipse.equals("true"))) {
			mLoader.update(event);
		} else {
			lLoader.update(event);
		}
	}

	@SubscribeEvent
	public void tickPlayer(PlayerTickEvent event) {
		if(ALCore.instance.mc.isSingleplayer())
		{
			if(event.player.getUniqueID() == ALCore.instance.mc.thePlayer.getUniqueID())
			{
				if ((inEclipse == null) || (!inEclipse.equals("true"))) {
					mLoader.updatePlayer(event);
				} else {
					lLoader.updatePlayer(event);
				}
			}
		}
		else
		{
			if ((inEclipse == null) || (!inEclipse.equals("true"))) {
				mLoader.updatePlayer(event);
			} else {
				lLoader.updatePlayer(event);
			}
		}
	}

	@SubscribeEvent
	public void tickRender(RenderTickEvent event) {
		if ((inEclipse == null) || (!inEclipse.equals("true"))) {
			mLoader.render(event);
		} else {
			lLoader.render(event);
		}
	}
}
