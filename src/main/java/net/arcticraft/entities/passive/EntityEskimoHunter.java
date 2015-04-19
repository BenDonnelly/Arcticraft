package net.arcticraft.entities.passive;

import net.arcticraft.entities.hostile.EntityBoar;
import net.arcticraft.item.ACItems;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityEskimoHunter extends EntityEskimoDefault
{
	public EntityEskimoHunter(World par1World)
	{
		super(par1World);
		this.targetTasks.addTask(9, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityBoar.class, 16, true));
		this.targetTasks.addTask(6, new EntityAINearestAttackableTarget(this, EntityPenguin.class, 16, true));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, EntityPenguin.class, 1.0D, false));
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, EntityBoar.class, 1.0D, false));
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		
	}

	@Override
	protected Item getDropItem()
	{
		return Items.stick;
	}

	@Override
	public void func_110297_a_(ItemStack itemstack)
	{
		addStuffToBuy(ACItems.woodenClub, 1, 1, 0.5F);
		addStuffToBuy(ACItems.frostStick, 1, 5, 0.5F);
		addStuffToBuy(Items.stick, 12, 54, 0.6F);
		addStuffToSell(ACItems.frostWoodSword, 1, 1, 0.8F);
		addStuffToSell(ACItems.rigentemSword, 1, 5, 0.69F);
	}
}