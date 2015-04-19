package net.arcticraft.item.render;

import net.arcticraft.entities.model.ModelIceChunk;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.tileentity.TileEntityCampfire;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class ItemIceChunkRender implements IItemRenderer{

	private ModelIceChunk iceChunk;

	public ItemIceChunkRender(){
		iceChunk = new ModelIceChunk();
	}

	@Override
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
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "textures/blocks/modeled_blocks/icicle.png"));
		GL11.glRotatef(-32, 3F, 3F, 300F);
		GL11.glRotatef(300, 1F, 1F, 300F);
		float scaleForEquipped = 3.6F;
		if(type == type.EQUIPPED)
		{
			GL11.glScalef(scaleForEquipped, scaleForEquipped, scaleForEquipped);
			GL11.glTranslatef(-0.25F, 0.09F, 0.15F);
		}
		else if(type == type.EQUIPPED_FIRST_PERSON)
		{
			GL11.glTranslatef(-0.454F, 0.900F, -0.1F);
			GL11.glScalef(scaleForEquipped, scaleForEquipped, scaleForEquipped);
		}
		else if(type == type.INVENTORY){
			GL11.glScalef(4.6F, 4.6F, 4.6F);
			GL11.glTranslatef(0.05F, -0.2F, -0.2F);
		}
		else{
			GL11.glScalef(2.0F, 2.0F, 2.0f);
		}
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		iceChunk.renderAll();
		GL11.glPopMatrix(); 

	}

}
