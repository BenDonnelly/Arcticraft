package net.arcticraft.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

import org.lwjgl.opengl.GL11;

public class GuiCaptainLogButtonNextPage extends GuiButton{

	private final boolean nextPage;

	public GuiCaptainLogButtonNextPage(int par1, int par2, int par3, boolean par4){
		super(par1, par2, par3, 23, 13, "");
		this.nextPage = par4;
	}

	@Override
	public void drawButton(Minecraft minecraft, int par2, int par3)
	{
		if(this.enabled)
		{
			boolean flag = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			minecraft.getTextureManager().bindTexture(GuiCaptainsLog.getTexture());
			int k = 0;
			int l = 192;
			if(flag)
			{
				k += 23;
			}
			if(!this.nextPage)
			{
				l += 13;
			}
			this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
		}
	}

}
