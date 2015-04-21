package net.arcticraft.entities.ai;

import net.arcticraft.entities.passive.EntityMammoth;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import thehippomaster.AnimationAPI.AIAnimation;

public class EntityAIFling extends AIAnimation{

	private EntityMammoth entityMammoth;
	private EntityLivingBase attackTarget;

	public EntityAIFling(EntityMammoth mammoth){
		super(mammoth);
		entityMammoth = mammoth;
		attackTarget = null;
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();
		attackTarget = entityMammoth.getAttackTarget();
	}

	@Override
	public void updateTask()
	{
		if(entityMammoth.getAnimTick() < 12 && attackTarget != null)
		{
			entityMammoth.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
		}
		if(entityMammoth.getAnimTick() == 15 && attackTarget != null)
		{
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityMammoth), 2);
			attackTarget.motionY *= 2.5F;
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
		return 30;
	}
}
