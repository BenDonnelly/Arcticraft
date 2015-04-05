package net.arcticraft.entities.render;

import net.arcticraft.entities.ACBossStatus;
import net.arcticraft.entities.hostile.EntityCaptain;
import net.arcticraft.entities.model.ModelCaptain;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.google.common.base.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCaptain extends RenderBiped{

	private static final ResourceLocation captain = new ResourceLocation(Arcticraft.MOD_ID, "textures/entities/mobs/captain/captain.png");

	public RenderCaptain(){
		super(new ModelCaptain(), 0.5F);
	}

	public void func_82418_a(EntityCaptain captain, double par2, double par4, double par6, float par8, float par9)
	{
		ACBossStatus.setBossStatus(captain, true);
		super.doRender(captain, par2, par4, par6, par8, par9);
	}

	protected int shouldRenderPass(EntityCaptain captain, int par2, float par3)
	{
		return -1;
	}

	protected int inheritRenderPass(EntityCaptain captain, int par2, float par3)
	{
		return -1;
	}

	@Override
	protected int shouldRenderPass(EntityLivingBase living, int i, float f)
	{
		return this.shouldRenderPass((EntityCaptain) living, i, f);
	}

	@Override
	protected int inheritRenderPass(EntityLivingBase living, int i, float f)
	{
		return this.inheritRenderPass((EntityCaptain) living, i, f);
	}

	@Override
	public void doRender(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityCaptain) par1EntityLiving, par2, par4, par6, par8, par9);
		this.setLeftItem(par1EntityLiving, ((EntityCaptain) par1EntityLiving).getHookItem());
		this.field_82423_g.heldItemLeft = this.field_82425_h.heldItemLeft = this.modelBipedMain.heldItemLeft = 0;
	}

	protected void setLeftItem(EntityLiving par1EntityLiving, ItemStack par2ItemStack)
	{
		this.field_82423_g.heldItemLeft = this.field_82425_h.heldItemLeft = this.modelBipedMain.heldItemLeft = par2ItemStack != null ? 1 : 0;
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase par1EntityLivingBase, float par2)
	{
		super.renderEquippedItems(par1EntityLivingBase, par2);

		if(!((EntityCaptain) par1EntityLivingBase).isHookAirBorne())
		{
			this.renderHook((EntityCaptain) par1EntityLivingBase, par2);
		}

	}

	protected void renderHook(EntityCaptain captain, float par2)
	{
		float f1 = 1.0F;
		GL11.glColor3f(f1, f1, f1);
		Item item;
		ItemStack itemstack = captain.getHookItem();
		float f2;
		if(itemstack != null)
		{
			GL11.glPushMatrix();
			item = itemstack.getItem();
			if(this.mainModel.isChild)
			{
				f2 = 0.5F;
				GL11.glTranslatef(0.0F, 0.625F, 0.0F);
				GL11.glRotatef(-20.0F, -1.0F, 0.0F, 0.0F);
				GL11.glScalef(f2, f2, f2);
			}
			this.modelBipedMain.bipedLeftArm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			if(item.isFull3D())
			{
				f2 = 0.625F;
				if(item.shouldRotateAroundWhenRendering())
				{
					GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
					GL11.glTranslatef(0.0F, -0.125F, 0.0F);
				}
				this.func_82422_c();
				GL11.glScalef(f2, -f2, f2);
				GL11.glRotatef(-100.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(45.0F, 0.0F, 1.0F, 0.0F);
			}
			else
			{
				f2 = 0.375F;
				GL11.glTranslatef(0.25F, 0.1875F, -0.1875F);
				GL11.glScalef(f2, f2, f2);
				GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
				GL11.glRotatef(20.0F, 0.0F, 0.0F, 1.0F);
			}
			this.renderManager.itemRenderer.renderItem(captain, itemstack, 0);
			if(itemstack.getItem().requiresMultipleRenderPasses())
			{
				for(int x = 1; x < itemstack.getItem().getRenderPasses(itemstack.getItemDamage()); x++)
				{
					this.renderManager.itemRenderer.renderItem(captain, itemstack, x);
				}
			}
			GL11.glPopMatrix();
		}
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic (Render<T extends
	 * Entity) and this method has signature public void doRender(T entity, double d, double d1, double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.func_82418_a((EntityCaptain) par1Entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return captain;
	}
}
