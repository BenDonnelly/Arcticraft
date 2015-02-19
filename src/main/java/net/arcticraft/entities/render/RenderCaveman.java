package net.arcticraft.entities.render;

import net.arcticraft.entities.model.ModelCaveman;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderCaveman extends RenderLiving{

	public static final ResourceLocation caveman = new ResourceLocation(Arcticraft.MOD_ID, "textures/entities/mobs/caveman/caveman.png");

	public RenderCaveman(ModelBase modelbase, float shadowSize){
		super(modelbase, shadowSize);
	}

	//I took this from renderbiped where it draws items on like bows and other shit apart from ive cut most of the shit we dont need out. Theres still probably more shit in here which we dont need. - ben
	protected void drawItemOnModel(EntityLiving entityLiving, float par2)
	{
		float f1 = 1.0F;
		GL11.glColor3f(f1, f1, f1);
		super.renderEquippedItems(entityLiving, par2);
		ItemStack itemstack = entityLiving.getHeldItem();
		Item item;
		if(itemstack != null)
		{
			GL11.glPushMatrix();
			ModelCaveman.rightarm.postRender(0.0625F);
			item = itemstack.getItem();
			GL11.glTranslatef(-0.1625F, 0.700F, 0.400F);
			net.minecraftforge.client.IItemRenderer customRenderer = net.minecraftforge.client.MinecraftForgeClient.getItemRenderer(itemstack, net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED);
			boolean is3D = (customRenderer != null && customRenderer.shouldUseRenderHelper(net.minecraftforge.client.IItemRenderer.ItemRenderType.EQUIPPED, itemstack, net.minecraftforge.client.IItemRenderer.ItemRendererHelper.BLOCK_3D));
			if(item.isFull3D())
			{
				f1 = 0.625F;
				GL11.glTranslatef(0.1F, -0.157F, -0.4F);
				GL11.glScalef(f1, -f1, f1);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			this.renderManager.itemRenderer.renderItem(entityLiving, itemstack, 0);
			if(itemstack.getItem().requiresMultipleRenderPasses())
			{
				for(int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
				{
					this.renderManager.itemRenderer.renderItem(entityLiving, itemstack, x);
				}
			}
			GL11.glPopMatrix();
		}
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase entityLivingBase, float par2)
	{
		this.drawItemOnModel((EntityLiving) entityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return caveman;
	}

}
