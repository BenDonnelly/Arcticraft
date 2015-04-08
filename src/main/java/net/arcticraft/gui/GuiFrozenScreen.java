package net.arcticraft.gui;

import net.arcticraft.helpers.IExtendedPlayerProps;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.temperature.TemperatureHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiFrozenScreen extends Gui {
	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation(
			Arcticraft.MOD_ID, "textures/gui/freezing.png");

	public GuiFrozenScreen(Minecraft mc) {
		super();
		this.mc = mc;
	}

	public static void drawTexturedRect(ResourceLocation texture, double x, double y, int u, int v, int width, int height, int imageWidth, int imageHeight, double scale) {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
        
        double minU = (double)u / (double)imageWidth;
        double maxU = (double)(u + width) / (double)imageWidth;
        double minV = (double)v / (double)imageHeight;
        double maxV = (double)(v + height) / (double)imageHeight;
        
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + scale*(double)width, y + scale*(double)height, 0, maxU, maxV);
        tessellator.addVertexWithUV(x + scale*(double)width, y, 0, maxU, minV);
        tessellator.addVertexWithUV(x, y, 0, minU, minV);
        tessellator.addVertexWithUV(x, y + scale*(double)height, 0, minU, maxV);
        tessellator.draw();
    }
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onRender(RenderGameOverlayEvent event) {
		if(this.mc.thePlayer.dimension == 3)
		{
			if (event.isCancelable() || event.type != ElementType.ALL) {
				return;
			}

			int xPos = 0;
	        int yPos = 0;

			GL11.glPushMatrix();
			{
				/*float difficultyValue = 0.20F;
				
				switch(this.mc.thePlayer.worldObj.difficultySetting.getDifficultyId())
				{
				case 0:
					difficultyValue = 0.25F;
					break;
				case 1:
					difficultyValue = 0.20F;
					break;
				case 2:
					difficultyValue = 0.15F;
					break;
				case 3:
					difficultyValue = 0.10F;
					break;
				}*/
				
				float temp = TemperatureHandler.getTemperature(this.mc.thePlayer);
				float alpha = (1.0F / temp);
				//float alpha = ((1.0F * difficultyValue) / temp);
				
				GL11.glColor4f(1.0F, 1.0F, 1.0F, alpha);
				GL11.glDisable(GL11.GL_LIGHTING);
				drawTexturedRect(texturepath, xPos, yPos, 0, 0, mc.displayWidth, mc.displayHeight, mc.displayWidth, mc.displayHeight, 0.5F);
			}
			GL11.glPopMatrix();
		}
	}
}