package net.arcticraft.entities.render;

import net.arcticraft.main.Arcticraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;


public class RenderIceMage extends RenderLiving{

	 private static final ResourceLocation mageTexture = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/mobs/ice_mage/ice_mage.png");
	
	public RenderIceMage(ModelBase modelBase, float shadowSize){
		super(modelBase, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return mageTexture;
	}

}
