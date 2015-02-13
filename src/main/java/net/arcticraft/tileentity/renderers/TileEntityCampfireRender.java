package net.arcticraft.tileentity.renderers;

import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.arcticraft.tileentity.models.ModelCampfire;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityCampfireRender extends TileEntitySpecialRenderer{

	private ModelCampfire model;

	public TileEntityCampfireRender(){
		model = new ModelCampfire();
	}

	public void renderAModelAt(TileEntityCampfire tile, double d, double d1, double d2, float f)
	{
		int rotation = 0;
		if(tile.getWorldObj() != null)
		{
			rotation = tile.getBlockMetadata();
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "textures/blocks/modeled_blocks/campfire.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d + 0.5F, (float) d1 + 1.5F, (float) d2 + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
		model.renderAll();
		GL11.glPopMatrix(); // end
	}

	public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
	{
		this.renderAModelAt((TileEntityCampfire) par1TileEntity, par2, par4, par6, par8);
	}
}
