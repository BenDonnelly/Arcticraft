package net.arcticraft.tileentity.renderers;

import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCaveman;
import net.arcticraft.tileentity.models.ModelBlockCaveman;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityCavemanRender extends TileEntitySpecialRenderer{

	private ModelBlockCaveman model;
	
	public TileEntityCavemanRender()
	{
		model = new ModelBlockCaveman();
	}

	public void renderAModelAt(TileEntityCaveman tileEntity, double x, double y, double z, float f)
	{
		int rotation = 0;
		if(tileEntity.getWorldObj() != null)
		{
			rotation = tileEntity.getBlockMetadata();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "textures/blocks/modeled_blocks/caveman.png"));
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix(); 
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float par8)
	{
		this.renderAModelAt((TileEntityCaveman) tileEntity, x, y, z, par8);
	}

}
