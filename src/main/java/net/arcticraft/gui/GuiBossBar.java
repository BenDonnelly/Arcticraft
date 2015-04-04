package net.arcticraft.gui;

import net.arcticraft.entities.ACBossStatus;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.google.common.base.Strings;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiBossBar{

	private Minecraft mc;

	private static final ResourceLocation texturepath = new ResourceLocation(Arcticraft.MOD_ID, "textures/gui/boss_bars.png");

	public GuiBossBar(Minecraft mc){
		super();
		this.mc = mc;
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onRender(RenderGameOverlayEvent event)
	{
		GuiIngame gui = mc.ingameGUI;

		if(event.isCancelable() || event.type != ElementType.ALL)
		{
			return;
		}
		if(ACBossStatus.bossName != null && ACBossStatus.statusBarLength > 0)
		{
			--ACBossStatus.statusBarLength;
			FontRenderer fontrenderer = mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			short short1 = 182;
			short short2 = 50;
			int j = i / 2 - short1 / 2;
			int l = i / 2 - short2 / 2;
			int k = (int) (ACBossStatus.healthScale * (float) (short1 + 1));
			byte b0 = 12;
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(texturepath);
			gui.drawTexturedModalRect(j, b0, 0, 0, short1, 14);
			if(k > 0)
			{
				gui.drawTexturedModalRect(j, b0, 0, 14, k, 14);
			}
			String s = ACBossStatus.bossName;
			fontrenderer.drawStringWithShadow(s, i / 2 - fontrenderer.getStringWidth(s) / 2, b0 - 10, 16777215);
			if(ACBossStatus.isMiniBoss == true)
			{
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Mini Boss", l, 12 + 15, 0xffffffff);
			}
			else
			{
				fontrenderer.drawStringWithShadow(EnumChatFormatting.ITALIC + "Final Boss", l, 12 + 15, 0xffffffff);
			}
		}
	}

}
