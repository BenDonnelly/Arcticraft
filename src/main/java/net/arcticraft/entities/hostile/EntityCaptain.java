package net.arcticraft.entities.hostile;

import net.arcticraft.block.ACBlocks;
import net.arcticraft.entities.ACIBossDisplayData;
import net.arcticraft.entities.EntityCaptainHook;
import net.arcticraft.entities.ai.EntityAICaptainAttack;
import net.arcticraft.entities.ai.EntityAIHookAttack;
import net.arcticraft.item.ACItems;
import net.arcticraft.item.ACPotions;
import net.arcticraft.main.Arcticraft;
import net.arcticraft.main.RopePositionPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityCaptain extends EntityMob implements ACIBossDisplayData, IRangedAttackMob{

	public final static String[] bossNames = {"Caladan", "Arthen", "Farem", "Thoran", "Icyrus", "Meznar", "Kefadan", "Lonleh", "Ladur", "Brens", "Petern", "Cevan", "Tob"};
	private final String bossName;
	public final int hookAnimationTime = 20;
	public final int maxHookCooldown = 120;
	private int hookCooldown;
	private boolean isHookAirBorne;

	public EntityCaptain(World world){
		super(world);
		this.setHealth(this.getMaxHealth());
		this.setSize(this.width, this.height + 0.4F);
		this.setAIMoveSpeed(0.2F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIHookAttack(this, 1.0D, 16.0F));
		this.tasks.addTask(2, new EntityAICaptainAttack(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 16.0F));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
		this.experienceValue = 300;
		this.hookCooldown = this.maxHookCooldown;
		this.bossName = bossNames[this.worldObj.rand.nextInt(bossNames.length)];
	}

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public void onLivingUpdate()
	{
		if(this.hookCooldown > 0)
		{
			this.hookCooldown--;
		}
		else if(this.hookCooldown == 0)
		{
			this.prepareHookAttack();
		}
		super.onLivingUpdate();
	}

	private void prepareHookAttack()
	{
		this.hookCooldown = -1;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(275.0D);
		// Follow Range - default 32.0D - min 0.0D - max 2048.0D
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.36000000417232513D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	}

	@Override
	public boolean attackEntityAsMob(Entity par1Entity)
	{
		if(super.attackEntityAsMob(par1Entity))
		{
			if(par1Entity instanceof EntityLivingBase)
			{
				((EntityLivingBase) par1Entity).addPotionEffect(new PotionEffect(ACPotions.frostbitePotion.id, 100, 0));
			}
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public ItemStack getHeldItem()
	{
		return new ItemStack(ACItems.captainSword, 1);
	}

	public ItemStack getHookItem()
	{
		return new ItemStack(ACItems.captainsHook, 1);
	}

	@Override
	protected void dropFewItems(boolean beenHit, int lootingLevel)
	{
		this.dropItem(ACItems.captainSword, 1);
		this.dropItem(Item.getItemFromBlock(ACBlocks.captainStatue), 1);
		this.dropItem(ACItems.captainsLog, 1);
	}

	@Override
	public boolean canDespawn()
	{
		return false;
	}

	public String getEntityName()
	{
		return "Captain " + this.bossName;
	}

	public boolean isMiniBoss()
	{
		return true;
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return !this.isDead;
	}

	public boolean isAboutToThrowHook()
	{
		return this.hookCooldown == -1;
	}

	public boolean isHookAirBorne()
	{
		return this.isHookAirBorne;
	}

	public void setHookAirBorne(boolean bool)
	{
		this.isHookAirBorne = bool;
	}

	public void resetHookCooldown()
	{
		this.hookCooldown = this.maxHookCooldown;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float f)
	{
		EntityCaptainHook hook = new EntityCaptainHook(this.worldObj, this);
		double rotation = (this.rotationYaw + 70.0F) / (180.0F / Math.PI);
		double hookLaunchX = Math.cos(rotation);
		double hookLaunchY = 1.4D;
		double hookLaunchZ = Math.sin(rotation);
		hook.setLocationAndAngles(this.posX + hookLaunchX, this.posY + hookLaunchY, this.posZ + hookLaunchZ, this.rotationYaw, this.rotationPitch);
		double dx = target.posX - hook.posX;
		double dy = target.posY + (double) target.getEyeHeight() - 1.1D - hook.posY;
		double dz = target.posZ - hook.posZ;
		float f1 = MathHelper.sqrt_double(dx * dx + dz * dz) * 0.4F;
		hook.setThrowableHeading(dx, dy + (double) f1, dz, hook.func_70182_d(), 1.0F);
		this.playSound("ac:mobs.captain_poof", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.worldObj.playSoundAtEntity(this, "ac:mobs.captain_rope", 0.7F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));	
		
		// TODO: Fix packet bug / server side world shit
		if (!this.worldObj.isRemote)
	    {
			Minecraft.getMinecraft().theWorld.spawnEntityInWorld(hook);
	    }

		Arcticraft.arcticraftInstance.network.sendToServer(new RopePositionPacket(this.getEntityId(), hook.getEntityId()));
		
		this.resetHookCooldown();
		this.isHookAirBorne = true;
	}

}
