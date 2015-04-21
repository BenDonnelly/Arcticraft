package net.arcticraft.entities.model;

import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;

/**
 * Mammoth.tbl.tcn - TechneToTabulaImporter Created using Tabula 4.1.1
 */
public class ModelMammoth extends MowzieModelBase{

	public MowzieModelRenderer LegBkTopR;
	public MowzieModelRenderer LegBkTopL;
	public MowzieModelRenderer BodyBack;
	public MowzieModelRenderer LegBkBottomR;
	public MowzieModelRenderer LegBkBottomL;
	public MowzieModelRenderer BodyFront;
	public MowzieModelRenderer BodyFur1;
	public MowzieModelRenderer BodyFur2;
	public MowzieModelRenderer BodyFur3;
	public MowzieModelRenderer BodyFur4;
	public MowzieModelRenderer TailAttchedToBody;
	public MowzieModelRenderer Head;
	public MowzieModelRenderer SideFurR;
	public MowzieModelRenderer SideFurL;
	public MowzieModelRenderer LegBackJointL;
	public MowzieModelRenderer LegBackJointR;
	public MowzieModelRenderer LegFrntTopR;
	public MowzieModelRenderer LegFrntTopL;
	public MowzieModelRenderer LegFrntBottomR;
	public MowzieModelRenderer LeftFrntBottomL;
	public MowzieModelRenderer TailAttchedToTail;
	public MowzieModelRenderer EarLeft;
	public MowzieModelRenderer TuskLipRight;
	public MowzieModelRenderer TuskLipLeft;
	public MowzieModelRenderer Tusk1R;
	public MowzieModelRenderer Tusk2R;
	public MowzieModelRenderer Tusk1L;
	public MowzieModelRenderer Tusk2L;
	public MowzieModelRenderer Mouth;
	public MowzieModelRenderer Trunk1;
	public MowzieModelRenderer Trunk2;
	public MowzieModelRenderer Trunk3;
	public MowzieModelRenderer Trunk4;
	public MowzieModelRenderer Trunk5;
	public MowzieModelRenderer EarRight;
	public MowzieModelRenderer HeadFur;

	private Animator animator;
	private MowzieModelRenderer[] trunkParts; 
	private MowzieModelRenderer[] earParts; 
	private MowzieModelRenderer[] tailParts; 

