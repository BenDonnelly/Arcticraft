package net.arcticraft.entities.ai;

import net.arcticraft.entities.hostile.EntityCaptain;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;

public class EntityAIHookAttack extends EntityAIArrowAttack{

	private EntityCaptain captain;

	public EntityAIHookAttack(EntityCaptain entity, double par2, float par5){
		super((IRangedAttackMob) entity, par2, entity.hookAnimationTime, par5);
		this.captain = entity;
	}

	@Override
	public boolean shouldExecute()
	{
		return this.captain.isAboutToThrowHook() && super.shouldExecute();
	}

	@Override
	public void updateTask()
	{
		super.updateTask();
		// Stands still
		this.captain.getNavigator().clearPathEntity();
	}
}
