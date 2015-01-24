package net.arcticraft.entities;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ACEntity extends Entity
{
	public ACEntity(World p_i1582_1_) {
		super(p_i1582_1_);
	}

	@Override
	protected void entityInit() {
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		this.readFromNBT(p_70037_1_);
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		this.writeToNBT(p_70014_1_);
	}
}
