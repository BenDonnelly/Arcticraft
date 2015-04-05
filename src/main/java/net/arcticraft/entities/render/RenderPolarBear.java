package net.arcticraft.entities.render;

import net.arcticraft.entities.passive.EntityPolarBear;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderPolarBear extends RenderLiving{

	private static final ResourceLocation polarBearTexture = new ResourceLocation(Arcticraft.MOD_ID, "textures/entities/mobs/polar_bear/polar_bear.png");

	public RenderPolarBear(ModelBase model, float shadow)
	{
		super(model, shadow);
	}

	protected void scalePolarBear(EntityPolarBear polarBear, float amount)
	{
		GL11.glScalef(1.7F, 1.7F, 1.7F);
	}

	protected ResourceLocation getEntityTexture(EntityPolarBear polarBear)
	{
		return polarBearTexture;
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args: entityLiving, partialTickTime
	 */
	@Override
	protected void preRenderCallback(EntityLivingBase livingBase, float amount)
	{
		this.scalePolarBear((EntityPolarBear) livingBase, amount);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityPolarBear) entity);
	}

}
