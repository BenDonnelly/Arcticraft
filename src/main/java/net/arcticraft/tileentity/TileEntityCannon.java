package net.arcticraft.tileentity;

import net.arcticraft.entities.EntityCannonball;
import net.arcticraft.main.Arcticraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCannon extends TileEntity{

	public boolean isLoaded;
	private int fuse;

	@Override
	public void updateEntity()
	{
		if(isLoaded)
		{
			fuse++;
			if(fuse == 100)
			{
				EntityCannonball cannonball = new EntityCannonball(worldObj, this.xCoord, this.yCoord, this.zCoord);
				double x = this.xCoord + 0.5D;
				double y = this.yCoord + 2.0D;
				double z = this.zCoord + 0.5D;
				double velY = 0.4D;
				double velXZ = 1.5D;
				if(this.getBlockMetadata() == 4)
				{
					cannonball.setPosition(x, y, z + 2D);
					cannonball.setVelocity(0, 0.4, 1.5);
				}
				else if(this.getBlockMetadata() == 3)
				{
					cannonball.setPosition(x + 2D, y, z);
					cannonball.setVelocity(1.5, 0.4, 0);
				}
				else if(this.getBlockMetadata() == 2)
				{
					cannonball.setPosition(x, y, z - 2D);
					cannonball.setVelocity(0, 0.4, -1.5);
				}
				else if(this.getBlockMetadata() == 1)
				{
					cannonball.setPosition(x - 2D, y, z);
					cannonball.setVelocity(-1.5, 0.4, 0);
				}
				this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, 0);
				worldObj.spawnEntityInWorld(cannonball);
				isLoaded = false;
				fuse = 0;
				worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, this.getBlockMetadata(), 2);
			}
		}
	}

	@Override
	public boolean receiveClientEvent(int ID, int something)
	{
		if(ID == 1)
		{
			this.worldObj.playSound(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, Arcticraft.MOD_ID + ":block.cannon", 4.0F, 0.6F + (this.worldObj.rand.nextFloat() - 0.5F) / 10F, false);
			return true;
		}
		else
		{
			return super.receiveClientEvent(ID, something);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.isLoaded = compound.getBoolean("Loaded");
		this.fuse = compound.getInteger("Fuse");
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setBoolean("Loaded", isLoaded);
		compound.setInteger("Fuse", fuse);
	}

}
