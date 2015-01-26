package net.arcticraft.entities.passive;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPenguin extends EntityAnimal{

	public EntityPenguin(World world){
		super(world);
		double speed = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
		this.setSize(0.9F, 0.9F);
		tasks.addTask(0, new EntityAISwimming(this));
		tasks.addTask(1, new EntityAIPanic(this, speed));
		tasks.addTask(2, new EntityAIMate(this, speed));
		tasks.addTask(3, new EntityAITempt(this, speed, Items.cooked_fished, false));
		tasks.addTask(4, new EntityAIFollowParent(this, speed));
		tasks.addTask(5, new EntityAIWander(this, speed));
		tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		tasks.addTask(7, new EntityAILookIdle(this));
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
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
	}

	// TODO Penguin sounds
	/*
	 * @Override protected String getLivingSound() { return "ac:mobs.penguin_idle"; }
	 * 
	 * protected String getHurtSound() { return "ac:mobs.penguin_hurt"; }
	 * 
	 * protected String getDeathSound() { return "ac:mobs.penguin_death"; }
	 */

	@Override
	protected void dropFewItems(boolean recentlyHit, int lootingLevel)
	{
		int i = this.rand.nextInt(3 + lootingLevel);
		int x;
		for(x = 0; x < i; ++x)
		{
			this.dropItem(ACItems.penguinMeat, 1);
		}
		i = this.rand.nextInt(3 + lootingLevel);
		for(x = 0; x < i; ++x)
		{
			this.dropItem(ACItems.penguinFeather, 2);
		}
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entityAgeable)
	{
		return null;
	}

	public boolean getCanSpawnHere()//doesnt even get called lol, this is how it spawns,
	{
		/*int r = 8;
		System.out.println("callerino");
		for(int x = (int) (this.posX - r); x < (this.posX + r); x++)
		{
			for(int y = (int) (this.posY - r); y < (this.posY + (r / 2)); y++)
			{
				for(int z = (int) (this.posZ - r); z < (this.posZ + r); z++)
				{
					if(this.worldObj.getBlock(x, y, z) == ACBlocks.frostWaterIce) 
					{
						System.out.println("Penguin has spawned. Location: " + this.posX + ", " + this.posY + ", " + this.posZ);
						return true;
					}
				}
			}
		}

		return false;*/
		int i = MathHelper.floor_double(this.posX);
		int j = MathHelper.floor_double(this.boundingBox.minY);
		int k = MathHelper.floor_double(this.posZ);
		System.out.println("Penguin has spawned. Location: " + this.posX + ", " + this.posY + ", " + this.posZ);
		return this.worldObj.getBlock(i, j - 1, k) == ACBlocks.frostWaterIce;
		
	}
}
