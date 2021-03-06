package net.arcticraft.entities.ai;

import net.arcticraft.entities.hostile.EntityBoar;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

public class EntityAIHeadbutt extends AIAnimation{

	private EntityBoar entityBoar;
	private EntityLivingBase attackTarget;

	public EntityAIHeadbutt(EntityBoar boar){
		super(boar);
		entityBoar = boar;
		attackTarget = null;
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();
		attackTarget = entityBoar.getAttackTarget();
	}

	@Override
	public void updateTask()
	{
		if(entityBoar.getAnimTick() < 10 && attackTarget != null)
		{
			entityBoar.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
		}
		if(entityBoar.getAnimTick() == 10 && attackTarget != null)
		{
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityBoar), 5);//headbutt increases damage to 2.5hearts instead of 1
			attackTarget.motionX *= 1;
			attackTarget.motionY *= 1.5F;
			attackTarget.motionZ *= 1;
		}
		
	}

	public int getAnimID()
	{
		return 1;
	}

	public boolean isAutomatic()
	{
		// true = something else triggers the animation
		// false = animation triggers itself
		return true;
	}

	public int getDuration()
	{
		return 20;
	}
}
