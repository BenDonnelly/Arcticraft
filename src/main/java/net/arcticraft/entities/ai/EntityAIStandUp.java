package net.arcticraft.entities.ai;

import net.arcticraft.main.Arcticraft;
import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityAIStandUp extends AIAnimation{

	public EntityAIStandUp(IAnimatedEntity entity){
		super(entity);
	}

	@Override
	public boolean shouldAnimate()
	{
		EntityLiving living = this.getEntity();

		if(living.getAttackTarget() != null) return false;

		IAnimatedEntity entity = (IAnimatedEntity) living;
		return entity.getAnimID() == 0 && living.getRNG().nextInt(100) == 0;
	}

	public void resetTask() {
		super.resetTask();
		EntityLiving living = this.getEntity();
		living.playSound(Arcticraft.MOD_ID + ":mob.mammoth.trumpet", 1.15F, 0.6F);
	}
	
	@Override
	public int getAnimID()
	{
		return 2;
	}

	@Override
	public boolean isAutomatic()
	{
		return false;
	}

	@Override
	public int getDuration()
	{
		return 85;
	}

}
