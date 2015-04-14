package net.arcticraft.entities.passive;

import net.arcticraft.item.ACItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;

public class EntityHusky extends EntityWolf{

	public EntityHusky(World world){
		super(world);
		this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityPenguin.class, 200, false));
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
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.40000001192092896D);

		if(this.isTamed())
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
		}
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();

		if(itemstack != null && itemstack.getItem() == ACItems.boarMeat && !this.isAngry())
		{
			if(!player.capabilities.isCreativeMode)
			{
				--itemstack.stackSize;
			}

			if(itemstack.stackSize <= 0)
			{
				player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack) null);
			}

			if(!this.worldObj.isRemote)
			{
				if(this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.setPathToEntity((PathEntity) null);
					this.setAttackTarget((EntityLivingBase) null);
					this.aiSit.setSitting(true);
					this.setHealth(25.0F);
					this.func_152115_b(player.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte) 7);
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte) 6);
				}
			}

			return true;
		}

		return super.interact(player);
	}

	@Override
	public void setTamed(boolean tamed)
	{
		super.setTamed(tamed);

		if(tamed)
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		}
		else
		{
			this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
		}
	}
}
