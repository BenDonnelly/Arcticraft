package net.arcticraft.gui;

import net.arcticraft.helpers.IExtendedPlayerProps;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiTemperatureBar extends Gui{

	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation(Arcticraft.MOD_ID, "textures/gui/temperature_bar.png");

	public GuiTemperatureBar(Minecraft mc){
		super();
		this.mc = mc;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{
			return;
		}

		IExtendedPlayerProps props = IExtendedPlayerProps.get(this.mc.thePlayer);

		int xPos = 4;
		int yPos = 4;

		GL11.glPushMatrix();
		{
			GL11.glScalef(1.5F, 1.5F, 1.5F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.mc.getTextureManager().bindTexture(texturepath);
			this.drawTexturedModalRect(xPos, yPos, 0, 6, 80, 6);
			this.drawTexturedModalRect(xPos, yPos, 0, 0, props.getCurrentTemp() * 80 / props.getMaxTemp(), 6);
		}
		GL11.glPopMatrix();
	}
}
