package net.arcticraft.item.render;

import net.arcticraft.entities.model.ModelIceChunk;
import net.arcticraft.main.Arcticraft;
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

	public ItemIceChunkRender()
	{
		iceChunk = new ModelIceChunk();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch(type) {
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case INVENTORY:
			return true;
		case ENTITY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{
		if(type == type.EQUIPPED || type == type.EQUIPPED_FIRST_PERSON )
		{
			GL11.glPushMatrix();
			FMLClientHandler.instance().getClient().renderEngine.bindTexture(new ResourceLocation(Arcticraft.MOD_ID, "textures/blocks/modeled_blocks/icicle.png"));
			GL11.glRotatef(-32, 3F, 3F, 300F);
			GL11.glRotatef(300, 1F, 1F, 300F);
			boolean isFirstPerson = false;
			if(data[1] != null && data[1] instanceof EntityPlayer)
			{
				if(!((EntityPlayer) data[1] == Minecraft.getMinecraft().renderViewEntity && Minecraft.getMinecraft().gameSettings.thirdPersonView == 0 && !((Minecraft.getMinecraft().currentScreen instanceof GuiInventory || Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative) && RenderManager.instance.playerViewY == 180.0F)))
				{
					GL11.glScalef(1.6F, 1.6F, 1.6F);
					GL11.glTranslatef(-0.35F, 0.350F, -0.05F);
					GL11.glEnable(GL11.GL_NORMALIZE);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
				}
				else
				{
					isFirstPerson = true;
					GL11.glEnable(GL11.GL_NORMALIZE);
					GL11.glEnable(GL11.GL_BLEND);
					GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
					GL11.glTranslatef(-0.454F, 0.900F, -0.1F);
					float f = 2.0F;
					GL11.glScalef(f, f, f);
				}
			}
			else
			{
				GL11.glTranslatef(-0.35F, -0.500F, -0.0F);
			}
			iceChunk.render((Entity) data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();				
			}
	}

}
