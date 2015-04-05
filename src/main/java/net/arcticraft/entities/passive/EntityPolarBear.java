package net.arcticraft.entities.passive;

import java.util.List;
import java.util.UUID;

import net.arcticraft.item.ACItems;
import net.arcticraft.main.Arcticraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPolarBear extends EntityMob
{

	private static final UUID field_110189_bq = UUID.fromString("49455A49-7EC5-45BA-B886-3B90B23A1718");
    private static final AttributeModifier field_110190_br = (new AttributeModifier(field_110189_bq, "Attacking speed boost", 0.45D, 0)).setSaved(false);

	/** Above zero if this PolarBear is Angry. */
	private int angerLevel = 0;

	/** A random delay until this PolarBear next makes a sound. */
	private int randomSoundDelay = 0;
	private Entity field_110191_bu;

	public EntityPolarBear(World par1World)
	{
		super(par1World);
		this.setSize(1.9F, 1.8F);
	}

	@Override
	protected boolean isAIEnabled()
	{
		return false;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		// Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
		// Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.699D);
		// Attack Damage - default 2.0D - min 0.0D - max Doubt.MAX_VALUE
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
	}

	@Override
	public void onUpdate()
	{
		if(this.field_110191_bu != this.entityToAttack && ! this.worldObj.isRemote)
		{
			IAttributeInstance attributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
			attributeinstance.removeModifier(field_110190_br);

			if(this.entityToAttack != null)
			{
				attributeinstance.applyModifier(field_110190_br);
			}
		}

		this.field_110191_bu = this.entityToAttack;

		if(this.randomSoundDelay > 0 && --this.randomSoundDelay == 0)
		{
			this.playSound(Arcticraft.MOD_ID + ":mobs.polar_bear.angry", this.getSoundVolume() * 2.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 1.8F);
		}

		super.onUpdate();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("Anger", (short) this.angerLevel);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.angerLevel = par1NBTTagCompound.getShort("Anger");
	}

	/**
	 * Finds the closest player within 16 blocks to attack, or null if this
	 * Entity isn't interested in attacking (Animals, Spiders at day, peaceful
	 * PigZombies).
	 */
	@Override
	protected Entity findPlayerToAttack()
	{
		return this.angerLevel == 0 ? null : super.findPlayerToAttack();
	}

	@Override
	public boolean attackEntityFrom(DamageSource dmgSrc, float damage)
	{
		if(this.isEntityInvulnerable())
		{
			return false;
		}
		else
		{
			Entity entity = dmgSrc.getEntity();

			if(entity instanceof EntityPlayer)
			{
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

				for(int i = 0; i < list.size(); ++i)
				{
					Entity entity1 = (Entity) list.get(i);

					if(entity1 instanceof EntityPolarBear)
					{
						EntityPolarBear AC_EntityPolarBear = (EntityPolarBear) entity1;
						AC_EntityPolarBear.becomeAngryAt(entity);
					}
				}

				this.becomeAngryAt(entity);
			}

			return super.attackEntityFrom(dmgSrc, damage);
		}
	}

	private void becomeAngryAt(Entity par1Entity)
	{
		this.entityToAttack = par1Entity;
		this.angerLevel = 400 + this.rand.nextInt(400);
		this.randomSoundDelay = this.rand.nextInt(40);
	}

	@Override
	protected String getLivingSound()
	{
		return Arcticraft.MOD_ID + ":mobs.polar_bear.living";
	}

	@Override
	protected String getHurtSound()
	{
		return Arcticraft.MOD_ID + ":mobs.polar_bear.hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return Arcticraft.MOD_ID + ":mobs.polar_bear.death";
	}

	@Override
	protected void dropFewItems(boolean recentlyHit, int lootingLevel)
	{
		int randNum = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
		int i;

		for(i = 0; i < randNum; ++i)
		{
			this.dropItem(ACItems.penguinMeat, 1);
		}

		randNum = this.rand.nextInt(3) + this.rand.nextInt(1 + lootingLevel);

		for(i = 0; i < randNum; ++i)
		{
			this.dropItem(Items.fish, 1);
		}
	}

}