package net.arcticraft.entities.renderer;

import net.arcticraft.entities.EntitySled;
import net.arcticraft.entities.model.ModelSled;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSled extends Render {

	private static final ResourceLocation texture = new ResourceLocation(
			Arcticraft.arcticraftInstance.MOD_ID, "textures/entities/sled.png");
	protected ModelSled model;

	public RenderSled() {
		this.model = new ModelSled();
		this.shadowSize = 0.5F;
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z,
			float yaw, float partialTicks) {
		this.renderSled((EntitySled) entity, x, y, z, yaw, partialTicks);
	}

	public void renderSled(EntitySled entity, double x, double y, double z,
			float yaw, float partialTicks) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x, (float) y + 1.5F, (float) z);
		GL11.glRotatef(270.0F - yaw, 0.0F, 1.0F, 0.0F);

		float f4 = 0.75F;
		this.bindEntityTexture(entity);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		this.model.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}