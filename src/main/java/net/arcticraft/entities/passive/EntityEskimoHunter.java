package net.arcticraft.entities.passive;

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
		this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
		
		addStuffToBuy(Items.stick, 12, 54, 0.6F);
	}

	@Override
	protected Item getDropItem()
	{
		return Items.stick;
	}

	@Override
	public void func_110297_a_(ItemStack itemstack)
	{
		
	}
}