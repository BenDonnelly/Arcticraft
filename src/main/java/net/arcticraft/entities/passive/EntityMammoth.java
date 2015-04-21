package net.arcticraft.entities.passive;

import net.arcticraft.entities.ai.EntityAIFling;
import net.arcticraft.entities.ai.EntityAIStandUp;
import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.entities.hostile.EntityFrostZombie;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityMammoth extends EntityMob implements IAnimatedEntity{

	private int animID;
	private int animTick;

	public EntityMammoth(World world){
		super(world);
		this.setSize(3.3F, 4.0F);
		this.tasks.addTask(2, new EntityAIFling(this));
		this.tasks.addTask(2, new EntityAIStandUp(this));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityBoar.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityFrostZombie.class, 0, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(75.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		// increment the animTick if there is an animation playing
		if(animID != 0) animTick++;
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{
		float distanceFromTarget = (float) Math.sqrt(Math.pow((posX - getAttackTarget().posX), 2) + Math.pow((posZ - getAttackTarget().posZ), 2));
		if(this.animID == 0 && distanceFromTarget <= 4.0F)
		{
			AnimationAPI.sendAnimPacket(this, 1);
		}
		return true;
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		this.playSound(Arcticraft.MOD_ID + ":mob.caveman.footstep", 1.15F, 0.6F);
	}

	
	@Override
	public void setAnimID(int id)
	{
		animID = id;
	}

	@Override
	public void setAnimTick(int tick)
	{
		animTick = tick;
	}

	@Override
	public int getAnimID()
	{
		return animID;
	}

	@Override
	public int getAnimTick()
	{
		return animTick;
	}

}
