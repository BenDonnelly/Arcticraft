package net.arcticraft.entities.render;

import net.arcticraft.entities.passive.EntityArcticGhost;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class RenderArcticGhost extends RenderLiving{

	private static final ResourceLocation ghost = new ResourceLocation(Arcticraft.MOD_ID, "textures/entities/mobs/arctic_ghost/arctic_ghost.png");

	public RenderArcticGhost(ModelBase model, float shadowSize){
		super(model, shadowSize);
	}

	public void renderGhost(EntityArcticGhost ghost, double par2, double par4, double par6, float par8, float par9)
	{
		super.doRender(ghost, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(EntityLiving living, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderGhost((EntityArcticGhost) living, par2, par4, par6, par8, par9);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic (Render<T extends
	 * Entity) and this method has signature public void doRender(T entity, double d, double d1, double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	@Override
	public void doRender(Entity entity, double par2, double par4, double par6, float par8, float par9)
	{
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		this.renderGhost((EntityArcticGhost) entity, par2, par4, par6, par8, par9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return ghost;
	}
}
