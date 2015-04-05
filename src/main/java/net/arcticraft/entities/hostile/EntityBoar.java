package net.arcticraft.entities.hostile;

import net.arcticraft.entities.ai.EntityAIHeadbutt;
import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class EntityBoar extends EntityMob implements IAnimatedEntity{

	private int animID;
	private int animTick;

	public EntityBoar(World world){
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		// this.tasks.addTask(2, new EntityAIHeadbutt(this));
		this.tasks.addTask(3, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
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
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
	}

	@Override
	public boolean attackEntityAsMob(Entity entity)
	{ 
		// if(this.getAnimID() == 0) AnimationAPI.sendAnimPacket(this, 1);
		return entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) 2.0D);
	}

	@Override
	protected Item getDropItem()
	{
		return this.isBurning() ? ACItems.boarMeatCooked : ACItems.boarMeat;
	}

	@Override
	protected void dropFewItems(boolean recentlyHit, int lootingLevel)
	{
		int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + lootingLevel);

		for(int k = 0; k < j; ++k)
		{
			if(this.isBurning())
			{
				this.dropItem(ACItems.boarMeatCooked, 1);
			}
			else
			{
				this.dropItem(ACItems.boarMeat, 1);
			}
		}
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

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		// increment the animTick if there is an animation playing
		if(animID != 0) animTick++;
	}

	@Override
	protected String getLivingSound()
	{
		return Arcticraft.MOD_ID + ":mob.boar.living";
	}

	@Override
	protected String getHurtSound()
	{
		return Arcticraft.MOD_ID + ":mob.boar.hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return Arcticraft.MOD_ID + ":mob.boar.death";
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		this.playSound("mob.pig.step", 0.15F, 1.0F);
	}

}
