package net.arcticraft.entities.model;

import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * newboar2.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class ModelBoar extends MowzieModelBase{

	public MowzieModelRenderer body1;
	public MowzieModelRenderer body2;
	public MowzieModelRenderer tail;
	public MowzieModelRenderer head;
	public MowzieModelRenderer backlegL1;
	public MowzieModelRenderer backlegR1;
	public MowzieModelRenderer frontlegL;
	public MowzieModelRenderer frontlegR;
	public MowzieModelRenderer fur2;
	public MowzieModelRenderer tailfur1;
	public MowzieModelRenderer tailfur2;
	public MowzieModelRenderer nose;
	public MowzieModelRenderer jaw;
	public MowzieModelRenderer earL;
	public MowzieModelRenderer earR;
	public MowzieModelRenderer fur1;
	public MowzieModelRenderer Neck;
	public MowzieModelRenderer tuskL;
	public MowzieModelRenderer tuskR;
	public MowzieModelRenderer backlegL2;
	public MowzieModelRenderer backlegR2;

	private Animator animator;

	public ModelBoar(){
		this.textureWidth = 64;
		this.textureHeight = 64;
		animator = new Animator(this);
		this.Neck = new MowzieModelRenderer(this, 3, 54);
		this.Neck.setRotationPoint(0.0F, 0.0F, -1.5F);
		this.Neck.addBox(-3.5F, -3.5F, 1.5F, 7, 7, 3, 0.0F);
		this.tail = new MowzieModelRenderer(this, 15, 24);
		this.tail.setRotationPoint(-0.5F, 11.0F, 4.8F);
		this.tail.addBox(-0.5F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
		this.setRotateAngle(tail, 0.4363323129985824F, -0.0F, 0.0F);
		this.fur1 = new MowzieModelRenderer(this, 22, 35);
		this.fur1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.fur1.addBox(-1.5F, -5.1F, -3.8F, 3, 3, 7, 0.0F);
		this.setRotateAngle(fur1, 0.17453292519943295F, -0.0F, 0.0F);
		this.body1 = new MowzieModelRenderer(this, 0, 0);
		this.body1.setRotationPoint(-0.5F, 15.9F, -4.0F);
		this.body1.addBox(-5.0F, -7.0F, -5.0F, 10, 9, 8, 0.0F);
		this.tailfur2 = new MowzieModelRenderer(this, 45, 3);
		this.tailfur2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailfur2.addBox(-1.5F, 5.0F, 0.5F, 3, 3, 0, 0.0F);
		this.nose = new MowzieModelRenderer(this, 0, 43);
		this.nose.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.nose.addBox(-1.5F, -1.3F, -9.5F, 3, 3, 4, 0.0F);
		this.setRotateAngle(nose, 0.06981317007977318F, -0.0F, 0.0F);
		this.jaw = new MowzieModelRenderer(this, 0, 37);
		this.jaw.setRotationPoint(0.5F, 1.8F, -5.0F);
		this.jaw.addBox(-1.5F, 0.0F, -4.0F, 2, 1, 4, 0.0F);
		this.setRotateAngle(jaw, 0.06981317007977318F, 0.0F, 0.0F);
		this.backlegR2 = new MowzieModelRenderer(this, 48, 36);
		this.backlegR2.mirror = true;
		this.backlegR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.backlegR2.addBox(-1.9F, 3.4F, -3.0F, 4, 7, 4, 0.0F);
		this.setRotateAngle(backlegR2, 0.2617993877991494F, -0.0F, 0.0F);
		this.head = new MowzieModelRenderer(this, 0, 51);
		this.head.setRotationPoint(-0.5F, 13.5F, -8.0F);
		this.head.addBox(-3.5F, -3.5F, -6.0F, 7, 7, 6, 0.0F);
		this.setRotateAngle(head, 0.06981317007977318F, 0.0F, 0.0F);
		this.backlegL1 = new MowzieModelRenderer(this, 50, 4);
		this.backlegL1.setRotationPoint(1.7F, 13.5F, 2.9F);
		this.backlegL1.addBox(0.0F, 0.2F, -2.0F, 3, 4, 4, 0.0F);
		this.setRotateAngle(backlegL1, -0.2617993877991494F, -0.0F, 0.0F);
		this.backlegR1 = new MowzieModelRenderer(this, 50, 4);
		this.backlegR1.mirror = true;
		this.backlegR1.setRotationPoint(-3.7F, 13.5F, 2.9F);
		this.backlegR1.addBox(-2.0F, 0.2F, -2.0F, 3, 4, 4, 0.0F);
		this.setRotateAngle(backlegR1, -0.2617993877991494F, -0.0F, 0.0F);
		this.frontlegL = new MowzieModelRenderer(this, 48, 16);
		this.frontlegL.setRotationPoint(1.0F, 15.0F, -5.5F);
		this.frontlegL.addBox(0.0F, 0.0F, -1.5F, 4, 9, 4, 0.0F);
		this.backlegL2 = new MowzieModelRenderer(this, 48, 36);
		this.backlegL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.backlegL2.addBox(-1.1F, 3.4F, -3.0F, 4, 7, 4, 0.0F);
		this.setRotateAngle(backlegL2, 0.2617993877991494F, -0.0F, 0.0F);
		this.earR = new MowzieModelRenderer(this, 0, 24);
		this.earR.mirror = true;
		this.earR.setRotationPoint(-1.2F, -1.5F, -3.0F);
		this.earR.addBox(-3.0F, -4.0F, 0.0F, 3, 4, 1, 0.0F);
		this.setRotateAngle(earR, 0.06981317007977318F, -0.0F, -0.17453292519943295F);
		this.body2 = new MowzieModelRenderer(this, 30, 48);
		this.body2.setRotationPoint(-0.5F, 15.9F, 3.9F);
		this.body2.addBox(-4.5F, -5.8F, -6.0F, 9, 8, 8, 0.0F);
		this.setRotateAngle(body2, -0.091106186954104F, -0.0F, 0.0F);
		this.frontlegR = new MowzieModelRenderer(this, 48, 16);
		this.frontlegR.mirror = true;
		this.frontlegR.setRotationPoint(-3.0F, 15.0F, -5.5F);
		this.frontlegR.addBox(-3.0F, 0.0F, -1.5F, 4, 9, 4, 0.0F);
		this.earL = new MowzieModelRenderer(this, 0, 24);
		this.earL.setRotationPoint(1.2F, -1.5F, -3.0F);
		this.earL.addBox(0.0F, -4.0F, 0.0F, 3, 4, 1, 0.0F);
		this.setRotateAngle(earL, 0.06981317007977318F, -0.0F, 0.17453292519943295F);
		this.tuskR = new MowzieModelRenderer(this, 0, 32);
		this.tuskR.mirror = true;
		this.tuskR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tuskR.addBox(-2.4F, -2.1F, -3.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(tuskR, 0.059341194567807204F, -0.0F, -0.17453292519943295F);
		this.tailfur1 = new MowzieModelRenderer(this, 45, 0);
		this.tailfur1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tailfur1.addBox(0.0F, 5.0F, -1.0F, 0, 3, 3, 0.0F);
		this.tuskL = new MowzieModelRenderer(this, 0, 32);
		this.tuskL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tuskL.addBox(0.4F, -1.7F, -3.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(tuskL, 0.0F, 0.0F, 0.17453292519943295F);
		this.fur2 = new MowzieModelRenderer(this, 27, 22);
		this.fur2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.fur2.addBox(-1.5F, -7.6F, -3.5F, 3, 3, 8, 0.0F);
		this.setRotateAngle(fur2, -0.17453292519943295F, -0.0F, 0.0F);
		this.head.addChild(this.Neck);
		this.head.addChild(this.fur1);
		this.tail.addChild(this.tailfur2);
		this.head.addChild(this.nose);
		this.head.addChild(this.jaw);
		this.backlegR1.addChild(this.backlegR2);
		this.backlegL1.addChild(this.backlegL2);
		this.head.addChild(this.earR);
		this.head.addChild(this.earL);
		this.jaw.addChild(this.tuskR);
		this.tail.addChild(this.tailfur1);
		this.jaw.addChild(this.tuskL);
		this.body1.addChild(this.fur2);

		parts = new MowzieModelRenderer[] {body1, body2, tail, head, backlegL1, backlegR1, frontlegL, frontlegR, fur2, tailfur1, tailfur2, nose, jaw, earL, earR, fur1, Neck, tuskL, tuskR, backlegL2, backlegR2};
		setInitPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		animate(f, f1, f2, f3, f4, f5, entity);

		this.tail.render(f5);
		this.body1.render(f5);
		this.head.render(f5);
		this.backlegL1.render(f5);
		this.backlegR1.render(f5);
		this.frontlegL.render(f5);
		this.body2.render(f5);
		this.frontlegR.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6Entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, par6Entity);
		setToInitPose();
		this.head.rotateAngleX += f5 / (180F / (float) Math.PI);
		this.head.rotateAngleY += f5 / (180F / (float) Math.PI);
		this.backlegL1.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.backlegR1.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.frontlegL.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.frontlegR.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;

	}

	public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		animator.update((IAnimatedEntity) entity);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		animator.setAnim(1);
		animator.startPhase(8);
		animator.rotate(head, 1.0F, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(2);
		animator.startPhase(3);
		animator.rotate(head, -1.0F, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(3);
		animator.resetPhase(4);
	}

}
