package net.arcticraft.item.render;

import org.lwjgl.opengl.GL11;

import net.arcticraft.tileentity.TileEntityCampfire;
import net.arcticraft.tileentity.TileEntityCaptainStatue;
import net.arcticraft.tileentity.models.ModelCaptainStatue;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemCaptainStatueRender implements IItemRenderer{

	private ModelCaptainStatue model;
	private TileEntitySpecialRenderer render;
	
	public ItemCaptainStatueRender(TileEntitySpecialRenderer render){
		model = new ModelCaptainStatue();
		this.render = render;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type) {
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.3F, 0.01F);
		render.renderTileEntityAt(new TileEntityCaptainStatue(), 0.0D, 0.0D, 0.0D, 0.0F);
		GL11.glPopMatrix();
		
	}
}
