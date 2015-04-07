package net.arcticraft.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelChiefEskimo extends ModelBase {
	// fields
	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer body3;
	ModelRenderer head1;
	ModelRenderer head3;
	ModelRenderer head4;
	ModelRenderer leftarm1;
	ModelRenderer leftarm2;
	ModelRenderer rightarm1;
	ModelRenderer rightarm2;
	ModelRenderer leftleg;
	ModelRenderer rightleg;
	ModelRenderer Shape1;

	public ModelChiefEskimo() {
		textureWidth = 70;
		textureHeight = 128;

		body1 = new ModelRenderer(this, 0, 0);
		body1.addBox(-8F, -16F, -8F, 16, 16, 16);
		body1.setRotationPoint(0F, 18F, 0F);
		body1.setTextureSize(70, 128);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
		body2 = new ModelRenderer(this, 0, 32);
		body2.addBox(-8.5F, 0F, -8.5F, 17, 2, 17);
		body2.setRotationPoint(0F, 18F, 0F);
		body2.setTextureSize(70, 128);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		body3 = new ModelRenderer(this, 0, 32);
		body3.addBox(-1F, -10F, -8.5F, 2, 10, 2);
		body3.setRotationPoint(0F, 18F, 0F);
		body3.setTextureSize(70, 128);
		body3.mirror = true;
		setRotation(body3, 0F, 0F, 0F);
		head1 = new ModelRenderer(this, 0, 51);
		head1.addBox(-4F, -4F, -8F, 8, 8, 8);
		head1.setRotationPoint(0F, 7F, -4F);
		head1.setTextureSize(70, 128);
		head1.mirror = true;
		setRotation(head1, 0F, 0F, 0F);
		head3 = new ModelRenderer(this, 32, 51);
		head3.addBox(-4.5F, -4.5F, -9F, 9, 9, 2);
		head3.setRotationPoint(0F, 7F, -4F);
		head3.setTextureSize(70, 128);
		head3.mirror = true;
		setRotation(head3, 0F, 0F, 0F);
		head4 = new ModelRenderer(this, 0, 67);
		head4.addBox(-1F, 1F, -10F, 2, 4, 2);
		head4.setRotationPoint(0F, 7F, -4F);
		head4.setTextureSize(70, 128);
		head4.mirror = true;
		setRotation(head4, 0F, 0F, 0F);
		leftarm1 = new ModelRenderer(this, 0, 73);
		leftarm1.addBox(0F, -2F, -2F, 4, 8, 4);
		leftarm1.setRotationPoint(6.5F, 9F, 0F);
		leftarm1.setTextureSize(70, 128);
		leftarm1.mirror = true;
		setRotation(leftarm1, -0.7853982F, 0F, -0.0872665F);
		leftarm2 = new ModelRenderer(this, 0, 85);
		leftarm2.addBox(-0.5F, 3F, -2.5F, 5, 2, 5);
		leftarm2.setRotationPoint(6.5F, 9F, 0F);
		leftarm2.setTextureSize(70, 128);
		leftarm2.mirror = true;
		setRotation(leftarm2, -0.7853982F, 0F, -0.0872665F);
		rightarm1 = new ModelRenderer(this, 0, 73);
		rightarm1.addBox(-4F, -2F, -2F, 4, 8, 4);
		rightarm1.setRotationPoint(-6.5F, 9F, 0F);
		rightarm1.setTextureSize(70, 128);
		rightarm1.mirror = true;
		setRotation(rightarm1, 0F, 0F, 0.0872665F);
		rightarm2 = new ModelRenderer(this, 0, 85);
		rightarm2.addBox(-4.5F, 3F, -2.5F, 5, 2, 5);
		rightarm2.setRotationPoint(-6.5F, 9F, 0F);
		rightarm2.setTextureSize(70, 128);
		rightarm2.mirror = true;
		setRotation(rightarm2, 0F, 0F, 0.0872665F);
		leftleg = new ModelRenderer(this, 0, 92);
		leftleg.addBox(-2.5F, 0F, -2.5F, 5, 4, 5);
		leftleg.setRotationPoint(3.5F, 20F, 0F);
		leftleg.setTextureSize(70, 128);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 92);
		rightleg.addBox(-2.5F, 0F, -2.5F, 5, 4, 5);
		rightleg.setRotationPoint(-3.5F, 20F, 0F);
		rightleg.setTextureSize(70, 128);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 13, 1);
		Shape1.setRotationPoint(9F, 11F, -6F);
		Shape1.setTextureSize(70, 128);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		body1.render(f5);
		body2.render(f5);
		body3.render(f5);
		head1.render(f5);
		head3.render(f5);
		head4.render(f5);
		leftarm1.render(f5);
		leftarm2.render(f5);
		rightarm1.render(f5);
		rightarm2.render(f5);
		leftleg.render(f5);
		rightleg.render(f5);
		Shape1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity par3Entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par3Entity);
	}

}