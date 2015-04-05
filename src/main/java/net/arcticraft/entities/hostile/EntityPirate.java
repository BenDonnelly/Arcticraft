package net.arcticraft.entities.hostile;

import java.util.Random;

import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityPirate extends EntityMob{

	private Random rand = new Random();
	public boolean isSwinging = false;

	public EntityPirate(World world){
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 16, true));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(25.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.33000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}
	
	@Override
	public boolean canDespawn()
	{
		return false;
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		boolean flag = super.attackEntityAsMob(par1Entity);
		int damage = 0;
		if(this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) damage = 0;
		if(this.worldObj.difficultySetting == EnumDifficulty.EASY) damage = 1;
		if(this.worldObj.difficultySetting == EnumDifficulty.NORMAL) damage = 2;
		if(this.worldObj.difficultySetting == EnumDifficulty.HARD) damage = 3;
		if(flag && this.getHeldItem() == null && this.isBurning() && this.rand.nextFloat() < damage * 0.3F)
		{
			par1Entity.setFire(2 * damage);
		}
		return flag;
	}

	@Override
	public int getTotalArmorValue()
	{
		return 4;
	}

	@Override
	public void swingItem()
	{
		if(!this.isSwinging || this.swingProgressInt >= this.getSwingSpeedModifier() / 2 || this.swingProgressInt < 0)
		{
			this.swingProgressInt = -1;
			this.isSwinging = true;
		}
	}

	private int getSwingSpeedModifier()
	{
		return this.isPotionActive(Potion.digSpeed) ? 6 - (1 + this.getActivePotionEffect(Potion.digSpeed).getAmplifier()) * 1 : (this.isPotionActive(Potion.digSlowdown) ? 6 + (1 + this.getActivePotionEffect(Potion.digSlowdown).getAmplifier()) * 2 : 6);
	}


	@Override
	protected String getLivingSound()
	{
		return Arcticraft.MOD_ID + ":mob.pirate.living";
	}

	@Override
	protected String getHurtSound()
	{
		return Arcticraft.MOD_ID + ":mob.pirate.hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return Arcticraft.MOD_ID + ":mob.pirate.death";
	}

	@Override
	public void onCollideWithPlayer(EntityPlayer player)
	{
		this.swingItem();
		super.onCollideWithPlayer(player);
	}

	@Override
	protected void updateEntityActionState()
	{
		int var1 = this.getSwingSpeedModifier();
		if(this.isSwinging)
		{
			++this.swingProgressInt;
			if(this.swingProgressInt >= var1)
			{
				this.swingProgressInt = 0;
				this.isSwinging = false;
			}
		}
		else
		{
			this.swingProgressInt = 0;
		}
		this.swingProgress = (float) this.swingProgressInt / (float) var1;
		super.updateEntityActionState();
	}

	@Override
	public ItemStack getHeldItem()
	{
		return new ItemStack(Items.iron_sword, 1);
	}

	@Override
	protected Item getDropItem()
	{
		return Items.iron_sword;
	}
	
	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

}
