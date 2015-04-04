package net.arcticraft.entities;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;

public class EntityAICaptainAttack extends EntityAIAttackOnCollide{

	private EntityCaptain captain;

	public EntityAICaptainAttack(EntityCaptain captain, Class par2Class, double par3, boolean par5){
		super(captain, par2Class, par3, par5);
		this.captain = captain;
	}

	@Override
	public boolean shouldExecute()
	{
		return !this.captain.isHookAirBorne() && super.shouldExecute();
	}
}
