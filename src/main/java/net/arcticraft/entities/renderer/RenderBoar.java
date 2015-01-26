package net.arcticraft.entities.renderer;

import net.arcticraft.entities.passive.EntityBoar;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderBoar extends RenderLiving{

	private static final ResourceLocation boarTexture = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/boar/boar.png");

	public RenderBoar(ModelBase model, float shadowSize){
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return boarTexture;
	}

}
