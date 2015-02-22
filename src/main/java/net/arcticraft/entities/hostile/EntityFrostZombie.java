package net.arcticraft.entities.hostile;

import net.arcticraft.item.ACItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
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
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityFrostZombie extends EntityMob{

	public EntityFrostZombie(World world){
		super(world);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}

	protected boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
	}

	@Override
	public int getTotalArmorValue()
	{
		int i = super.getTotalArmorValue() + 2;

		if(i > 20)
		{
			i = 20;
		}

		return i;
	}

	@Override
	protected void dropRareDrop(int p_70600_1_)
	{
		switch(this.rand.nextInt(3)) {
		case 0:
			this.dropItem(ACItems.escariaGem, 1);
			break;
		case 1:
			this.dropItem(ACItems.boarMeatCooked, 1);
			break;
		case 2:
			this.dropItem(ACItems.penguinFeather, 1);
		}
	}

	@Override
	protected void addRandomArmor()
	{
		super.addRandomArmor();

		if(this.rand.nextFloat() < (this.worldObj.difficultySetting == EnumDifficulty.HARD ? 0.05F : 0.01F))
		{
			int randNum = this.rand.nextInt(3);

			if(randNum == 0)
			{
				this.setCurrentItemOrArmor(0, new ItemStack(ACItems.escariaSword));
			}
			else
			{
				this.setCurrentItemOrArmor(0, new ItemStack(ACItems.escariaAxe));
			}
		}
	}

	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData entityData)
	{
		this.addRandomArmor();
		this.enchantEquipment();
		return (IEntityLivingData) entityData;
	}

	@Override
	protected Item getDropItem()
	{
		return Items.rotten_flesh;
	}

	@Override
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEAD;
	}

	@Override
	protected String getLivingSound()
	{
		return "mob.zombie.say";
	}

	@Override
	protected String getHurtSound()
	{
		return "mob.zombie.hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return "mob.zombie.death";
	}

	@Override
	protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
	{
		this.playSound("mob.zombie.step", 0.15F, 1.0F);
	}

}
