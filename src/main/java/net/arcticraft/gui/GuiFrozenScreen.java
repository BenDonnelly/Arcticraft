package net.arcticraft.gui;

import net.arcticraft.main.Arcticraft;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiFrozenScreen extends Gui {
	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation(Arcticraft.MOD_ID, "textures/gui/freezing.png");

	public GuiFrozenScreen(Minecraft mc) {
		super();
		this.mc = mc;
	}
	
	private void drawOverlay(int imageWidth, int imageHeight, int mcWidth, int mcHeight) {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(0.0D, (double) mcHeight, (double)this.zLevel, 0.0D, (double)((float)(imageHeight) * f1));
        tessellator.addVertexWithUV((double) mcWidth, (double) mcHeight, (double)this.zLevel, (double)((float)(imageWidth) * f), (double)((float)(imageHeight) * f1));
        tessellator.addVertexWithUV((double) mcWidth, 0.0D, (double)this.zLevel, (double)((float)(imageWidth) * f), 0.0D);
        tessellator.addVertexWithUV(0.0D, 0.0D, (double)this.zLevel, 0.0D, 0.0D);
        tessellator.draw();
    }
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onRender(RenderGameOverlayEvent event) {
		if(this.mc.thePlayer.dimension == 3)
		{
			if (event.isCancelable() || event.type != ElementType.ALL) {
				return;
			}

			float temp = TemperatureHandler.getTemperature(this.mc.thePlayer);
			float alpha = (1.0F / temp);
			
			ScaledResolution res = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);

			GL11.glPushMatrix();
			GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
			GL11.glDisable(GL11.GL_LIGHTING);
			
			Minecraft.getMinecraft().renderEngine.bindTexture(texturepath);
			this.drawOverlay(256, 256, res.getScaledWidth(), res.getScaledHeight());
			
			GL11.glPopMatrix();
		}
	}
}