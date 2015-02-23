package net.arcticraft.entities.render;

import net.arcticraft.entities.model.ModelFrostZombie;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderFrostZombie extends RenderBiped{

	private static final ResourceLocation zobmieTexture = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/frost_zombie/frost_zombie.png");

	public RenderFrostZombie(){
		super(new ModelFrostZombie(), 0.5F, 1.0F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return zobmieTexture;
	}

}
