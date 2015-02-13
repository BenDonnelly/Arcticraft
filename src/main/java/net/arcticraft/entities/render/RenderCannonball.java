package net.arcticraft.entities.render;

import net.arcticraft.entities.EntityCannonball;
import net.arcticraft.entities.model.ModelCannonball;
import net.arcticraft.main.Arcticraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;

public class RenderCannonball extends Render{

	private static final ResourceLocation cannonballTexture = new ResourceLocation(Arcticraft.MOD_ID + ":textures/entities/item/cannonball.png");
	private ModelCannonball cannonballModel;

	public RenderCannonball(Item item){
		cannonballModel = new ModelCannonball();

	}

	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.renderEntityModel((EntityCannonball) par1Entity, par2, par4, par6, par8, par9);
	}

	public void renderEntityModel(Entity bomb, double x, double y, double z, float yaw, float partialTick)
	{
		GL11.glPushMatrix();
		float scale = bomb.ticksExisted % 13 > 10 ? 1.65F : 1.25F;
		bindTexture(getEntityTexture(bomb));
		GL11.glTranslated(x, y, z);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glRotatef(150, 1F, 1F, 300F);
		GL11.glScalef(scale, scale, scale);
		GL11.glTranslatef(0.0F, -1.0F, 0.0F);
		cannonballModel.render(bomb, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0475F);
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return cannonballTexture;
	}

}
