package net.arcticraft.entities.passive;

import java.util.Random;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class EntityCaveman extends EntityMob{

	private Random rand = new Random();
	private boolean collectedReward = false;
	private int angerLevel = 0;
	private static final ItemStack[] rewards = new ItemStack[] {new ItemStack(ACItems.boarMeatCooked, 4), new ItemStack(ACItems.itemSled), new ItemStack(ACItems.eriumGem, 10), new ItemStack(ACItems.frigus, 4), /* new ItemStack(ACItems.heatPack) */};
	private String[][] messages = {

			{"WOOO, Im out! Here take this!", "Finally i'm out, it's been " + rand.nextInt(20000 - 1000 + 1) + " centuries. I suppose you can take this as a reward", "Thank you for getting me out of there, take this as a token of my gratitude", "I can't believe it! Im actually out! I suppose you expect something now, well, this is all I have"},

			{"You're just going to give me it? just like that? From this day fourth, you are the one I answer to", "This is what I've been searching for my entire life! I can never give something back which is equally amazing as this is, but if you need anything just ask!",
					"It's glorious! Its all that I imagined and more. I can't re-pay you back fully, but I'll do anything you want"},

			{"I don't have anything else to give you, sorry", "I said I don't have anything else", "Go away!", "I HAVE NOTHING ELSE", "I'll give you one last chance to leave me alone!"}

	};

	public EntityCaveman(World world){
		super(world);
		this.setSize(0.9F, 1.9F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
		// Movement Speed
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
		// Attack damage
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
	}

	@Override
	public boolean interact(EntityPlayer player)
	{
		ItemStack hand = player.inventory.getCurrentItem();
		int number = rand.nextInt(7);
		if(!worldObj.isRemote)
		{
			if(this.entityToAttack != player)
			{
				if(collectedReward == false)
				{
					player.addChatMessage(new ChatComponentText(messages[0][rand.nextInt(messages.length)]));
					if(number < rewards.length)
					{
						worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, rewards[number]));
					}
					else
					{
						worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(ACItems.glacierFruit, 3)));
					}
					this.cavemanTameEffect(true);
					collectedReward = true;
					return true;
				}
			}
			else{
				player.addChatMessage(new ChatComponentText("No reward for you! I'm going to kill you"));
			}
		}
		if(collectedReward)
		{
			if(angerLevel >= 0 && angerLevel < 5)
			{
				player.addChatMessage(new ChatComponentText(messages[2][angerLevel]));
				if(angerLevel < 6)
				{
					++angerLevel;
					this.cavemanTameEffect(false);
				}
			}
			else
			{
				player.addChatMessage(new ChatComponentText("Right, thats it! You're in for it now!"));
				this.setAttackTarget(player);
			}
		}
		return super.interact(player);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	@Override
	public void writeEntityToNBT(NBTTagCompound nbt)
	{
		super.writeEntityToNBT(nbt);
		nbt.setBoolean("Reward", this.collectedReward);
		nbt.setInteger("angerLevel", this.angerLevel);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt)
	{
		super.readEntityFromNBT(nbt);
		this.collectedReward = nbt.getBoolean("Reward");
		this.angerLevel = nbt.getInteger("angerLevel");
	}

	private void cavemanTameEffect(boolean effect)
	{
		String type = effect ? "heart" : "smoke";
		for(int i = 0; i < 7; ++i)
		{
			double d0 = this.rand.nextGaussian() * 0.02D;
			double d1 = this.rand.nextGaussian() * 0.02D;
			double d2 = this.rand.nextGaussian() * 0.02D;
			Minecraft.getMinecraft().theWorld.spawnParticle(type, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + 0.5D + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d0, d1, d2);
		}
	}

	@Override
	protected void dropFewItems(boolean attackedRecently, int lootingLevel)
	{
		int randNum = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
		int i;
		for(i = 0; i < randNum; ++i)
		{
			this.dropItem(Item.getItemFromBlock(ACBlocks.frostWaterIce), 1);
		}
		randNum = this.rand.nextInt(2);
		if(randNum == 0)
		{
			this.dropItem(ACItems.woodenClub, 1);
		}
	}

	@Override
	public ItemStack getHeldItem()
	{
		return new ItemStack(ACItems.woodenClub);
	}

	@Override
	public boolean canDespawn()
	{
		return true;
	}

	@Override
	public String getLivingSound()
	{
		return Arcticraft.MOD_ID + ":mob.caveman.living";
	}

	@Override
	public String getHurtSound()
	{
		return Arcticraft.MOD_ID + ":mob.caveman.hurt";
	}

	@Override
	public String getDeathSound()
	{
		return Arcticraft.MOD_ID + ":mob.caveman.death";
	}

}
