package net.arcticraft.entities.render;

import net.arcticraft.entities.hostile.EntityPirate;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderPirate extends RenderBiped{

	private static final ResourceLocation pirateTexture = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/pirate/pirate.png");

	public RenderPirate(ModelBiped biped, float Shadowsize){
		super(biped, Shadowsize);
	}

	protected ResourceLocation getEntityTexture(EntityPirate pirate)
	{
		return pirateTexture;
	}


	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityPirate) entity);
	}

}
