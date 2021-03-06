package net.arcticraft.item.render;

import net.arcticraft.tileentity.TileEntityCaveman;
import net.arcticraft.tileentity.models.ModelBlockCaveman;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemCavemanRender implements IItemRenderer{

	private ModelBlockCaveman cavemanModel;
	private TileEntitySpecialRenderer render;

	public ItemCavemanRender(TileEntitySpecialRenderer render)
	{
		this.cavemanModel = new ModelBlockCaveman();
		this.render = render;
	}

	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
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
		render.renderTileEntityAt(new TileEntityCaveman(), 0.0D, 0.0D, 0.0D, 0.0F);
		GL11.glPopMatrix();

	}

}