	public ModelMammoth(){
		animator = new Animator(this);
		this.textureWidth = 256;
		this.textureHeight = 256;
        this.BodyFront = new MowzieModelRenderer(this, 0, 61);
        this.BodyFront.setRotationPoint(-0.2F, -13.9F, -25.0F);
        this.BodyFront.addBox(-18.0F, -15.0F, -26.0F, 33, 29, 27, 0.0F);
        this.Trunk5 = new MowzieModelRenderer(this, 0, 0);
        this.Trunk5.setRotationPoint(0.7F, 26.9F, 3.6F);
        this.Trunk5.addBox(-1.7F, 2.2F, -1.5F, 3, 4, 2, 0.0F);
        this.setRotateAngle(Trunk5, 0.5235987755982988F, 0.0F, 0.0F);
        this.Head = new MowzieModelRenderer(this, 47, 122);
        this.Head.setRotationPoint(0.0F, -21.9F, -50.6F);
        this.Head.addBox(-12.0F, -15.0F, -18.5F, 23, 27, 19, 0.0F);
        this.Tusk1L = new MowzieModelRenderer(this, 160, 40);
        this.Tusk1L.setRotationPoint(-11.0F, 15.0F, -16.0F);
        this.Tusk1L.addBox(0.0F, 0.0F, 0.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(Tusk1L, -0.5649630788705644F, 0.10419615634406146F, 0.10524335389525807F);
        this.BodyFur4 = new MowzieModelRenderer(this, 0, 0);
        this.BodyFur4.setRotationPoint(-15.0F, -37.4F, -49.0F);
        this.BodyFur4.addBox(0.0F, 0.0F, 0.0F, 27, 1, 10, 0.0F);
        this.Tusk2L = new MowzieModelRenderer(this, 160, 40);
        this.Tusk2L.setRotationPoint(-12.5F, 23.7F, -20.9F);
        this.Tusk2L.addBox(0.0F, 0.0F, 0.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(Tusk2L, -1.2107349021084663F, 0.10419615634406146F, 0.10524335389525807F);
        this.SideFurR = new MowzieModelRenderer(this, 130, 0);
        this.SideFurR.setRotationPoint(14.4F, -2.0F, -40.0F);
        this.SideFurR.addBox(0.0F, 0.0F, 0.0F, 0, 6, 29, 0.0F);
        this.HeadFur = new MowzieModelRenderer(this, 0, 0);
        this.HeadFur.setRotationPoint(-9.9F, -22.4F, -14.7F);
        this.HeadFur.addBox(0.0F, 3.7F, 0.0F, 19, 6, 14, 0.0F);
        this.setRotateAngle(HeadFur, -0.136659280431156F, -0.0F, 0.0F);
        this.LegFrntTopL = new MowzieModelRenderer(this, 0, 122);
        this.LegFrntTopL.setRotationPoint(-11.5F, 12.0F, -13.3F);
        this.LegFrntTopL.addBox(-5.0F, 0.0F, -10.3F, 10, 20, 11, 0.0F);
        this.BodyBack = new MowzieModelRenderer(this, 0, 0);
        this.BodyBack.setRotationPoint(0.9F, 0.0F, 35.0F);
        this.BodyBack.addBox(-18.0F, -29.0F, -26.0F, 33, 29, 27, 0.0F);
        this.Trunk2 = new MowzieModelRenderer(this, 0, 0);
        this.Trunk2.setRotationPoint(1.0F, 7.4F, 1.2F);
        this.Trunk2.addBox(-5.7F, 0.0F, -4.9F, 11, 9, 7, 0.0F);
        this.setRotateAngle(Trunk2, 0.091106186954104F, 0.013962634015954637F, 0.0F);
        this.Trunk1 = new MowzieModelRenderer(this, 0, 0);
        this.Trunk1.setRotationPoint(-0.9F, 11.7F, -12.5F);
        this.Trunk1.addBox(-5.7F, 0.0F, -4.9F, 13, 8, 9, 0.0F);
        this.setRotateAngle(Trunk1, 0.045553093477052F, 0.0F, 0.0F);
        this.LegFrntBottomR = new MowzieModelRenderer(this, 0, 156);
        this.LegFrntBottomR.setRotationPoint(0.0F, 21.6F, -1.0F);
        this.LegFrntBottomR.addBox(-5.0F, -1.6F, -9.3F, 10, 6, 11, 0.0F);
        this.TuskLipLeft = new MowzieModelRenderer(this, 0, 0);
        this.TuskLipLeft.setRotationPoint(-11.4F, 11.0F, -16.0F);
        this.TuskLipLeft.addBox(0.2F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(TuskLipLeft, -0.16353735091186866F, 0.10419615634406146F, 0.10524335389525807F);
        this.TuskLipRight = new MowzieModelRenderer(this, 0, 0);
        this.TuskLipRight.setRotationPoint(6.8F, 11.6F, -16.0F);
        this.TuskLipRight.addBox(0.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(TuskLipRight, -0.16353735091186866F, -0.10419615634406146F, -0.10524335389525807F);
        this.Mouth = new MowzieModelRenderer(this, 0, 0);
        this.Mouth.setRotationPoint(-5.4F, 12.6F, -8.1F);
        this.Mouth.addBox(0.0F, 0.0F, 0.0F, 11, 1, 7, 0.0F);
        this.setRotateAngle(Mouth, 0.22689280275926282F, -0.0F, 0.0F);
        this.BodyFur3 = new MowzieModelRenderer(this, 0, 0);
        this.BodyFur3.setRotationPoint(-15.9F, -36.6F, -49.5F);
        this.BodyFur3.addBox(0.0F, 0.0F, 0.0F, 29, 2, 22, 0.0F);
        this.LegBkBottomL = new MowzieModelRenderer(this, 0, 156);
        this.LegBkBottomL.setRotationPoint(0.0F, 20.0F, -0.9F);
        this.LegBkBottomL.addBox(-5.0F, -1.6F, -9.3F, 10, 6, 11, 0.0F);
        this.LeftFrntBottomL = new MowzieModelRenderer(this, 0, 156);
        this.LeftFrntBottomL.setRotationPoint(0.0F, 21.6F, -1.0F);
        this.LeftFrntBottomL.addBox(-5.0F, -1.6F, -9.3F, 10, 6, 11, 0.0F);
        this.LegBkTopL = new MowzieModelRenderer(this, 0, 122);
        this.LegBkTopL.setRotationPoint(-11.5F, -0.1F, 34.6F);
        this.LegBkTopL.addBox(-5.0F, 0.0F, -10.3F, 10, 20, 11, 0.0F);
        this.Trunk3 = new MowzieModelRenderer(this, 0, 0);
        this.Trunk3.setRotationPoint(1.2F, 15.0F, 1.4F);
        this.Trunk3.addBox(-4.9F, 1.1F, -3.0F, 9, 8, 5, 0.0F);
        this.setRotateAngle(Trunk3, 0.17453292519943295F, -0.0F, 0.0F);
        this.LegBackJointR = new MowzieModelRenderer(this, 0, 0);
        this.LegBackJointR.setRotationPoint(8.7F, -5.0F, -2.8F);
        this.LegBackJointR.addBox(-5.9F, -0.3F, -10.3F, 12, 10, 14, 0.0F);
        this.EarRight = new MowzieModelRenderer(this, 0, 0);
        this.EarRight.setRotationPoint(22.6F, -1.7F, 2.9F);
        this.EarRight.addBox(0.0F, -8.0F, 0.0F, 9, 17, 1, 0.0F);
        this.setRotateAngle(EarRight, 0.08115781021773633F, -0.08709192967451705F, -0.07016223593017204F);
        this.BodyFur1 = new MowzieModelRenderer(this, 0, 0);
        this.BodyFur1.setRotationPoint(-17.0F, -31.3F, -7.4F);
        this.BodyFur1.addBox(0.0F, 0.0F, -15.6F, 31, 5, 15, 0.0F);
        this.setRotateAngle(BodyFur1, -0.18203784098300857F, -0.0F, 0.0F);
        this.LegBkTopR = new MowzieModelRenderer(this, 0, 122);
        this.LegBkTopR.setRotationPoint(9.5F, -0.3F, 34.6F);
        this.LegBkTopR.addBox(-5.0F, 0.0F, -10.3F, 10, 20, 11, 0.0F);
        this.SideFurL = new MowzieModelRenderer(this, 130, 0);
        this.SideFurL.setRotationPoint(-17.0F, -2.0F, -40.0F);
        this.SideFurL.addBox(0.0F, 0.0F, 0.0F, 0, 6, 29, 0.0F);
        this.LegFrntTopR = new MowzieModelRenderer(this, 0, 122);
        this.LegFrntTopR.setRotationPoint(10.0F, 12.0F, -13.3F);
        this.LegFrntTopR.addBox(-5.0F, 0.0F, -10.3F, 10, 20, 11, 0.0F);
        this.Tusk2R = new MowzieModelRenderer(this, 160, 40);
        this.Tusk2R.setRotationPoint(8.8F, 23.9F, -20.7F);
        this.Tusk2R.addBox(0.0F, 0.0F, 0.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(Tusk2R, -1.2107349021084663F, -0.10419615634406146F, -0.10524335389525807F);
        this.Tusk1R = new MowzieModelRenderer(this, 160, 40);
        this.Tusk1R.setRotationPoint(7.4F, 15.0F, -15.6F);
        this.Tusk1R.addBox(0.0F, 0.0F, 0.0F, 3, 12, 3, 0.0F);
        this.setRotateAngle(Tusk1R, -0.5649630788705644F, -0.10419615634406146F, -0.09267698328089889F);
        this.LegBackJointL = new MowzieModelRenderer(this, 0, 0);
        this.LegBackJointL.setRotationPoint(-11.9F, -5.0F, -2.8F);
        this.LegBackJointL.addBox(-5.9F, -0.3F, -10.3F, 12, 10, 14, 0.0F);
        this.EarLeft = new MowzieModelRenderer(this, 0, 0);
        this.EarLeft.setRotationPoint(-11.7F, -5.0F, -7.0F);
        this.EarLeft.addBox(-9.0F, -8.0F, 0.0F, 9, 17, 1, 0.0F);
        this.setRotateAngle(EarLeft, 0.045553093477052F, 0.08709192967451705F, 0.07016223593017204F);
        this.TailAttchedToBody = new MowzieModelRenderer(this, 0, 176);
        this.TailAttchedToBody.setRotationPoint(-1.0F, -19.5F, -1.1F);
        this.TailAttchedToBody.addBox(0.0F, 0.0F, 0.0F, 2, 13, 2, 0.0F);
        this.setRotateAngle(TailAttchedToBody, 0.5009094953223726F, -0.0F, 0.0F);
        this.Trunk4 = new MowzieModelRenderer(this, 0, 0);
        this.Trunk4.setRotationPoint(0.8F, 22.6F, 3.1F);
        this.Trunk4.addBox(-3.6F, -1.1F, -3.0F, 7, 8, 4, 0.0F);
        this.setRotateAngle(Trunk4, 0.3490658503988659F, -0.0F, 0.0F);
        this.TailAttchedToTail = new MowzieModelRenderer(this, 11, 182);
        this.TailAttchedToTail.setRotationPoint(-0.6F, 12.1F, 0.5F);
        this.TailAttchedToTail.addBox(0.0F, 0.0F, 0.0F, 3, 3, 0, 0.0F);
        this.setRotateAngle(TailAttchedToTail, 0.3141592653589793F, -0.0F, 0.0F);
        this.LegBkBottomR = new MowzieModelRenderer(this, 0, 156);
        this.LegBkBottomR.setRotationPoint(0.0F, 20.0F, -1.0F);
        this.LegBkBottomR.addBox(-5.0F, -1.6F, -9.3F, 10, 6, 11, 0.0F);
        this.BodyFur2 = new MowzieModelRenderer(this, 0, 0);
        this.BodyFur2.setRotationPoint(-17.6F, -34.7F, -50.5F);
        this.BodyFur2.addBox(0.0F, 0.0F, 0.0F, 31, 6, 28, 0.0F);
        this.BodyBack.addChild(this.BodyFront);
        this.Trunk1.addChild(this.Trunk5);
        this.BodyBack.addChild(this.Head);
        this.Head.addChild(this.Tusk1L);
        this.BodyBack.addChild(this.BodyFur4);
        this.Head.addChild(this.Tusk2L);
        this.BodyBack.addChild(this.SideFurR);
        this.Head.addChild(this.HeadFur);
        this.BodyFront.addChild(this.LegFrntTopL);
        this.Trunk1.addChild(this.Trunk2);
        this.Head.addChild(this.Trunk1);
        this.LegFrntTopR.addChild(this.LegFrntBottomR);
        this.Head.addChild(this.TuskLipLeft);
        this.Head.addChild(this.TuskLipRight);
        this.Head.addChild(this.Mouth);
        this.BodyBack.addChild(this.BodyFur3);
        this.LegBkTopL.addChild(this.LegBkBottomL);
        this.LegFrntTopL.addChild(this.LeftFrntBottomL);
        this.Trunk1.addChild(this.Trunk3);
        this.BodyBack.addChild(this.LegBackJointR);
        this.EarLeft.addChild(this.EarRight);
        this.BodyBack.addChild(this.BodyFur1);
        this.BodyBack.addChild(this.SideFurL);
        this.BodyFront.addChild(this.LegFrntTopR);
        this.Head.addChild(this.Tusk2R);
        this.Head.addChild(this.Tusk1R);
        this.BodyBack.addChild(this.LegBackJointL);
        this.Head.addChild(this.EarLeft);
        this.BodyBack.addChild(this.TailAttchedToBody);
        this.Trunk1.addChild(this.Trunk4);
        this.TailAttchedToBody.addChild(this.TailAttchedToTail);
        this.LegBkTopR.addChild(this.LegBkBottomR);
        this.BodyBack.addChild(this.BodyFur2);

		parts = new MowzieModelRenderer[] {LegBkTopR, LegBkTopL, BodyBack, LegBkBottomR, LegBkBottomL, BodyFront, BodyFur1, BodyFur2, BodyFur3, BodyFur4, TailAttchedToBody, Head, SideFurR, SideFurL, LegBackJointL, LegBackJointR, LegFrntTopR, LegFrntTopL, LegFrntBottomR, LeftFrntBottomL, TailAttchedToTail, EarLeft, TuskLipRight, TuskLipLeft,
				Tusk1R, Tusk2R, Tusk1L, Tusk2L, Mouth, Trunk1, Trunk2, Trunk3, Trunk4, Trunk5, EarRight, HeadFur};
		trunkParts = new MowzieModelRenderer[] {Trunk1, Trunk2, Trunk3, Trunk4, Trunk5};  
		earParts = new MowzieModelRenderer[] {EarLeft, EarRight};  
		tailParts = new MowzieModelRenderer[] {TailAttchedToBody, TailAttchedToTail};
		setInitPose();
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		animate(f, f1, f2, f3, f4, f5, entity);
		this.LegBkTopR.render(f5);
		this.LegBkTopL.render(f5);
		this.BodyBack.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(MowzieModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		setToInitPose();
		this.LegBkTopR.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
		this.LegBkTopL.rotateAngleX += MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
		this.LegBkTopR.rotateAngleZ += 0.0F;
		this.LegBkTopL.rotateAngleZ += 0.0F;
		this.LegFrntTopR.rotateAngleX += MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		this.LegFrntTopL.rotateAngleX += MathHelper.cos(f * 0.6662F + (float) Math.PI) * 1.4F * f1;
		this.LegFrntTopR.rotateAngleY += 0.0F;
		this.LegFrntTopL.rotateAngleY += 0.0F;
		
		this.chainWave(trunkParts, 1, 0.5F, 1, f, f1);
		this.chainSwing(earParts, 1, 0.2F, 2, f, f1);
		this.chainWave(tailParts, 1, 0.5F, 1, f, f1);
	}

	public void animate(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		animator.update((IAnimatedEntity) entity);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		animator.setAnim(1);
		animator.startPhase(10);
		animator.rotate(Head, 0.5F, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(5);
		animator.startPhase(10);
		animator.rotate(Head, -0.8F, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(3);
		animator.resetPhase(2);
		
		animator.setAnim(2);
		animator.startPhase(30);
		animator.rotate(BodyBack, -0.5F, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(15);
		animator.startPhase(20);
		animator.rotate(BodyBack, 0, 0, 0);
		animator.endPhase();
		animator.setStationaryPhase(6);
		animator.resetPhase(14);
	}
}
