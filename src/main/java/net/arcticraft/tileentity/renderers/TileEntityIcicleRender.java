package net.arcticraft.tileentity.renderers;

import net.arcticraft.block.BlockIcicle;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityIcicle;
import net.arcticraft.tileentity.models.ModelBlockIcicle;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class TileEntityIcicleRender extends TileEntitySpecialRenderer{

	private ModelBlockIcicle model;
	
	public TileEntityIcicleRender(){
		model = new ModelBlockIcicle();
	}

	public void renderAModelAt(TileEntityIcicle tileEntity, double x, double y, double z, float f)
	{
		TileEntityIcicle icicle = (TileEntityIcicle) tileEntity;
		icicle = (TileEntityIcicle) tileEntity.getWorldObj().getTileEntity(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);

		int meta = 0;
		if(tileEntity.getWorldObj() != null)
		{
			meta = tileEntity.getBlockMetadata();
			icicle.rotation = meta;
		}
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "textures/blocks/modeled_blocks/icicle.png"));
		GL11.glPushMatrix();
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glScalef(1.0F, -1F, -1F);
		GL11.glRotatef(icicle.rotation * 90, 0.0F, 1.0F, 0.0F);
		if(icicle.type == 0 || icicle.type == 3)
		{
			// large
			GL11.glScalef(2.0F, 1.0F, 1F);
		}
		else if(icicle.type == 1 || icicle.type == 4)
		{
			// regular
			GL11.glScalef(1.5F, 1F, 1F);
		}
		else if(icicle.type == 2 || icicle.type == 5)
		{
			// small
			GL11.glScalef(1.0F, 1F, 1F);
		}
		if(icicle.upsideDown){
			GL11.glRotatef(180, 1, 0, 0);
			GL11.glTranslatef(0, (float) -1.5F, 0);
		}
		model.renderAll();
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float par8)
	{
		this.renderAModelAt((TileEntityIcicle) tileEntity, x, y, z, par8);
	}

}
