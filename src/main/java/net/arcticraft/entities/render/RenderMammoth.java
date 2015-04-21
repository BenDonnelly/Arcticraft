package net.arcticraft.entities.render;

import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderMammoth extends RenderLiving{

	private static final ResourceLocation mammothTexture = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/mammoth/mammoth.png");

	public RenderMammoth(ModelBase model, float shadowSize){
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return mammothTexture;
	}

}
