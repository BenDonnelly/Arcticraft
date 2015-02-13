package net.arcticraft.tileentity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCampfire extends ModelBase{

	ModelRenderer Base1;
	ModelRenderer Base2;
	ModelRenderer Base3;
	ModelRenderer Base4;
	ModelRenderer Base5;
	ModelRenderer Base6;
	ModelRenderer Base_7;
	ModelRenderer Base8;
	ModelRenderer Base9;
	ModelRenderer UpperBase1;
	ModelRenderer Stick1;
	ModelRenderer Stick2;
	ModelRenderer Stick3;
	ModelRenderer Stick4;
	ModelRenderer Coal1;
	ModelRenderer Coal2;
	ModelRenderer Coal3;
	ModelRenderer Coal4;

	public ModelCampfire()
	{
		textureWidth = 128;
		textureHeight = 128;
		Base1 = new ModelRenderer(this, 68, 0);
		Base1.addBox(0F, 0F, 1F, 12, 1, 1);
		Base1.setRotationPoint(-6F, 23F, -9F);
		Base1.setTextureSize(128, 128);
		Base1.mirror = true;
		setRotation(Base1, 0F, 0F, 0F);
		Base2 = new ModelRenderer(this, 68, 0);
		Base2.addBox(0F, 0F, 0F, 12, 1, 1);
		Base2.setRotationPoint(-6F, 23F, 7F);
		Base2.setTextureSize(128, 128);
		Base2.mirror = true;
		setRotation(Base2, 0F, 0F, 0F);
		Base3 = new ModelRenderer(this, 68, 0);
		Base3.addBox(0F, 0F, 0F, 12, 1, 1);
		Base3.setRotationPoint(-7F, 23F, -6F);
		Base3.setTextureSize(128, 128);
		Base3.mirror = true;
		setRotation(Base3, 0F, -1.561502F, 0F);
		Base4 = new ModelRenderer(this, 68, 0);
		Base4.addBox(0F, 0F, 0F, 12, 1, 1);
		Base4.setRotationPoint(8F, 23F, -6F);
		Base4.setTextureSize(128, 128);
		Base4.mirror = true;
		setRotation(Base4, 0F, -1.599126F, 0F);
		Base5 = new ModelRenderer(this, 68, 5);
		Base5.addBox(0F, 0F, 0F, 1, 1, 3);
		Base5.setRotationPoint(-8F, 23F, 6F);
		Base5.setTextureSize(128, 128);
		Base5.mirror = true;
		setRotation(Base5, 0F, 0.7524773F, 0F);
		Base6 = new ModelRenderer(this, 42, 42);
		Base6.addBox(0F, 0F, 0F, 14, 1, 14);
		Base6.setRotationPoint(-7F, 23F, -7F);
		Base6.setTextureSize(128, 128);
		Base6.mirror = true;
		setRotation(Base6, 0F, 0F, 0F);
		Base_7 = new ModelRenderer(this, 68, 5);
		Base_7.addBox(0F, 0F, 0F, 1, 1, 3);
		Base_7.setRotationPoint(8F, 23F, -6F);
		Base_7.setTextureSize(128, 128);
		Base_7.mirror = true;
		setRotation(Base_7, 0F, -2.33268F, 0F);
		Base8 = new ModelRenderer(this, 68, 5);
		Base8.addBox(0F, 0F, 0F, 1, 1, 3);
		Base8.setRotationPoint(-6F, 23F, -8F);
		Base8.setTextureSize(128, 128);
		Base8.mirror = true;
		setRotation(Base8, 0F, -0.7524773F, 0F);
		Base9 = new ModelRenderer(this, 68, 5);
		Base9.addBox(0F, 0F, 0F, 1, 1, 3);
		Base9.setRotationPoint(6F, 23F, 8F);
		Base9.setTextureSize(128, 128);
		Base9.mirror = true;
		setRotation(Base9, 0F, 2.407927F, 0F);
		UpperBase1 = new ModelRenderer(this, 15, 65);
		UpperBase1.addBox(0F, 0F, 0F, 10, 1, 10);
		UpperBase1.setRotationPoint(-5F, 22F, -5F);
		UpperBase1.setTextureSize(128, 128);
		UpperBase1.mirror = true;
		setRotation(UpperBase1, 0F, 0F, 0F);
		Stick1 = new ModelRenderer(this, 39, 14);
		Stick1.addBox(-0.5F, 0F, -0.5F, 1, 14, 1);
		Stick1.setRotationPoint(0F, 12F, 0F);
		Stick1.setTextureSize(128, 128);
		Stick1.mirror = true;
		setRotation(Stick1, -0.595684F, -0.8134887F, 0F);
		Stick2 = new ModelRenderer(this, 45, 15);
		Stick2.addBox(-0.5F, 0F, -0.5F, 1, 14, 1);
		Stick2.setRotationPoint(0F, 12F, 0F);
		Stick2.setTextureSize(128, 128);
		Stick2.mirror = true;
		setRotation(Stick2, -0.595684F, 0.7853982F, 0F);
		Stick3 = new ModelRenderer(this, 51, 14);
		Stick3.addBox(-0.5F, 0F, -0.5F, 1, 14, 1);
		Stick3.setRotationPoint(0F, 12F, 0F);
		Stick3.setTextureSize(128, 128);
		Stick3.mirror = true;
		setRotation(Stick3, 0.595684F, 0.8225768F, 0F);
		Stick4 = new ModelRenderer(this, 57, 15);
		Stick4.addBox(-0.5F, 0F, -0.5F, 1, 14, 1);
		Stick4.setRotationPoint(0F, 12F, 0F);
		Stick4.setTextureSize(128, 128);
		Stick4.mirror = true;
		setRotation(Stick4, 0.595684F, -0.7853982F, 0F);
		Coal1 = new ModelRenderer(this, 27, 0);
		Coal1.addBox(0F, 0F, 0F, 2, 1, 2);
		Coal1.setRotationPoint(-1F, 21F, -1F);
		Coal1.setTextureSize(128, 128);
		Coal1.mirror = true;
		setRotation(Coal1, 0F, 0.7807508F, 0F);
		Coal2 = new ModelRenderer(this, 15, 0);
		Coal2.addBox(0F, 0F, 0F, 2, 1, 2);
		Coal2.setRotationPoint(0F, 20F, 0F);
		Coal2.setTextureSize(128, 128);
		Coal2.mirror = true;
		setRotation(Coal2, -0.5576792F, 0.1487144F, 0F);
		Coal3 = new ModelRenderer(this, 0, 8);
		Coal3.addBox(0F, 0F, 0F, 2, 1, 2);
		Coal3.setRotationPoint(-2F, 21F, 0F);
		Coal3.setTextureSize(128, 128);
		Coal3.mirror = true;
		setRotation(Coal3, 0.4833219F, 1.561502F, 0F);
		Coal4 = new ModelRenderer(this, 0, 0);
		Coal4.addBox(0F, 0F, 0F, 2, 1, 2);
		Coal4.setRotationPoint(-2F, 21F, 0F);
		Coal4.setTextureSize(128, 128);
		Coal4.mirror = true;
		setRotation(Coal4, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Base1.render(f5);
		Base2.render(f5);
		Base3.render(f5);
		Base4.render(f5);
		Base5.render(f5);
		Base6.render(f5);
		Base_7.render(f5);
		Base8.render(f5);
		Base9.render(f5);
		UpperBase1.render(f5);
		Stick1.render(f5);
		Stick2.render(f5);
		Stick3.render(f5);
		Stick4.render(f5);
		Coal1.render(f5);
		Coal2.render(f5);
		Coal3.render(f5);
		Coal4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void renderAll()
	{
		Base1.render(0.0625F);
		Base2.render(0.0625F);
		Base3.render(0.0625F);
		Base4.render(0.0625F);
		Base5.render(0.0625F);
		Base6.render(0.0625F);
		Base_7.render(0.0625F);
		Base8.render(0.0625F);
		Base9.render(0.0625F);
		UpperBase1.render(0.0625F);
		Stick1.render(0.0625F);
		Stick2.render(0.0625F);
		Stick3.render(0.0625F);
		Stick4.render(0.0625F);
		Coal1.render(0.0625F);
		Coal2.render(0.0625F);
		Coal3.render(0.0625F);
		Coal4.render(0.0625F);
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
