package net.arcticraft.entities.render;

import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderEskimoChief extends RenderLiving {

	private static final ResourceLocation textureLocation = new ResourceLocation(Arcticraft.MOD_ID + ":" + "textures/entities/mobs/eskimo/eskimo_chief.png");

	public RenderEskimoChief(ModelBase model, float shadowSize) {
		super(model, shadowSize);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return textureLocation;
	}
}