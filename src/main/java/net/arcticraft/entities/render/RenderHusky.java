package net.arcticraft.entities.render;

import net.arcticraft.entities.passive.EntityHusky;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHusky extends RenderLiving{

	private static final ResourceLocation wolfTextures = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/husky/husky.png");
	private static final ResourceLocation tamedWolfTextures = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/husky/husky_tame.png");
	private static final ResourceLocation anrgyWolfTextures = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/husky/husky_angry.png");
	private static final ResourceLocation wolfCollarTextures = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/husky/husky_collar.png");

	public RenderHusky(ModelBase model, ModelBase modelRenderPass, float shadow){
		super(model, shadow);
		this.setRenderPassModel(modelRenderPass);
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float handleRotationFloat(EntityHusky husky, float derp)
	{
		return husky.getTailRotation();
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	protected int shouldRenderPass(EntityHusky husky, int derp, float herp)
	{
		if(derp == 0 && husky.getWolfShaking())
		{
			float f1 = husky.getBrightness(herp) * husky.getShadingWhileShaking(herp);
			this.bindTexture(wolfTextures);
			GL11.glColor3f(f1, f1, f1);
			return 1;
		}
		else if(derp == 1 && husky.isTamed())
		{
			this.bindTexture(wolfCollarTextures);
			int j = husky.getCollarColor();
			GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
			return 1;
		}
		else
		{
			return -1;
		}
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityHusky husky)
	{
		return husky.isTamed() ? tamedWolfTextures : (husky.isAngry() ? anrgyWolfTextures : wolfTextures);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	@Override
	protected int shouldRenderPass(EntityLivingBase living, int derp, float herp)
	{
		return this.shouldRenderPass((EntityHusky) living, derp, herp);
	}

	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	@Override
	protected float handleRotationFloat(EntityLivingBase yacob, float spacob)
	{
		return this.handleRotationFloat((EntityHusky) yacob, spacob);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityHusky) entity);
	}
}
